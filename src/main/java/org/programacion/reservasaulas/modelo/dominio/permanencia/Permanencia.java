/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.programacion.reservasaulas.modelo.dominio.permanencia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author Ezk24
 */
public abstract class Permanencia {
   
    protected LocalDate dia;
    protected static final DateTimeFormatter FORMATO_DIA= DateTimeFormatter.ofPattern("dd/MM/uuuu");
   
    
    protected Permanencia(){}

    protected Permanencia(LocalDate dia){
        setDia(dia);
    }
    
    public Permanencia(String dia){
        
           setDia(dia);
    }
        
    public LocalDate getDia() {
        return dia;
    }
        
    protected void setDia(LocalDate dia) {
        if(dia==null){
        
            throw new IllegalArgumentException("El día de una permanencia no puede ser nulo.");
            
        }else{
            
            
            this.dia=dia;
        }
    }
        
    protected void setDia(String dia){
        
        if(dia==null||dia.equals("")){
        
            throw new IllegalArgumentException("Excepción de setDia(String) de la clase Permanencia");
                
        }else{

            this.dia= LocalDate.parse(dia, FORMATO_DIA);
        }
    }
        
    public abstract int getPuntos();
    public abstract String toString();
    public abstract int hashCode();
    public abstract boolean equals(Object permanencia);
}
           
    
        
    


    


   

  

   

        
    
    

    
       

