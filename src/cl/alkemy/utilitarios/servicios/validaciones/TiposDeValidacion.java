package cl.alkemy.utilitarios.servicios.validaciones;

/**
 * Enum TiposDeValidacion
 * 
 * Representa los tipos de validaciones de datos soportados por el sistema.
 * <p>
 * Se utiliza para identificar el tipo de validación que se debe aplicar
 * a los datos ingresados por el usuario.
 * </p>
 * 
 * Permite evitar el uso de Strings y reduce errores de validación.
 * 
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 * 
 */
public enum TiposDeValidacion {
	
	/**
	 * Para Campos de texto
	 */
	STRING,
	 
	 /**
	  * Para campos numéricos
	  */
	 NUMERICO

}
