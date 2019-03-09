/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Ezk24
 */
public class PermanenciaPorTramo extends Permanencia {
    
    private static final int PUNTOS=10;
    public Tramo tramo;

    public PermanenciaPorTramo(LocalDate dia, Tramo tramo){
    
        super(dia);
        setTramo(tramo);
    }
    
    public PermanenciaPorTramo(String dia, Tramo tramo){
        
        super(dia);
        setTramo(tramo);
    }
    
    
    public PermanenciaPorTramo(PermanenciaPorTramo permanenciaTramo){
   
        
        if(permanenciaTramo==null){
            throw new IllegalArgumentException("No se puede copiar una permanencia nula.");
        }else{
            
           super.setDia(permanenciaTramo.getDia());
           setTramo(permanenciaTramo.getTramo());
        }
    }
    
    public Tramo getTramo(){
        return tramo;
    }
    
    private void setTramo(Tramo tramo){
        
        if(tramo==null){
            throw new IllegalArgumentException("El tramo de una permanencia no puede ser nulo.");
        }else{
        
            this.tramo= tramo;
        }
    }
    
    @Override
    public int getPuntos(){
        return PUNTOS;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.tramo);
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
        final PermanenciaPorTramo other = (PermanenciaPorTramo) obj;
        if (Objects.equals(this.tramo, other.tramo) && Objects.equals(this.dia, other.dia)) {

            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "[dia="+super.getDia().format(FORMATO_DIA)+", "+"tramo="+tramo+"]";
    }
    
    
   

 
    
}
