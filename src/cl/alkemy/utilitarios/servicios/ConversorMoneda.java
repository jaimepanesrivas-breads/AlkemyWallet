package cl.alkemy.utilitarios.servicios;


/**
 * Interfaz ConversorMoneda
 * <p>
 * Define el contrato para la conversión de montos entre
 * distintos tipos de moneda.
 * </p>
 *
 * <p>
 * Las implementaciones de esta interfaz deben proporcionar
 * la lógica de conversión según las monedas de origen y destino.
 * </p>
 *
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 */

public interface ConversorMoneda {

	
	 /**
     * Convierte un monto desde una moneda de origen
     * hacia una moneda de destino.
     *
     * @param monto   monto a convertir
     * @param origen  moneda de origen
     * @param destino moneda de destino
     * @return monto convertido a la moneda destino
     *
     * @throws IllegalArgumentException si la conversión no está soportada
     */
	
	double convertir(double monto,Moneda origen, Moneda destino);
}
