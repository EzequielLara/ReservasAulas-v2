/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.zip.DataFormatException;

/**
 *
 * @author Ezk24
 */
public class PermanenciaPorHora extends Permanencia {

    private static final int PUNTOS=3;
    private static final int HORA_INICIO=8;
    private static final int HORA_FIN=22;
    private static final DateTimeFormatter FORMATO_HORA=DateTimeFormatter.ofPattern("HH:mm");
    private LocalTime hora;
    
    public PermanenciaPorHora(LocalDate dia, LocalTime hora){
     
            super.setDia(dia);
            setHora(hora);
            
    }
    public PermanenciaPorHora(String dia, LocalTime hora){
            
        super(dia);
        setHora(hora);
    }
    
    
    public PermanenciaPorHora(LocalDate dia, String hora){
       
        super(dia);
        setHora(hora);
    }
        
        
        
    
    public PermanenciaPorHora(String dia, String hora){
        super(dia);
        setHora(hora);
    }
    
        
    public PermanenciaPorHora(PermanenciaPorHora permanenciaHora){
        if(permanenciaHora==null){
            throw new IllegalArgumentException("No se puede copiar una permanencia nula.");
        }else{
            
            setDia(permanenciaHora.getDia());
            setHora(permanenciaHora.getHora());
        }
    }
        
        
        
    public LocalTime getHora(){
        return hora;
    }
        
    
    private void setHora(LocalTime hora){
        if(hora==null){
            
            throw new IllegalArgumentException("La hora de una permanencia no puede ser nula.");
        }else{
            if(HORA_INICIO>hora.getHour()|| hora.getHour()>HORA_FIN){
                throw new IllegalArgumentException("La hora de una permanencia debe estar comprendida entre las " + HORA_INICIO + " y las " + HORA_FIN + ".");
            }
            if(hora.getMinute()!=0){
                throw new IllegalArgumentException("La hora de una permanencia debe ser una hora en punto.");
            }else{
                this.hora=hora;
            }
        }
    }

            
        
    private void setHora(String hora){
        if(hora==null||hora.equals("")){
        
            throw new IllegalArgumentException("La hora de una permanencia no puede ser nula.");
        }
        LocalTime horaAuxiliar=null;
        try{
           horaAuxiliar=LocalTime.parse(hora,FORMATO_HORA);
        }catch(DateTimeException e){
            throw new IllegalArgumentException("El formato de la hora de la permanencia no es correcto.");
        }
        if(HORA_INICIO>horaAuxiliar.getHour()|| horaAuxiliar.getHour()>HORA_FIN){
            throw new IllegalArgumentException("La hora de una permanencia debe estar comprendida entre las " + HORA_INICIO + " y las " + HORA_FIN + ".");
        }else{
            if(horaAuxiliar.getMinute()!=0){
                throw new IllegalArgumentException("La hora de una permanencia debe ser una hora en punto.");
            }else{
                this.hora=horaAuxiliar;
            }
                
        }
    }
    
    @Override
    public int getPuntos() {
       return PUNTOS;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.hora);
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
        final PermanenciaPorHora other = (PermanenciaPorHora) obj;
        
        if (Objects.equals(this.hora, other.hora) && Objects.equals(this.dia, other.dia)) {

            return true;

        }

        return false;

    }

    @Override
    public String toString() {
        return "[dia=" + super.getDia().format(FORMATO_DIA) +", "+ "hora=" + getHora().format(FORMATO_HORA) + "]";
    }
}
          
    
        
        
     
            
        
                
    
    

    
    
    
    
    
    
