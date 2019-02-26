/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import java.util.Objects;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.PermanenciaPorHora;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.PermanenciaPorTramo;

/**
 *
 * @author Ezk24
 */
public class Reserva {
    
    private Profesor profesor;
    private Aula aula;
    private Permanencia permanencia;

    public Reserva(Profesor profesor, Aula aula, Permanencia permanencia) {
       
        setPermanencia(permanencia);
        setAula(aula);
        setProfesor(profesor);
    }

    public Reserva(Reserva reserva) {
        
        if(reserva==null){
        
        throw new IllegalArgumentException("No se puede copiar una reserva nula.");
        
        }
        //reserva=new Reserva (reserva.getProfesor(),reserva.getAula(),reserva.getPermanencia());
       
        setPermanencia(reserva.permanencia);
        setAula(reserva.aula);
        setProfesor(reserva.profesor);
        
        
    }
    
    private void setProfesor(Profesor profesor){
        if(profesor==null){
            throw new IllegalArgumentException("La reserva debe estar a nombre de un profesor.");
        }
       this.profesor=new Profesor(profesor.getNombre(),profesor.getCorreo(),profesor.getTelefono());
    }
       
    public Profesor getProfesor(){
        return this.profesor;
    }
    
    private void setAula(Aula aula){
        if(aula==null){
            throw new IllegalArgumentException("La reserva debe ser para un aula concreta.");
            
        }
        this.aula=new Aula(aula.getNombre(),aula.getPuestos());
    
    }
    
    public Aula getAula(){
    
        return this.aula;
    }
    
    private void setPermanencia(Permanencia permanencia){
        if(permanencia==null){
            throw new IllegalArgumentException("La reserva se debe hacer para una permanencia concreta.");
        }
       if(permanencia instanceof PermanenciaPorTramo){
           this.permanencia=new PermanenciaPorTramo(((PermanenciaPorTramo) permanencia).getDia(),((PermanenciaPorTramo) permanencia).getTramo());
       }
       if(permanencia instanceof PermanenciaPorHora){
           this.permanencia=new PermanenciaPorHora(((PermanenciaPorHora) permanencia).getDia(),((PermanenciaPorHora) permanencia).getHora());
        }
    }
    
    public Permanencia getPermanencia(){
        
        
        return permanencia;
         
    }
        
    public float getPuntos(){
        return permanencia.getPuntos() + aula.getPuntos();
    }   

    @Override
    public int hashCode() {
        int hash = 3;
      
        hash = 53 * hash + Objects.hashCode(this.aula);
        hash = 53 * hash + Objects.hashCode(this.permanencia);
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
        final Reserva other = (Reserva) obj;
    
        if (!Objects.equals(this.aula, other.aula)) {
            return false;
        }
        if (!Objects.equals(this.permanencia, other.permanencia)) {
            return false;
        }
        return true;
    }

 

    @Override
    public String toString() {
        return  "[profesor=" + profesor + ", aula=" + aula + ", permanencia=" + permanencia +", puntos=" + getPuntos() + "]";
    }

}
