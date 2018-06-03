package models;
/**
 * @class Entidad
 * @brief Clase abstracta que representa cualquier elemento que este en el mapa
 * @author Alberto Sanchez Gomez
 * @date 31/05/2018
 * @since 1.0
 */

public abstract class Elemento {
	
	private String descripcion;//@param descripcion representa la descripcion del elemento


	/**
	 * @function Elemento (Constructor)
	 * @param descripcion String la descripcion de la entidad
	 */
	public Elemento(String descripcion) {
		this.descripcion=descripcion;
		
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String toString() {
		return descripcion;
	}


}
