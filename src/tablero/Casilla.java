package tablero;

import models.Elemento;
/**
 * @class Casilla
 * @brief La clase que lleva cada casilla dentro del juego y sus elementos
 * @author Alberto Sanchez Gomez
 * @date 31/05/2018
 * @since 1.0
 */

public class Casilla {
	String descripcion; //@param descripcion
	Elemento o;//@param elemento o
	
	
	
	/**
	 * @function Casilla (Constructor)
	 * @param descripcion
	 * @param elemento o
	 */
	public Casilla(String string,Elemento o) {
		descripcion=string;
	
	}



	public String toString() {
		String res = descripcion+": "+o;
		return res;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Elemento getElemento() {
		return o;
	}
	 
	/** @brief metodo para borrar elementos de las casillas
	 
	 */
	public void borrarElemento() {
		o=null;
	}



	public void setElemento(Elemento o) {
		this.o = o;
	}
	
}
