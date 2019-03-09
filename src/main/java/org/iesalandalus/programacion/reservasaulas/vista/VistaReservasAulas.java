/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.vista;

import java.util.ArrayList;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.controlador.ControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.PermanenciaPorTramo;

/**
 *
 * @author Ezk24
 */
public class VistaReservasAulas implements IVistaReservasAulas {
    	private static final String ERROR = "ERROR en VistaReservasAulas: ---- ";
	private static final String CORREO_VALIDO="Correo válido";
        private static final String NOMBRE_VALIDO= "Nombre válido";
	private ControladorReservasAulas controlador;

	public VistaReservasAulas() {
		
		Opcion.setVista(VistaReservasAulas.this);
	}
        
    @Override
        public void setControlador(ControladorReservasAulas controlador){
            this.controlador=controlador;
        }

    @Override
	public void comenzar() {
		int ordinalOpcion;
		do {
			Consola.mostrarMenu();
                        System.out.println("\nElige una opcion");
			ordinalOpcion = Consola.elegirOpcion();
			Opcion opcion = Opcion.getOpcionSegunOrdinal(ordinalOpcion);
			opcion.ejecutar();
		} while (ordinalOpcion != Opcion.SALIR.ordinal());
	}
	
    @Override
	public void salir() {
		System.out.println("Chao Peskao");
	}
	
    @Override
	public void insertarAula() {
		Consola.mostrarCabecera("Insertar aula");
		try {
			Aula aula = Consola.leerAula();
                       
			controlador.insertarAula(aula);
			System.out.println("Aula insertada correctamente.");
                        
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
    @Override
	public void borrarAula() {
		Consola.mostrarCabecera("Borrar aula");
		try {
			Aula aula = new Aula(Consola.leerNombreAula(),15);
                        Aula aulaBuscada=controlador.buscarAula(aula);
                        
                        if(aulaBuscada==null){
                            System.out.println("No existe el aula introducida.");
                        }else{
			controlador.borrarAula(aula);
			System.out.println("Aula borrada correctamente.");
                        }
                        
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
    @Override
	public void buscarAula() {
		Consola.mostrarCabecera("Buscar aula");
		Aula aula=null;
                
               
		try {
                        aula = new Aula(Consola.leerNombreAula(),15);
                       Aula aulaBuscada=controlador.buscarAula(aula);
			if ( aulaBuscada!= null) {
				System.out.println("El aula buscada es: " + aulaBuscada);
			} else {
				System.out.println("No existe ninguna aula con dicho nombre.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
    @Override
	public void listarAulas() {
		Consola.mostrarCabecera("Listar aulas");
		List<String>aulas = controlador.representarAulas();
		if (aulas.size() > 0) {
			for (String aula : aulas) {
				System.out.println(aula);
			}
		} else {
			System.out.println("No hay aulas que listar.");
		}
	}
    @Override
	public void insertarProfesor() {
		Consola.mostrarCabecera("Insertar profesor");
		try {
			Profesor profesor = Consola.leerProfesor();
			controlador.insertarProfesor(profesor);
                        if (profesor.getNombre()!=null){
			System.out.println(NOMBRE_VALIDO);
                        }
                        if (profesor.getCorreo()!=null){
                            System.out.println(CORREO_VALIDO);}
                        
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
    @Override
	public void borrarProfesor() {
		Consola.mostrarCabecera("Borrar profesor");
                String nombreProfesor=Consola.leerNombreProfesor();
                Profesor profesor=null;
		try {
                        profesor = new Profesor(nombreProfesor,"dfsd@gmail.com");
			controlador.borrarProfesor(profesor);
			System.out.println("Profesor borrado correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
    @Override
	public void buscarProfesor() {
		Consola.mostrarCabecera("Buscar profesor");
		String nombreProfe = Consola.leerNombreProfesor();
                
		try {
			Profesor profesor= new Profesor(nombreProfe,"fdsa@gmail.com");
                        Profesor profesor2=controlador.buscarProfesor(profesor);
			if ( profesor2 == null) {
                            System.out.println("No existe ninguna profesor con dicho nombre.");
                        } else {
                            System.out.println("El profesor buscado es: " + profesor);
                        }
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		
                
                }
	}
	
    @Override
	public void listarProfesores() {
		Consola.mostrarCabecera("Listar profesores");
		ArrayList<String>profesores = (ArrayList<String>) controlador.representarProfesores();
		if (profesores.size() > 0) {
			for (String profesor : profesores) {
				System.out.println(profesor);
			}
		} else {
			System.out.println("No hay profesores que listar.");
		}
	}

    @Override
        public void realizarReserva()  {
		Reserva reserva = null;
                Consola.mostrarCabecera("Realizar reserva");
                String nombreProfe=Consola.leerNombreProfesor();
                
                    Profesor profesorReserva = controlador.buscarProfesor(new Profesor(nombreProfe,"profe@bvh.com"));
                    if(profesorReserva==null){
                        System.out.println("Nombre de profesor no válido");
                        comenzar();
                    }else{
                         reserva=leerReserva(profesorReserva);
                    }        
		try{
			controlador.realizarReserva(reserva);
			System.out.println("Reserva realizada correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
                }         
	}
        
        private Reserva leerReserva(Profesor profesor){
            Reserva reserva=null;
        try{
            Aula aula = new Aula (Consola.leerNombreAula(),15);
            Aula aulabuscada=controlador.buscarAula(aula);
            Permanencia permanencia = Consola.leerPermanencia();
            reserva=new Reserva(profesor,aula,permanencia);
        }catch(IllegalArgumentException e){e.getMessage();}
          return reserva;
        }
	
    @Override
	public void anularReserva() {
            
		Consola.mostrarCabecera("Borrar cliente");
                String nombreProfesor=Consola.leerNombreProfesor();
                Profesor profesor = new Profesor(nombreProfesor,"ddsl@lkd.com");
		try {
			Reserva reserva = leerReserva(profesor);
			controlador.anularReserva(reserva);
			System.out.println("Reserva anulada correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
	
	
    @Override
	public void listarReservas() {
		Consola.mostrarCabecera("Listar reservas");
		List<String>reservas = controlador.representarReservas();
		if (reservas.size() > 0) {
			for (String reserva : reservas) {
				System.out.println(reserva);
			}
		} else {
			System.out.println("No hay reservas que listar.");
		}
	}
        
    @Override
        public void listarReservasAula() {
		Consola.mostrarCabecera("Listar reservas aula");
                Aula aula = new Aula(Consola.leerNombreAula(),15);
		List<Reserva>reservasAula = controlador.getReservasAula(aula);
		if (reservasAula.size() > 0) {
			for (Reserva reserva : reservasAula) {
                            if(reserva!=null){
                            System.out.println(reserva);
			}
                        }
		} else {
			System.out.println("No hay reservas que listar.");
		}
	}
    @Override
        public void listarReservasProfesor() {
            Consola.mostrarCabecera("Listar reservas profesor");
            Profesor profesor = new Profesor(Consola.leerNombreProfesor(),"profe@gsdd.com");
               
                List<Reserva>reservasProfesor = controlador.getReservasProfesor(profesor);
            if (reservasProfesor.size() > 0) {
                    for (Reserva reserva : reservasProfesor) {
                        if(reserva!=null){
                            System.out.println(reserva);
                        }
                    }    
            } else {
                    System.out.println("No hay reservas que listar.");
            }
                    
             
         }
                            
    @Override
        public void listarReservasPermanencia() {
		Consola.mostrarCabecera("Listar reservas permanencia");
                Permanencia permanenciaReserva= Consola.leerPermanencia();
                
            try{
                
                
		List<Reserva> reservasPermanencia = controlador.getReservasPermanencia(permanenciaReserva);
                
		if (reservasPermanencia.size() > 0) {
			for (Reserva reserva : reservasPermanencia) {
                            if(reserva!=null){
     
				System.out.println(reserva);
                            }
                        }
		}else{
			System.out.println("No hay reservas que listar.");
            
                }
            }catch(IllegalArgumentException e){System.out.println(ERROR + e.getMessage());}
	}
               
                    
                
        
    @Override
        public void consultarDisponibilidad()throws IllegalArgumentException{
            Consola.mostrarCabecera("Consultar Disponibilidad");
            
            Aula aula = new Aula(Consola.leerNombreAula(),15);
		boolean lecturaCorrecta = true;
		if(controlador.buscarAula(aula) == null) {
			System.out.println(ERROR + "El aula indicada no existe.");
			lecturaCorrecta = false;
		}
		if(lecturaCorrecta) {
			Permanencia permanencia =Consola.leerPermanencia();
			boolean disponible = controlador.consultarDisponibilidad(aula, permanencia);
			if(disponible)
				System.out.println("El aula consultada está disponible para ese momento");
			else
				System.out.println("El aula consultada no está disponible para ese momento.");
		}
            
            
            
            
            
            
            
            
//            Aula aula= new Aula(Consola.leerNombreAula(),15);
//            Permanencia permanencia =Consola.leerPermanencia();
//            if(controlador.buscarAula(aula)==null){
//                throw new IllegalArgumentException("El aula introducida no existe.");
//            }
//            
//            
//            boolean aulaTramoDisponible= controlador.consultarDisponibilidad(aula, permanencia);
//            
//            if(aulaTramoDisponible==true){
//              
//                System.out.println("Aula disponible para dicha permanencia.");
//            }
//                
//            if(aulaTramoDisponible==false){
//                System.out.println("Aula no disponible para dicha permanencia.");
//            }
        }
           
}

