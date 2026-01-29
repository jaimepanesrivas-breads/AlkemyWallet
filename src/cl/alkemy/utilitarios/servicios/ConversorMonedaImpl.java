package cl.alkemy.utilitarios.servicios;

/**
 * Implementación concreta de la interfaz {@link ConversorMoneda}.
 * <p>
 * Proporciona la lógica de conversión entre pesos chilenos (CLP)
 * y dólares estadounidenses (USD), utilizando una tasa fija.
 * </p>
 *
 * <p>
 * Esta implementación está pensada para fines educativos
 * y no considera tasas dinámicas de mercado.
 * </p>
 *
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 */

public class ConversorMonedaImpl implements ConversorMoneda {
	
	
	/**
     * Tasa fija de conversión entre CLP y USD.
     * <p>
     * 1 USD = 900 CLP
     * </p>
     */
	private static final double TASA_CL_USD = 900;
	
	/**
     * {@inheritDoc}
     */
	@Override
	public double convertir(double monto, Moneda origen, Moneda destino) {
		// TODO Auto-generated method stub
		if (monto >0) {
			if (origen == destino) {
				System.out.println("\nNo se puedo realizar el cambio de moneda dado que Moneda Origen ( " + origen + " ) es igual a la Moneda Destino ( " + destino + " )" );
				return monto;
			}
			
			if (origen == Moneda.CLP && destino == Moneda.USD) {
				System.out.println("\nRealizando el cambio de moneda de " + Moneda.CLP + " a " + Moneda.USD);
				return monto / TASA_CL_USD;
			}
			
			if (origen == Moneda.USD && destino == Moneda.CLP) {
				System.out.println("\nRealizando el cambio de moneda de " + Moneda.USD + " a " + Moneda.CLP);
				return monto * TASA_CL_USD;
			}
		} else {
			System.out.println("\nEl monto a convertir debe ser mayor a cero.");
			return 0;
		}
		
		
		
		// Se lanza excepción cuando la combinación de monedas
	    // no está definida en esta implementación
		throw new IllegalArgumentException("Conversión no soportada");
	
	}
		
	
}
