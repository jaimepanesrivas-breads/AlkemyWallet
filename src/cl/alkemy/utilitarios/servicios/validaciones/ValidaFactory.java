package cl.alkemy.utilitarios.servicios.validaciones;


/**
 * Clase ValidaFactory
 * 
 * Implementa el patrón de diseño Factory para crear instancias
 * de validadores de datos según el tipo de validación requerido.
 * <p>
 * Proporciona un método estático para obtener el validador adecuado
 * basado en el enum TiposDeValidacion.
 * </p>
 * 
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 * 
 */

public class ValidaFactory {
	
	/**
	 * Constructor vacio
	 */
	public ValidaFactory() {}

	    
		/**
	     * Método estático para obtener una instancia de ValidadorDatos
	     * según el tipo de validación especificado.
	     * 
	     * @param tipo El tipo de validación requerido (STRING o NUMERICO).
	     * @return Una instancia del validador correspondiente.
	     * @throws IllegalArgumentException Si el tipo de validación no es soportado.
	     */
		public static ValidadorDatos obtenerValidador(TiposDeValidacion tipo) {

	        // Retorna la instancia del validador correspondiente según el tipo
	    	switch (tipo) {
	            case STRING:
	                return new ValidadorStringImpl();
	            case NUMERICO:
	                return new ValidadorNumeroImpl();
	            default:
	                throw new IllegalArgumentException("Tipo de validación no soportado");
	        }
	    }

}
