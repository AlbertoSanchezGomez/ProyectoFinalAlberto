package models;

import java.util.Random;
/**
 * @class Enemigo
 * @brief Clase que guarda a los enemigos del juego
 * @author Alberto Sanchez Gomez
 * @date 31/05/2018
 * @since 1.0
 */


public class IA  extends Elemento{
	private int fuerza;//@param fuerza de la IA
	private int x;//@param posici�n de la IA en el eje x
	private int y;//@param posici�n de la IA en el eje y
	
	
	
	/**
	 * @function IA (Constructor)
	 * @param Descripcion 
	 * @param fuerza
	 */
	public IA(String descripcion, int fuerza) {
		super(descripcion);
		this.fuerza = fuerza;
		
		
	}


	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/** @brief El ataque de la IA con tirada aleatoria de su fuerza
	 * @return  da�o
	 */
	 public int atacar() {
		 
		 Random r = new Random();
		 
		 int da�o= r.nextInt(this.fuerza+1);
		 
		 System.out.println("Da�o IA: "+da�o);
		 
		 return da�o;
	
}
}
