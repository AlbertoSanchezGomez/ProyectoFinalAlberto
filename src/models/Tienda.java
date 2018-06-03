package models;

import java.util.Scanner;
/**
 * @class Tienda
 * @brief Clase de la Tienda con poción
 * @author Alberto Sanchez Gomez
 * @date 31/05/2018
 * @since 1.0
 */

public class Tienda extends Elemento {
	
	private Elemento pocion; //@param pocion
	

	/**
	 * @function Tienda (Constructor)
	 * @param Descripcion de la tienda y su poción
	 */ 
	public Tienda(String descripcion, Elemento pocion) {
		super(descripcion);
		this.pocion = pocion;
	}


	public Elemento getPocion() {
		return pocion;
	}


	public void setPocion(Elemento pocion) {
		this.pocion = pocion;
	}
	
    
    	
   
   }
    
  
	  



	

