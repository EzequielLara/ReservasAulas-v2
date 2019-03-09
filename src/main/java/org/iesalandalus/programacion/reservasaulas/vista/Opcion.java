/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.vista;

/**
 *
 * @author Ezk24
 */
public enum Opcion {
 
    SALIR("Salir") {
        @Override
        public void ejecutar() {
            vista.salir();
        }
    },
    INSERTAR_AULA("Insertar aula") {
        @Override
        public void ejecutar() {
            vista.insertarAula();
        }
    },
    BORRAR_AULA("Borrar aula") {
        @Override
        public void ejecutar() {
            vista.borrarAula();
        }
    },
    BUSCAR_AULA("Buscar aula") {
        @Override
        public void ejecutar() {
            vista.buscarAula();
        }
    },
    LISTAR_AULAS("Listar aulas") {
        @Override
        public void ejecutar() {
            vista.listarAulas();
        }
    },   
    INSERTAR_PROFESOR("Insertar profesor") {
        @Override
        public void ejecutar() {
            vista.insertarProfesor();
        }
    },
    BORRAR_PROFESOR("Borrar profesor") {
        @Override
        public void ejecutar() {
            vista.borrarProfesor();
        }
    },
    BUSCAR_PROFESOR("Buscar profesor") {
        @Override
        public void ejecutar() {
            vista.buscarProfesor();
        }
    },
    LISTAR_PROFESORES("Listar profesores") {
        @Override
        public void ejecutar() {
            vista.listarProfesores();
        }
    },
    INSERTAR_RESERVA("Insertar reserva") {
        @Override
        public void ejecutar() {
            vista.realizarReserva();
        }
    },
    BORRAR_RESERVA("Borrar reserva") {
        @Override
        public void ejecutar() {
            vista.anularReserva();
        }
    },
   
    LISTAR_RESERVAS("Listar reservas") {
        @Override
        public void ejecutar() {
            vista.listarReservas();
        }
    }, 
    LISTAR_RESERVAS_AULAS("Listar reservas aulas") {
        @Override
        public void ejecutar() {
            vista.listarReservasAula();
        }
    }, 
    LISTAR_RESERVAS_PROFESOR("Listar reservas profesor") {
        @Override
        public void ejecutar() {
            vista.listarReservasProfesor();
        }
    }, 
    LISTAR_RESERVAS_PERMANENCIA("Listar reservas permanencia") {
        @Override
        public void ejecutar() {
            vista.listarReservasPermanencia();
        }
    },
    CONSULTAR_DISPONIBILIDAD("Consultar disponibilidad"){
        @Override
        public void ejecutar(){
            vista.consultarDisponibilidad();
        }
    }; 
private static IVistaReservasAulas vista;   
private String mensajeAmostrar;

private Opcion(String mensajeAmostrar){
    this.mensajeAmostrar=mensajeAmostrar;
}
public String getMensaje(){
    return this.mensajeAmostrar;

}

public abstract void ejecutar();

protected static void setVista(IVistaReservasAulas vista){
    Opcion.vista=vista;
}

@Override
public String toString() {
   return "Opcion: " + mensajeAmostrar ;
}

public static Opcion getOpcionSegunOrdinal(int ordinal) {
    if (esOrdinalValido(ordinal))
	return values()[ordinal];
    else
        throw new IllegalArgumentException("Ordinal de la opción no válido");
    }
	
public static boolean esOrdinalValido(int ordinal) {
    return (ordinal >= 0 && ordinal <= values().length - 1);
    }

}
    


