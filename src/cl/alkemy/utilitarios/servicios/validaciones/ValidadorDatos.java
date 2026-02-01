package cl.alkemy.utilitarios.servicios.validaciones;

/**
 * Interfaz ValidadorDatos
 * 
 * Define el contrato para la validación de datos de entrada.
 * <p>
 * Proporciona un método para validar diferentes tipos de datos
 * según las reglas definidas en el enum TiposDeValidacion.
 * </p>
 * 
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 * 
 */
public interface ValidadorDatos {
	
	/**
	 * Valida el dato de entrada según las reglas definidas.
	 * 
	 * @param dato El dato de entrada a validar.
	 * @return true si el dato es válido, false en caso contrario.
	 */
	boolean validar(String dato);

}
