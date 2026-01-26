package cl.alkemy.utilitarios.servicios;


/**
 * Enum Moneda
 *  -----------------------
 * Enum que representa los tipos de moneda soportados por el sistema.
 * <p>
 * Se utiliza para identificar la moneda asociada a una cuenta bancaria
 * y a los movimientos registrados sobre ella.
 * </p>
 * 
 * Permite evitar el uso de Strings y reduce errores de validación.
 * 
 * @version 1.0
 */

public enum Moneda {

	/**
     * Peso Chileno.
     */
	CLP, 
	
	 /**
     * Dólar Amreicano.
     */
	USD	//Declaracion de monedas a usar.
	
}
