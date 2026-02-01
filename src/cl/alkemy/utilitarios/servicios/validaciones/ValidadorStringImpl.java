package cl.alkemy.utilitarios.servicios.validaciones;

/**
 * Clase ValidadorStringImpl
 * 
 * Implementa la validación de datos de tipo String.
 * <p>
 * Proporciona un método para validar si una cadena de texto
 * no es nula ni está vacía.
 * </p>
 * 
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 * 
 */

public class ValidadorStringImpl implements ValidadorDatos {

	/**
	 * Valida si el dato de tipo String no es nulo ni está vacío.
	 * 
	 * @param dato El dato de tipo String a validar.
	 * @return true si el dato es válido, false en caso contrario.
	 */
	
	@Override
    public boolean validar(String dato) {
		// Verifica si el dato es nulo o vacío
        return dato != null && !dato.trim().isEmpty();
	}

}
