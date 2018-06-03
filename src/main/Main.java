package main;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map.Entry;

import models.*;
import tablero.Mapa;
/**
 * @class Main
 * @brief La clase base que hace que funcione el juego
 * @author Alberto Sanchez Gomez
 * @date 31/05/2018
 * @since 1.0
 */

public class Main {

	public static void main(String[] args) {
		boolean partidafinalizada = false; /**@brief metodo para finalizar el juego
		                                   *@return boolean para saber si la partida ha acabado
		                                   */
		
		
		
		
		 //@brief Aqui creas a los enemigos, personajes, objetos que habrá dentro de tu juego, añadiendolos luego en su ArrayList
		Jugador j = new Jugador("Exiliado de la villa oculta de la hoja", "Lionhart");
		IA jefe = new IA("Final boss", 5);
		IA bicho1 = new IA("Zombie", 2);
		IA bicho2 = new IA("Frankestein", 1);
		IA bicho3 = new IA("Vampiro", 2);
		Elemento espada = new Espada("Espada", 2);
		Elemento tienda = new Tienda("Pequeña tienda de pociones", null);
		Elemento oro = new BolsaDeOro("bolsa de oro");
		Elemento oro1 = new BolsaDeOro("bolsa de oro");

		ArrayList<Elemento> e = new ArrayList<>();
		e.add(jefe);
		e.add(bicho1);
		e.add(bicho2);
		e.add(espada);
		e.add(bicho3);
		e.add(tienda);
		e.add(oro);
		e.add(oro1);

	

		Mapa m = new Mapa(4, 4, e, j);
		
		
		/**@brief metodo para almacenar la Base de Datos
         */

		/*Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/zork?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","nemesis97");
			Statement smt=(Statement) con.createStatement();
			int insercion1 = ((java.sql.Statement) smt).executeUpdate("CREATE TABLE IF NOT EXISTS Movimientos (NumeroMovimientos INT(4))");
			int insercion2 = ((java.sql.Statement) smt).executeUpdate("insert into movimientos values ('" + j.getMovimientos() + "')");
			ResultSet rs = ((java.sql.Statement) smt).executeQuery("select min(NumeroMovimientos) from zork.Movimientos");
			
			while (rs.next()) {
				if(rs.getInt(1) > j.getMovimientos()) {
					System.out.println("Has hecho un nuevo record");
				}
				System.out.println("El record es de: " + rs.getInt(1));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}*/

		
		
		
		/**@brief añadimos los stats del personaje y coordenadas, para saber en todo momentos como vamos
         */
		while (partidafinalizada == false) {
			
			System.out.println("Fuerza: " + j.getFuerza());
			System.out.println("Oro: " + j.getOro());
			System.out.println(m.getCasillas()[j.getX()][j.getY()].getDescripcion());
			System.out.println(j.getX() + "|" + j.getY());
			
			/**@brief metodo que te encuentra la espada en el mapa y permite cogerla
             */
			if (m.getCasillas()[j.getX()][j.getY()].getElemento() != null) {
				System.out.println("Atención!!");
				if (m.getCasillas()[j.getX()][j.getY()].getElemento().getClass().getName().equals("models.Espada")) {
					
					
					/** @brief Con un switch de opcionElegida, en caso de que pulses 8 te la cogerá
		             */

					System.out.println("Pulsa 8 para coger la espada");
					Scanner s = new Scanner(System.in);
					int opcionElegida = s.nextInt();

					switch (opcionElegida) {

					case 8:
						j.incrementarFuerza(5);
						m.getCasillas()[j.getX()][j.getY()].borrarElemento();

						break;

					}

				}

				/**@brief Coge las casillas con el elementos y si es IA comienza una batalla
				 * 
	             */
				 else if (m.getCasillas()[j.getX()][j.getY()].getElemento().getClass().getName().equals("models.IA")) {
					System.out.println("Cuidado comienza la batalla");
					if (j.luchar(((IA) m.getCasillas()[j.getX()][j.getY()].getElemento()).atacar())) {
						System.out.println("Has ganado");
						/** @brief Si la IA que vences es Final Boss el booleano devuelve true
			             */
						if (m.getCasillas()[j.getX()][j.getY()].getElemento().getDescripcion().equals("Final Boss")) {
							partidafinalizada = true;
							System.out.println("HAS COMPLETADO EL JUEGO");
						}
						m.getCasillas()[j.getX()][j.getY()].borrarElemento();
						
						
						/**@brief Sirve para acabar la partida 
						 * @brief Si la IA te vence el booleando se vuelve true también
			             */
					} else {
						System.out.println("has perdido");
						partidafinalizada = true;
					}

				}
				/**@brief Busca elementos por las casillas, si es BolsaDeOro la coge y te suma 100
	             */
				else if (m.getCasillas()[j.getX()][j.getY()].getElemento().getClass().getName()
						.equals("models.BolsaDeOro")) {
					System.out.println("Has encontrado una bolsa de oro!!");
					j.setOro(j.getOro() + 100);
					m.getCasillas()[j.getX()][j.getY()].borrarElemento();

				}
				/** @brief boolean si tienes 200 de oro es true y te compra la poción
	             */
				else if (m.getCasillas()[j.getX()][j.getY()].getElemento().getClass().getName().equals("models.Tienda")) {

					opcionElegidaTienda(j);

				}

			}
			/**@brief un metodo que te anula los movimientos del jugador al acabar el juego
             */
			if (!partidafinalizada) {
				j.pedirOpcionesJugador(m);
			}
		}

	}

	
		


	public static void opcionElegidaTienda(Jugador j) {

		System.out.println("Bienvenido a la tienda, con 200 de oro puedes adquirir la poción");

		if (j.getOro() >= 200) {
			j.setFuerza(j.getFuerza() * 2);
			j.setOro(j.getOro() - 200);

		}

		
		

	}
}
