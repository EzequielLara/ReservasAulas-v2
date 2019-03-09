/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import java.util.ArrayList;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;

/**
 *
 * @author Ezk24
 */
public class Profesores{
    
  private List<Profesor>coleccionProfesores;

    public Profesores() {
        
       
        coleccionProfesores=new ArrayList<Profesor>();
    }
    
    public Profesores(Profesores profesores){
        
           setProfesores(profesores);
    }

   private void setProfesores(Profesores profesores){
       
       if (profesores == null) {
	    throw new IllegalArgumentException("No se pueden copiar profesores nulos.");
	}
            coleccionProfesores = copiaProfundaColeccionProfesores(profesores.getProfesores());
            
	}
    
    private List<Profesor> copiaProfundaColeccionProfesores(List<Profesor> coleccionProfesores) {
        
	ArrayList<Profesor> copiaProfesor=new ArrayList<Profesor>();
	for(Profesor i: coleccionProfesores){
            copiaProfesor.add(new Profesor(i));
        }
	
	return copiaProfesor;
    }
	
public List<Profesor> getProfesores(){
    
   return copiaProfundaColeccionProfesores(coleccionProfesores);
}
	
    public int getNumProfesores() {
	return coleccionProfesores.size();
    }
    
    public void insertar(Profesor profesor) throws OperationNotSupportedException{
     
	if (profesor == null) {
		throw new IllegalArgumentException("No se puede insertar un profesor nulo.");
	}
        if(coleccionProfesores.contains(profesor)){
            throw new OperationNotSupportedException("El profesor ya existe.");
        }
	coleccionProfesores.add(profesor);
    
        
    }
    
    public Profesor buscar(Profesor profesor){
    
        if (profesor==null){
            return null;
        }
        if(coleccionProfesores.indexOf(profesor)==-1){
            return null;
        }else{
            return coleccionProfesores.get(coleccionProfesores.indexOf(profesor));
        }
    }

    public void borrar(Profesor profesor) throws OperationNotSupportedException {
	if (profesor == null) {
            throw new IllegalArgumentException("No se puede borrar un profesor nulo.");
            }
        if(!coleccionProfesores.remove(profesor)){
            
        
            throw new OperationNotSupportedException("El profesor a borrar no existe.");
        }
    }

    public List<String> representar() {
            ArrayList<String> representacion = new ArrayList<String>();
            for (Profesor i: coleccionProfesores){
                representacion.add(i.toString());
            }
            
            return representacion;
    }
   
    
    
    
    
   
    
}

    

