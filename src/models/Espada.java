package models;

import java.util.Scanner;
/**
 * @class Espada
 * @brief Clase de la Espada
 * @author Alberto Sanchez Gomez
 * @date 31/05/2018
 * @since 1.0
 */

public class Espada extends Elemento{
	

	
	/**
	 * @function Espada (Constructor)
	 * @param Descripcion y fuerza de la Espada
	 */ 
	public Espada( String descripcion, int fuerza) { 
		super(descripcion);
		this.setDescripcion(descripcion);
		
		
	}



	

	/** @brief Metodo de recoger la espada
	 * @param eleccion 
	 * @param j
	 */
		
	

		public void opcionesEspada(int eleccion, Jugador j) {
			// Initialize the scanner
			Scanner scanner = new Scanner(System.in); 
			Scanner reader = new Scanner(System.in); 

		

			switch (eleccion) {
			
			case 1: 
			    j.setFuerza(j.getFuerza()+2);
				
				break;
			case 2:
				j.setFuerza(j.getFuerza()+0);
				
				break;
				  
			
			
				
			}

		}
	}


