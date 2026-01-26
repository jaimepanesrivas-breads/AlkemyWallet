package cl.alkemy.utilitarios.servicios;

public class ConversorMonedaImpl implements ConversorMoneda {
	
	private static final double TASA_CL_USD = 900;

	@Override
	public double convertir(double monto, Moneda origen, Moneda destino) {
		// TODO Auto-generated method stub
			
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
		
		throw new IllegalArgumentException("Conversión no soportada");
	
	}
		
	
}
