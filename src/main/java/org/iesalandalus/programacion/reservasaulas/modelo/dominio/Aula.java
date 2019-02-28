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
public class Aula {
    static final float PUNTOS_POR_PUESTO= 0.5f;
    static final int MIN_PUESTOS=10;
    static final int MAX_PUESTOS=100;
    private String nombre;
    private int puestos;

    public Aula(String nombre, int puestos){
        
      setNombre(nombre);
      setPuestos(puestos);
    
    } 
    public Aula(Aula aula){
    
         if (aula==null){
       
         throw new IllegalArgumentException("No se puede copiar un aula nula.");   
            }else{
        
                setNombre(aula.getNombre());
                setPuestos(aula.getPuestos());
            }
       
    }     
    
       

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre){
        
        if(nombre==null){
            
            throw new IllegalArgumentException("El nombre del aula no puede ser nulo.");
            
        }
        
       if(nombre.equals("")){
            
           throw new IllegalArgumentException("El nombre del aula no puede estar vacío.");
            
        }
       
        this.nombre=nombre;
             
    }
    
    private void setPuestos(int puestos){
        
        if(MIN_PUESTOS<=puestos&&puestos<=MAX_PUESTOS){
        
        this.puestos=puestos;
        }else{
            throw new IllegalArgumentException("El número de puestos no es correcto.");
        }
    }
    
    public int getPuestos(){
    
        return puestos;
    }
    
    public float getPuntos(){
        return PUNTOS_POR_PUESTO*puestos;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.nombre);
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
        final Aula other = (Aula) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return  "[nombre=" + nombre +", "+ "puestos=" + puestos+']';
    }

  
    

   

    
    
    
    
    
    
    
}
