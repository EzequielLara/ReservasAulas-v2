
 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package org.iesalandalus.programacion.reservasaulas.modelo.dao;
/**
 *
 * @author Ezk24
 */
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import java.util.ArrayList;
import java.util.List;

public class Aulas {
    
    private List<Aula> coleccionAulas;
  

    public Aulas() {
        
      coleccionAulas = new ArrayList<Aula>();
    }
    
    public Aulas(Aulas aulas){
        
           setAulas(aulas);
    }

   private void setAulas(Aulas aulas){
       
       if (aulas == null) {
	    throw new IllegalArgumentException("No se pueden copiar aulas nulas.");
	}
            coleccionAulas = copiaProfundaColeccionAulas(aulas.getAulas());
	}
    
    private List<Aula> copiaProfundaColeccionAulas(List<Aula> coleccionAulas) {
        
        List<Aula> copia = new ArrayList<Aula>();
        
	for(Aula i: coleccionAulas){
            copia.add(new Aula(i));
        }
	return copia;
    }
	
    public List<Aula> getAulas() {
        
	return copiaProfundaColeccionAulas(coleccionAulas);
    }
	
    public int getNumAulas() {
	return coleccionAulas.size();
    }
    
    public void insertar(Aula aula) throws OperationNotSupportedException{
     
	if (aula == null) {
		throw new IllegalArgumentException("No se puede insertar un aula nula.");
	}
        if (coleccionAulas.contains(aula)) {
            throw new OperationNotSupportedException("El aula ya existe.");
            
	}else{
            coleccionAulas.add(aula);
        }
    }
            
	
    public Aula buscar(Aula aula) {
        
        if(aula==null){
            return null;
        }
        if(coleccionAulas.indexOf(aula)== -1){
            return null;
        }else{
            return coleccionAulas.get(coleccionAulas.indexOf(aula));
        }
        
    }

    public void borrar(Aula aula) throws OperationNotSupportedException {
        
        if (aula == null) {
            throw new IllegalArgumentException("No se puede borrar un aula nula.");
            }
        if(!coleccionAulas.remove(aula)){  
                throw new OperationNotSupportedException("El aula a borrar no existe.");
            }
    }
     
	
    public List<String> representar() {
            ArrayList<String> representacion = new ArrayList<String>();
            for(Aula i:coleccionAulas){
                representacion.add(i.toString());
            }
            
            return representacion;
    }

    
    
    
    
   
    
}
