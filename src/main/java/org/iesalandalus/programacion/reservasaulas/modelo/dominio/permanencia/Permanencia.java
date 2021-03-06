/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Ezk24
 */
public abstract class Permanencia {
   
    protected LocalDate dia;
    protected static final DateTimeFormatter FORMATO_DIA= DateTimeFormatter.ofPattern("dd/MM/yyyy");
   
    
    protected Permanencia(){}

    protected Permanencia(LocalDate dia){
        setDia(dia);
    }
    
    protected Permanencia(String dia){
         setDia(dia);
    }
        
    public LocalDate getDia() {
        return dia;
    }
        
    protected void setDia(LocalDate dia) {
        if(dia==null){
        
            throw new IllegalArgumentException("El día de una permanencia no puede ser nulo.");
            
        }else{
            
            this.dia=dia; //LocalDate es inmutable, no es necesario crear nuevo objeto.
        }    
    }
        
    protected void setDia(String dia){
        
        if(dia==null||dia.equals("")){
        
            throw new IllegalArgumentException("El día de una permanencia no puede ser nulo.");
                
        }else{
            
          try{
                this.dia= LocalDate.parse(dia, FORMATO_DIA);

              }catch(DateTimeParseException e){
            throw new IllegalArgumentException("El formato del día de la permanencia no es correcto.");
        }
        }  
    }
        
    public abstract int getPuntos();
    public abstract String toString();
    public abstract int hashCode();
    public abstract boolean equals(Object permanencia);
}
           
    
        
    


    


   

  

   

        
    
    

    
       

