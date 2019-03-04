package org.iesalandalus.programacion.reservasaulas;


import org.iesalandalus.programacion.reservasaulas.controlador.ControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo2.IModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo2.ModeloReservasAulas;

import org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas;
import org.iesalandalus.programacion.reservasaulas.vista.VistaReservasAulas;

public class MainApp {

	public static void main(String[] args) {
		IVistaReservasAulas vista = new VistaReservasAulas();
		IModeloReservasAulas modelo = new ModeloReservasAulas();
		IControladorReservasAulas controlador = new ControladorReservasAulas(modelo, (VistaReservasAulas) vista);
		controlador.comenzar();
	}

}
