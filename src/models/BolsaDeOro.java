package models;

import java.util.Scanner;
/**
 * @class BolsaDeOro
 * @brief Clase de las bolsitas de oro que podrás encontrar durante la aventura
 * @author Alberto Sanchez Gomez
 * @date 31/05/2018
 * @since 1.0
 */
public class BolsaDeOro extends Elemento {
	private int oro; //@param oro que recoge

	
	/**
	 * @function Tienda (Constructor)
	 * @param Descripcion de la tienda y su poción
	 */ 
	public BolsaDeOro(String descripcion) {
		super(descripcion);
		this.oro = 100;
	}

	public int getOro() {
		return oro;
	}

	public void setOro(int oro) {
		this.oro = oro;
	}
	
	
	/** @brief La compra de la poción
	 * 
	 * @param eleccion
	 * @param j
	 */

		public void pedirOpcionesOro(int eleccion, Jugador j) {
			// Initialize the scanner
			Scanner scanner = new Scanner(System.in); 
			Scanner reader = new Scanner(System.in); 

		

			switch (eleccion) {
			
			case 1: 
			    j.setOro(j.getOro()+100);
				
				break;
			case 2:
				j.setOro(j.getOro()+100);
				
				break;
				  
			

			
				
			}

		}
}
