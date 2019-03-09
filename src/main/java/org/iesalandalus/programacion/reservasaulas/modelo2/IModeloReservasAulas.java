/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo2;

import java.util.ArrayList;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;

/**
 *
 * @author Ezk24
 */
public interface IModeloReservasAulas {

    void anularReserva(Reserva reserva) throws OperationNotSupportedException;

    void borrarAula(Aula aula) throws OperationNotSupportedException;

    void borrarProfesor(Profesor profesor) throws OperationNotSupportedException;

    Aula buscarAula(Aula aula);

    Profesor buscarProfesor(Profesor profesor);

    Reserva buscarReserva(Reserva reserva);

    boolean consultarDisponibilidad(Aula aula, Permanencia permanencia);

    List<Aula> getAulas();

    int getNumAulas();

    int getNumProfesores();

    int getNumReservas();

    List<Profesor> getProfesores();

    List<Reserva> getReservas();

    List<Reserva> getReservasAula(Aula aula);

    List<Reserva> getReservasPermanencia(Permanencia permanencia);

    List<Reserva> getReservasProfesor(Profesor profesor);

    void insertarAula(Aula aula) throws OperationNotSupportedException;

    void insertarProfesor(Profesor profesor) throws OperationNotSupportedException;

    void realizarReserva(Reserva reserva) throws OperationNotSupportedException;

    List<String> representarAulas();

    List<String> representarProfesores();

    List<String> representarReservas();
    
}
