/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.PermanenciaPorHora;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.PermanenciaPorTramo;

/**
 *
 * @author Ezk24
 */
public class Reservas {
    
    private static final float MAX_PUNTOS_PROFESOR_MES= 200f;
    private List<Reserva> coleccionReservas;
    
    public Reservas(){
      coleccionReservas=new ArrayList<Reserva>();
    }
        
    public Reservas(Reservas reserva){
    
        setReservas(reserva);
    }
      
    
    
   private void setReservas(Reservas reservas){
    
    if(reservas==null){
        throw new IllegalArgumentException("No se pueden copiar reservas nulas.");
    }else{
    
        
        coleccionReservas=copiaProfundaColeccionReservas(reservas.coleccionReservas);
    }
   }
    
    private List<Reserva> copiaProfundaColeccionReservas(List<Reserva> reservas){
        
        ArrayList<Reserva> otrasReservas = new ArrayList<Reserva>();
	for(Reserva i: reservas){
            otrasReservas.add(new Reserva(i));
        }
        return otrasReservas;
	
    }
        
        
    
    public List<Reserva> getReservas(){
    
        return copiaProfundaColeccionReservas(coleccionReservas); 
    }
    
    public int getNumReservas(){
    
        return coleccionReservas.size();
    }
    
    
    public void insertar(Reserva reserva) throws OperationNotSupportedException{
        
        if (reserva == null) {
		throw new IllegalArgumentException("No se puede realizar una reserva nula.");
	}
        if (coleccionReservas.contains(reserva)){
            throw new OperationNotSupportedException("La reserva ya existe.");
	}
        Reserva reservaDia=getReservaDia(reserva.getPermanencia().getDia());
        if(reservaDia!=null){
            if(reservaDia.getPermanencia()instanceof PermanenciaPorHora && reserva.getPermanencia()instanceof PermanenciaPorTramo){
                    throw new OperationNotSupportedException("Ya se ha realizado una reserva por hora para este día y aula.");
            }
            if(reservaDia.getPermanencia()instanceof PermanenciaPorTramo && reserva.getPermanencia()instanceof PermanenciaPorHora){
                    throw new OperationNotSupportedException("Ya se ha realizado una reserva por tramo para este día y aula.");}
            }
        
        if(!esMesSiguienteOPosterior(reserva)){
           throw new OperationNotSupportedException("Sólo se pueden hacer reservas para el mes que viene o posteriores.");
        }
        List<Reserva> reservasProfesorMes= getReservasProfesorMes(reserva.getProfesor(),reserva.getPermanencia().getDia());
        float puntosProfesor = 0;
        for(Reserva i : reservasProfesorMes){
            puntosProfesor += i.getPuntos();
        }
        float puntosTotalProfesor=getPuntosGastadosReserva(reserva)+puntosProfesor;
        if(puntosTotalProfesor>(MAX_PUNTOS_PROFESOR_MES)){
            throw new OperationNotSupportedException("Esta reserva excede los puntos máximos por mes para dicho profesor.");
            
        }else{
            coleccionReservas.add(reserva);
        }
    }
    
    private boolean esMesSiguienteOPosterior(Reserva reserva){
        
        if(reserva==null){
        
            throw new IllegalArgumentException("Sólo se pueden hacer reservas para el mes que viene o posteriores.");
        }
        
        int anioReservaIntroducida=reserva.getPermanencia().getDia().getYear();
        int mesReservaIntroducida=reserva.getPermanencia().getDia().getMonthValue();
        boolean mesSiguienteOPosterior=false;
        
        
        
            if(mesReservaIntroducida<=LocalDate.now().getMonthValue()&& (anioReservaIntroducida>LocalDate.now().getYear())){
                
                    mesSiguienteOPosterior=true;
            }        
            if(mesReservaIntroducida>LocalDate.now().getMonthValue()&& anioReservaIntroducida>=LocalDate.now().getYear()){
               
                    mesSiguienteOPosterior=true;
                
            }else{
                    mesSiguienteOPosterior=false;
            }
           
        return mesSiguienteOPosterior;
    
    }
               
                
                
        
        
    
    private float getPuntosGastadosReserva(Reserva reserva){
        if(reserva==null){
            throw new IllegalArgumentException("Esta reserva excede los puntos máximos por mes para dicho profesor.");
        }
        
        float puntosGastadosReserva=reserva.getPuntos();
        
       
        return puntosGastadosReserva;
    
    }
//    
    private List<Reserva> getReservasProfesorMes(Profesor profesor, LocalDate dia){
        if(profesor==null){
            throw new IllegalArgumentException("Datos de profesor nulos");
        
        }
        if(dia==null){
            throw new IllegalArgumentException("El día introducido no puede ser nulo.");
        }
       List<Reserva> reservasProfesorMes = new ArrayList();
       
       for(Reserva i: coleccionReservas){
           
            if(i.getProfesor().equals(profesor)&&i.getPermanencia().getDia().getMonthValue()==(dia.getMonthValue())){

                reservasProfesorMes.add(i);
            }
       }

        return reservasProfesorMes; 
       
        
    }
       
           
       
    private Reserva getReservaDia(LocalDate dia){
        
        if(dia==null){
            return null;
        }
        
        for(Reserva reservaDia: coleccionReservas){
            if(reservaDia.getPermanencia().getDia().equals(dia)){
                
                return reservaDia;
            }
        }
        return null;
    }
    public Reserva buscar(Reserva reserva){

        if(reserva==null){
           return null;
        }
        if(coleccionReservas.indexOf(reserva)==-1){
            return null;
        }else{
            return coleccionReservas.get(coleccionReservas.indexOf(reserva));
        }

}
    public void borrar(Reserva reserva) throws OperationNotSupportedException {
	if (reserva == null) {
            throw new IllegalArgumentException("No se puede anular una reserva nula.");
            }
        if(!coleccionReservas.remove(reserva)){
            
		throw new OperationNotSupportedException("La reserva a anular no existe.");
            }
	}
 
	
    public List<String> representar() {
        List<String> representacion = new ArrayList<String>();
            for(Reserva i: coleccionReservas){
                representacion.add(i.toString());
            }
            return representacion;
    }

    public List<Reserva> getReservasProfesor(Profesor profesor){

        List<Reserva> reservaProfesor = new ArrayList<Reserva>();
        if(profesor==null){
            return null;
        }
        for(Reserva i: coleccionReservas){
            if(i.getProfesor().equals(profesor)){
                reservaProfesor.add(i);
            }
        }return reservaProfesor;
        
    }
     
    
    public List<Reserva> getReservasAula(Aula aula){

        if(aula==null){

                throw new IllegalArgumentException("No se pueden comprobar las reservas de una aula nula.");
        }

        List<Reserva> reservaAula = new ArrayList<Reserva>();
        for(Reserva i: coleccionReservas){
            if(i.getAula().equals(aula)){
            reservaAula.add(i);
            }
        }
        return reservaAula;
        
    }
    
    public List<Reserva> getReservasPermanencia(Permanencia permanencia){

        if(permanencia==null){

                throw new IllegalArgumentException("No se pueden comprobar las reservas de un profesor nulo.");
        }

        List<Reserva> reservaPermanencia = new ArrayList<Reserva>();

        for(Reserva i: coleccionReservas){
            if(i.getPermanencia().equals(permanencia)){
            reservaPermanencia.add(new Reserva(i));
            }
        }
        return reservaPermanencia;
            
    }
    
     public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) throws IllegalArgumentException{
      boolean consulta=true;
         
     	if(aula==null||permanencia==null){
            
            throw new IllegalArgumentException("El Aula o permanencia introducida es nula.");
        }
       
        for(Reserva i: coleccionReservas){
           if(i.getAula().equals(aula)&& i.getPermanencia().equals(permanencia)){
               
                consulta= false;
            }
        }
          return consulta;
    }     
}    
          
            
                
            
         
        
    
    

       
    
       
    
    
    
    
    

       
   
  
        
        
	
        
        

    

    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   

    
    

