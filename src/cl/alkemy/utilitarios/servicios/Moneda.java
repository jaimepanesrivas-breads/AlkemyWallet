package cl.alkemy.utilitarios.servicios;


/**
 * Enum Moneda
 * 
 * Representa los tipos de moneda soportados por el sistema.
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

	/** Peso Chileno */
	 CLP(0, '.', ','),   // miles '.', decimal ','
	
	 /** Dólar Estadounidense */
	 USD(3, ',', '.'),   // miles ',', decimal '.'
	 
	 /** Euro */
	 EURO(3, ',', '.');  // miles ',', decimal '.'

	
	/** 
	 * Número de decimales para la moneda 
	 * 
	 * */
	
	 private final int decimales;
	 
	 
	 /** 
	  * Carácter separador de miles 
	  * 
	  * */
	 private final char miles;
	 
	 /** 
	  * Carácter separador decimal 
	  * 
	  * */
	 private final char decimal;

	 /** 
	  * Constructor de Moneda 
	  * 
	  * @param decimales Número de decimales
	  * @param miles Carácter separador de miles
	  * @param decimal Carácter separador decimal
	  * 
	  * */
	 Moneda(int decimales, char miles, char decimal) {
		 this.decimales = decimales;
	     this.miles = miles;
	     this.decimal = decimal;
	 }
	 
	 /** 
	  * Obtiene el número de decimales para la moneda 
	  * 
	  * @return Número de decimales
	  * 
	  * */
	 public int getDecimales() { return decimales; }
	 
	 /** 
	  * Obtiene el carácter separador de miles 
	  * 
	  * @return Carácter separador de miles
	  * 
	  * */
	 public char getMiles() { return miles; }
	 
	 /** 
	  * Obtiene el carácter separador decimal 
	  * 
	  * @return Carácter separador decimal
	  * 
	  * */
	 public char getDecimal() { return decimal; }
}
