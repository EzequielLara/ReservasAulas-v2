/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import java.util.Objects;

/**
 *
 * @author Ezk24
 */
public class Profesor {
    
    private static final String ER_TELEFONO = "([69]{1})([0-9]{8})";
    private static final String ER_CORREO= "([a-zA-z0-9.-_]{1,})(\\@[a-zA-z]{1,})(\\.[a-z]{1,3})";
    private String nombre;
    private String correo;
    private String telefono;
    
    public Profesor(Profesor profesor){
        
        if(profesor==null){
        
            throw new IllegalArgumentException("No se puede copiar un profesor nulo.");
        }else{
    
          setNombre(profesor.getNombre());
          setCorreo(profesor.getCorreo());
         
          setTelefono(profesor.getTelefono());
          
        
        }
    }
    
    public Profesor(String nombre, String correo){
    
        setNombre(nombre);
        setCorreo(correo);
        
    }
    
    public Profesor(String nombre, String correo, String telefono){
    
        setNombre(nombre);
        setCorreo(correo);
       
        setTelefono(telefono);
    }
   
    private void setNombre(String nombre){
    
        if(nombre==null){
        
            throw new IllegalArgumentException("El nombre del profesor no puede ser nulo.");
        }
        
        if(nombre.equals("")){
        
            throw new IllegalArgumentException("El nombre del profesor no puede estar vacío.");
        
        }
             
            this.nombre=nombre;
    }
    
    public void setCorreo(String correo){
        
        if(correo==null){
        
            throw new IllegalArgumentException("El correo del profesor no puede ser nulo.");      
        }
        if(!correo.matches(ER_CORREO)){
            
            throw new IllegalArgumentException("El correo del profesor no es válido.");
            
        }
            this.correo=correo;
        
    }
   
    
    public void setTelefono(String telefono){
        
        if(telefono!=null){
        
       //     throw new IllegalArgumentException("El teléfono del profesor no puede ser nulo.");
        //}
        if(!telefono.matches(ER_TELEFONO)){
    
            throw new IllegalArgumentException("El teléfono del profesor no es válido.");
        }
            this.telefono=telefono;
        }
    }
    
    public String getNombre(){
    
        return nombre;
    }
    
    public String getCorreo(){
    
        return correo;
    }
    
    public String getTelefono(){
   
      
        return telefono; 
    }

    @Override
    public String toString() {
        if(telefono==null){
            
            return   "[nombre=" + nombre + ", correo=" + correo + "]";
        
        }else{
            
            return   "[nombre=" + nombre + ", correo=" + correo + ", telefono=" +telefono +"]";
              
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + Objects.hashCode(this.correo);
        hash = 29 * hash + Objects.hashCode(this.telefono);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profesor other = (Profesor) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
     
        return true;
    }
    
    
    
    
}
        
                

                
        
                
