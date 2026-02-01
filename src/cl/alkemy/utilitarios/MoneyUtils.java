package cl.alkemy.utilitarios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import cl.alkemy.utilitarios.servicios.Moneda;


/**
 * Clase MoneyUtils
 * 
 * Proporciona utilidades para el manejo de montos monetarios,
 * incluyendo redondeo, formateo y normalización según la moneda especificada.
 * 
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 * 
 */


public class MoneyUtils {
	
	private MoneyUtils() {}

    /**
	 * Redondea un monto al número de decimales
	 * 
	 * @param monto
	 * @param moneda
	 * @return
	 */
    public static BigDecimal redondear(double monto, Moneda moneda) {

        return BigDecimal
                .valueOf(monto)
                .setScale(moneda.getDecimales(), RoundingMode.HALF_UP);
    }

    /**
     * 
     * @param monto
     * @param moneda
     * @return
     */
    public static String formatear(double monto, Moneda moneda) {

        BigDecimal bd = redondear(monto, moneda);

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(moneda.getMiles());
        symbols.setDecimalSeparator(moneda.getDecimal());

        String pattern = "#,##0";

        if (moneda.getDecimales() > 0) {
            pattern += "." + "0".repeat(moneda.getDecimales());
        }

        DecimalFormat df = new DecimalFormat(pattern, symbols);
        df.setGroupingUsed(true);

        return df.format(bd);
    }

    /**
	 * Normaliza un monto al número de decimales de la moneda especificada.
	 * @param monto
	 * @param moneda
	 * @return
	 */
    public static double normalizar(double monto, Moneda moneda) {
        return BigDecimal
                .valueOf(monto)
                .setScale(moneda.getDecimales(), RoundingMode.HALF_UP)
                .doubleValue();
    }
}
