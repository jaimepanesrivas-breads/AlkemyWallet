package cl.alkemy.utilitarios;


/**
 * Clase NumeroCuentaRandom
 * 
 * <p>Esta clase se encarga de generar un número aleatorio entre un rango dado por max y min.
 * Este número es utilizado como número de cuenta.
 * </p>
 * 
 * @author Jaime Francisco Panes Rivas.
 * @version 1.0
 * @since 2026-01
 * 
 */


public class NumeroCuentaRandom {

	//Atributos
	
	
	/**
	 * Número entero maximo para generar número random aleatorio
	 */
	int max;
	
	/**
	 * Número entero minimo para generar número random aleatorio
	 */
	int min;
	
	/**
	 * Número entero random generado entre max y min
	 */
	int numeroRandom;
	
	
	//Constructors
			
	/**
	 * Constructor NumeroCuentaRandom sin parámetros
	 * 
	 * <p>
	 * Inicializa el objeto MovimientosCuenta sin parámetros, con datos
	 * por defecto.
	 * </P>
	 * 	
	 * 
	 */
	
	public NumeroCuentaRandom() {
		this.max = 1;//modificar por defecto si es necesario
		this.min = 1;//modificar por defecto si es necesario
		this.numeroRandom = (int)(Math.random() * (max - min + 1) + min);
	}
	
	
	/**
	 * Constructor NumeroCuentaRandom sin parámetros
	 * 
	 * <p>
	 * Inicializa el objeto MovimientosCuenta con los parámetros dados por las constantes 
	 * MAX y MiN declaradas en Clase PrincipalAlkemyWallet.
	 * </P>
	 * 
	 * @param max valor máximo para generar el número random
	 * @param min valor mínimo para generar el número random
	 * 
	 */
	public NumeroCuentaRandom(int max, int min) {
		this.max = max;
		this.min = min;
		this.numeroRandom = (int)(Math.random() * (max - min + 1) + min);
	}
	


	//Getters y Setters
		
	/**
	 * Obtiene el valor máximo para generar el número random
	 * 
	 * @return max valor máximo
	 */
	public int getNumeroRandom() {
		return numeroRandom;
	}
	
	/**
	 * Establece el valor del número random generado
	 * 
	 * @param numeroRandom valor del número random
	 */
	public void setNumeroRandom(int numeroRandom) {
		this.numeroRandom = numeroRandom;
	}
	
		
	
}
