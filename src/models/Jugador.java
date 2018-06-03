package models;

import java.util.Random;
import java.util.Scanner;

import tablero.Mapa;
/**
 * @class Jugador
 * @brief La clase del jugador principal 
 * @author Alberto Sanchez Gomez
 * @date 31/05/2018
 * @since 1.0
 */

public class Jugador extends Elemento{
	private String nombre;;//@param descripcion representa el nombre del jugador
	private int oro;;//@param descripcion representa el oro del jugador
	private int fuerza;;//@param descripcion representa la fuerza del jugador
	private int x;;//@param descripcion representa el eje X del jugador
	private int y;;//@param descripcion representa el eje Y del jugador
	private boolean suficienteOro;;//@param descripcion representa el oro Suficiente para comprar  del jugador
	private int movimientos;;//@param descripcion representa los movimientos del jugador
	
	

	

	/**
	 * @function Jugador (Constructor)
	 * @param descripcion
	 * @param nombre
	 */
	public Jugador(String descripcion, String nombre) {
		super(descripcion);
		this.nombre = nombre;
		this.oro = 0;
		this.fuerza = 3;
		this.suficienteOro = false;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getOro() {
		return oro;
	}

	public void setOro(int oro) {
		this.oro = oro;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	
	public void incrementarFuerza(int f) {
		this.fuerza+=f;
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

	public boolean isSuficienteOro() {
		return suficienteOro;
	}

	public void setSuficienteOro(boolean suficienteOro) {
		this.suficienteOro = suficienteOro;
	}
	public int getMovimientos() {
		return movimientos;
	}


	public void setMovimientos(int movimientos) {
		this.movimientos = movimientos;
	}
	
	
	/**
	 * @brief metodo de combate del jugador con tirada aleatoria de su fuerza
	  
	 */
	
	public int atacar() {

		Random r = new Random();
		System.out.println("Saco aleatorio entre 0 y "+(this.getFuerza () + 1));
		int daño = r.nextInt(this.getFuerza () + 1);
		System.out.println("daño jugador: "+daño);

		return daño;
	}

	/**
	 * @brief metodo de combate del jugador con tirada aleatoria de su fuerza contra la del enemigo 
	 *@param fuerzaIA
	 *@return boolean si es mayor o menor su fuerza
	 */
	public boolean luchar(int fuerzaIA) {

		if (atacar() >= fuerzaIA) {

			return true;

		} else {
			return false;
		}

	}
	
	/**
	 *@brief metodo de movimiento por el mapa por un switch
	 *@param el mapa del juego
	 *@throws salirte de las casillas
	 */
	public void pedirOpcionesJugador(Mapa m) {
		boolean posCorrecta=true;
		do{
		Scanner reader = new Scanner(System.in);

		int eleccion;
		do {
			System.out.println("---Elija una de ellas-");
			System.out.println("1. Norte ");
			System.out.println("2. Sur ");
			System.out.println("3. Este ");
			System.out.println("4. Oeste ");
			eleccion = reader.nextInt();
			
		} while (eleccion <1 || eleccion >4);
		
		 try {
			opcionesJugador(eleccion,m);
			posCorrecta=true;
		} catch (miExcepcionFueraDeMapa e) {
			// TODO Auto-generated catch block
			posCorrecta=false;
			System.out.println("No puedes ir alli. Elige otra opción");
		}
		}while(!posCorrecta);
		
	
	}

	public void opcionesJugador(int eleccion, Mapa m) throws miExcepcionFueraDeMapa {
	
		switch (eleccion) {
		
		case 1: 
			if ((getY()-1)<0) {
				throw new miExcepcionFueraDeMapa();
			}
			else {
			    this.setY(getY()-1);
			}
			
			break;
		case 2:
			if ((getY()+1)>m.getCasillas().length-1) {
				throw new miExcepcionFueraDeMapa();
			}
			  this.setY(getY()+1);
		
			break;
		case 3:
			if ((getX()+1)>m.getCasillas().length-1) {
				throw new miExcepcionFueraDeMapa();
			}
			  this.setX(getX()+1);
				
			
			break;
		case 4:
			if ((getX()-1)<0) {
				throw new miExcepcionFueraDeMapa();
			}
			  this.setX(getX()-1);
			break;
		
			
		}

	}
}


