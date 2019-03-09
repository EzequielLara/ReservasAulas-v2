/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.vista;
import java.time.LocalDate;
import java.time.LocalTime;
import  org.iesalandalus.programacion.utilidades.Entrada ;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.PermanenciaPorHora;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.PermanenciaPorTramo;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Tramo;

/**
 *
 * @author Ezk24
 */
class Consola {
    
   
    

    private Consola() {
          
    }

    public static void mostrarMenu() {
            mostrarCabecera("Gestión de Reserva de aulas");
            int contador=0;
            for (Opcion opcion: Opcion.values()) {
                    System.out.println(contador + "."+opcion);
                    contador++;
            }
    }

    public static void mostrarCabecera(String mensaje) {
            System.out.printf("%n%s%n", mensaje);
            String cadena = "%0" + mensaje.length() + "d%n";
            System.out.println(String.format(cadena, 0).replace("0", "-"));
    }

    public static int elegirOpcion() {
            int ordinalOpcion;
                
            do {
                    System.out.println("\nElige una opción: ");
                    ordinalOpcion = Entrada.entero();
            } while (!Opcion.esOrdinalValido(ordinalOpcion));
         return ordinalOpcion;
    }

    public static Aula leerAula(){
        Aula aula=null;
        int numeroPuestos=0;
        
            System.out.println("Introduce número de puestos del aula");
            numeroPuestos=Entrada.entero();
            
        aula=new Aula(leerNombreAula(),numeroPuestos);
        return aula;
    }
        
        
    
    public static String leerNombreAula(){
    
        String nombreAula = null;
        do{
            System.out.println("Introduce nombre del aula");
            nombreAula=Entrada.cadena();
        }while(nombreAula==null||nombreAula.equals(""));
        
        return nombreAula;
    }
    
    
    public static Profesor leerProfesor(){
        String nombre=leerNombreProfesor();
        String correo;
        String telefono;
        Profesor profesor = null;
     try{
        do{
        System.out.println("Introduce el correo: ");
        correo = Entrada.cadena();
        }while(correo==null||correo.equals(""));
        
        System.out.println("Introduce el teléfono: ");
        telefono = Entrada.cadena();
        if(telefono.equals("")){
            profesor=new Profesor(nombre,correo);
        }else{
            profesor = new Profesor(nombre,correo,telefono);
        }
     }catch(IllegalArgumentException e){
         
         System.out.println(e.getMessage());
     }    
        return profesor;
       
    }
    
    public static String leerNombreProfesor(){
    
        String nombreProfesor = null;
        do{
            System.out.println("Introduce nombre del profesor: ");
            nombreProfesor=Entrada.cadena();
        }while(nombreProfesor==null||nombreProfesor.equals(""));
        
        return nombreProfesor;
    }
    
    public static Tramo leerTramo(){
        int numero= 0;
     do{
        System.out.println("Elige tramo horario: 1.Si es por la mañana y 2.Si es por la tarde");
        numero=Entrada.entero();
     }while(numero!=1&&numero!=2);
     
        if(numero==1){
            return Tramo.MANANA;
        }
        if(numero==2){
        
            return Tramo.TARDE;
        }
        return null;
    }
   
    public static String leerDia(){
     String fecha=null;
        do{
        System.out.println("Introduce una fecha con formato dd/mm/aaaa: ");
        
            fecha=Entrada.cadena();
       
        }while(fecha==null);
        return fecha;
    }
    public static String leerHora(){
     String hora;
    
        do{
        System.out.println("Introduce una hora con formato hh:mm ");
     
            hora=Entrada.cadena();
           
        }while(hora==null);
        return hora;
    }
    public static Permanencia leerPermanencia(){
        Permanencia p=null;
        int opcionPermanencia= elegirPermanencia();
        if(opcionPermanencia==1){
            return p= new PermanenciaPorHora(leerDia(),leerHora());
        }
        if(opcionPermanencia==2){
            return p=new PermanenciaPorTramo(leerDia(),leerTramo());
        }
        return p;
    }
    
    public static int elegirPermanencia(){
       int eleccion=0; 
    do{
        System.out.println("Introduce 1. Para PermanenciaHora y 2. para PermanenciaTramo.");
        eleccion=Entrada.entero();
    
       }while(eleccion<1 || eleccion>2);
    
    return eleccion;
    
    }
}
