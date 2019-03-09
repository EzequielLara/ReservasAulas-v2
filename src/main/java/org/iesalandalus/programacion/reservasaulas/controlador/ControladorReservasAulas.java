/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.controlador;

import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo2.IModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas;

/**
 *
 * @author Ezk24
 */
public class ControladorReservasAulas implements IControladorReservasAulas {
    
        private IModeloReservasAulas modelo;
        private IVistaReservasAulas vista;
        
    public ControladorReservasAulas(IModeloReservasAulas modelo,IVistaReservasAulas vista){
        
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControlador(this);
    }
    
    @Override
    public void comenzar(){
        vista.comenzar();
    }
    @Override
    public void salir(){
        vista.salir();
    }
    @Override
    public void insertarAula(Aula aula) throws OperationNotSupportedException,IllegalArgumentException{
        modelo.insertarAula(aula);
    }
    @Override
    public void borrarAula(Aula aula) throws OperationNotSupportedException{
        modelo.borrarAula(aula);
    }
    @Override
    public Aula buscarAula(Aula aula){
        return modelo.buscarAula(aula);
    }
    @Override
    public List<String> representarAulas(){
        return modelo.representarAulas();
    }
    @Override
    public void insertarProfesor(Profesor profesor) throws OperationNotSupportedException{
        modelo.insertarProfesor(profesor);
    }
    @Override
    public void borrarProfesor(Profesor profesor) throws OperationNotSupportedException{
        modelo.borrarProfesor(profesor);
    }
    @Override
    public Profesor buscarProfesor(Profesor profesor){
        return modelo.buscarProfesor(profesor);
    }
    @Override
    public List<String> representarProfesores(){
        return modelo.representarProfesores();
    }
    @Override
    public void realizarReserva(Reserva reserva) throws OperationNotSupportedException{
        modelo.realizarReserva(reserva);
    }
    @Override
    public void anularReserva(Reserva reserva) throws OperationNotSupportedException{
        modelo.anularReserva(reserva);
    }
    @Override
    public List<String> representarReservas(){
        return modelo.representarReservas();
    }
    @Override
    public List<Reserva> getReservasAula(Aula aula){
        return modelo.getReservasAula(aula);
    }
    @Override
    public List<Reserva> getReservasProfesor(Profesor profesor){
        return modelo.getReservasProfesor(profesor);
    }
    @Override
    public List<Reserva> getReservasPermanencia(Permanencia permanencia){
        return modelo.getReservasPermanencia(permanencia);
    }
    @Override
    public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia){
        return modelo.consultarDisponibilidad(aula,permanencia);
    }
}
