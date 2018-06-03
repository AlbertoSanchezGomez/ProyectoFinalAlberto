package tablero;

import java.util.ArrayList;

import java.util.Random;

import models.Elemento;
import models.Espada;
import models.IA;
import models.Jugador;
/**
 * @class Mapa
 * @brief La  clase que junta todas las casillas y forma el mapa
 * @author Alberto Sanchez Gomez
 * @date 31/05/2018
 * @since 1.0
 */

public class Mapa {
	
	private Casilla[][] casillas;//@param casillas de una matriz
	
	/**
	 * @function Mapa (Constructor)
	 * @param filas
	 * @param columnas
	 * @param elemento e
	 * @param jugador j
	 */

	public Mapa(int filas, int columnas, ArrayList<Elemento> e, Jugador j) {
		casillas = new Casilla[filas][columnas];

		casillas[0][0] = new Casilla("Bosque", null);
		casillas[0][1] = new Casilla("Bosque", null);
		casillas[0][2] = new Casilla("Bosque", null);
		casillas[0][3] = new Casilla("Cueva", null);
		casillas[1][0] = new Casilla("Cueva", null);
		casillas[1][1] = new Casilla("Rio Negro", null);
		casillas[1][2] = new Casilla("Rio Rojo", null);
		casillas[1][3] = new Casilla("Rio Rojo", null);
		casillas[2][0] = new Casilla("Montaña", null);
		casillas[2][1] = new Casilla("Montaña", null);
		casillas[2][2] = new Casilla("Montaña", null);
		casillas[2][3] = new Casilla("Cementerio", null);
		casillas[3][0] = new Casilla("Poblado", null);
		casillas[3][1] = new Casilla("Desierto", null);
		casillas[3][2] = new Casilla("Desierto", null);
		casillas[3][3] = new Casilla("Desierto", null);

		/** @brief te genera los elementos aleatorios por el mapa juntos al personaje, mientras la casilla esté
		 * vacía
		 
		 */
		Random x = new Random();
		Random y = new Random();
		int x1 = x.nextInt(4);
		int y1 = y.nextInt(4);
		
		while (e.isEmpty() != true) {
			if (casillas[x1][y1].getElemento() == null) {
				casillas[x1][y1].setElemento(e.get(e.size() - 1));
				e.remove(e.size() - 1);

			}
			x1 = x.nextInt(4);
			y1 = y.nextInt(4);
		}
		
		while (casillas[x1][y1].getElemento() != null) {
			x1 = x.nextInt(4);
			y1 = y.nextInt(4);
		}
		j.setX(x1);
		j.setY(y1);
	}

	public String dimeTamaño() {
		return "Mapa con " + casillas.length + " filas y " + casillas[0].length + " columnas";
	}

	public String toString() {
		String ret = "";
		for (int fila = 0; fila < casillas.length; fila++) {
			ret += "\n";
			for (int col = 0; col < casillas[fila].length; col++) {
				ret += fila + "," + col + " : " + casillas[fila][col].toString() + "  ";
			}
		}
		return ret;
	}

	public Casilla[][] getCasillas() {
		return casillas;
	}

	public void setCasillas(Casilla[][] casillas) {
		this.casillas = casillas;
	}

}
