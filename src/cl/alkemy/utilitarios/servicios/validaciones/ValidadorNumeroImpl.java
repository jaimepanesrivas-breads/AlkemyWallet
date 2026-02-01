package cl.alkemy.utilitarios.servicios.validaciones;

/**
 * Clase ValidadorNumeroImpl
 * 
 * Implementa la validación de datos numéricos.
 * <p>
 * Proporciona un método para validar si una cadena de texto
 * representa un número entero o decimal válido.
 * </p>
 * 
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 * 
 */


public class ValidadorNumeroImpl implements ValidadorDatos {

	/**
	 * Valida si el dato proporcionado es un número válido (entero o decimal).
	 * 
	 * @param dato La cadena de texto a validar.
	 * @return true si el dato es un número válido, false en caso contrario.
	 */
	
	@Override
	public boolean validar(String dato) {
		if (dato == null) return false;

	        try {
	            Double.parseDouble(dato.trim().replace(",", "."));
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }
}
