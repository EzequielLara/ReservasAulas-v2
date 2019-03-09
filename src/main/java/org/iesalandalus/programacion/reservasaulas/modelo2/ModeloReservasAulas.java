/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo2;

import java.util.ArrayList;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Aulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Profesores;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Reservas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

/**
 *
 * @author Ezk24
 */
public class ModeloReservasAulas implements IModeloReservasAulas {
    private Profesores profesores;
    private Aulas aulas;
    private Reservas reservas;
    
    public ModeloReservasAulas(){   
        
        profesores=new Profesores();
        aulas =new Aulas();
        reservas = new Reservas();
    }
        
    @Override
    public List<Aula> getAulas(){
        return aulas.getAulas();
    }
    
    @Override
    public int getNumAulas(){
        return aulas.getNumAulas();
    }
    
    @Override
    public List<String> representarAulas(){
        return aulas.representar();
    }
    
    @Override
    public Aula buscarAula(Aula aula) throws IllegalArgumentException{
        return aulas.buscar(aula);
    }
    
    @Override
    public void insertarAula(Aula aula) throws OperationNotSupportedException{
        aulas.insertar(aula);
    }
    
    @Override
    public void borrarAula(Aula aula) throws OperationNotSupportedException{
        aulas.borrar(aula);
    }
    
    @Override
    public List<Profesor> getProfesores(){
        return profesores.getProfesores();
    }
    
    @Override
    public int getNumProfesores(){
        return profesores.getNumProfesores();
    }
    
    @Override
    public List<String> representarProfesores(){
        return profesores.representar();
    }
    
    @Override
    public Profesor buscarProfesor(Profesor profesor) throws IllegalArgumentException{
        return profesores.buscar(profesor);
    }
    
    @Override
    public void insertarProfesor(Profesor profesor) throws OperationNotSupportedException{
        profesores.insertar(profesor);
    }
    
    @Override
    public void borrarProfesor(Profesor profesor) throws OperationNotSupportedException{
        profesores.borrar(profesor);
    }
    
    @Override
    public List<Reserva>getReservas(){
        return reservas.getReservas();
    }
    
    @Override
    public int getNumReservas(){
        return reservas.getNumReservas();
    }
    
    @Override
    public List<String> representarReservas(){
        return reservas.representar();
    }
    
    @Override
    public Reserva buscarReserva(Reserva reserva) throws IllegalArgumentException{
        return reservas.buscar(reserva);
    }
    
    @Override
    public void realizarReserva(Reserva reserva) throws OperationNotSupportedException{
        reservas.insertar(reserva);
    }
    
    @Override
    public void anularReserva(Reserva reserva) throws OperationNotSupportedException{
        reservas.borrar(reserva);
    }
    
    @Override
    public List<Reserva> getReservasAula(Aula aula) throws IllegalArgumentException{
        return reservas.getReservasAula(aula);
    }
    
    @Override
    public List<Reserva> getReservasProfesor(Profesor profesor) throws IllegalArgumentException{
        return reservas.getReservasProfesor(profesor);
    }
    
    @Override
    public List<Reserva> getReservasPermanencia(Permanencia permanencia) throws IllegalArgumentException{
        return reservas.getReservasPermanencia(permanencia);
    }
    
    @Override
    public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia)throws IllegalArgumentException{
        return reservas.consultarDisponibilidad(aula, permanencia);
    
    }
    
    
}
