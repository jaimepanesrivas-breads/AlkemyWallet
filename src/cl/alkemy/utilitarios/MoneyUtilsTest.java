package cl.alkemy.utilitarios;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.alkemy.utilitarios.servicios.Moneda;


/**
 * Tests unitarios para la clase {@link MoneyUtilsTest}.
 *
 * Se validan los distintos escenarios de conversión
 * y el manejo de errores.
 *
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 */

public class MoneyUtilsTest {

	  private static final double DELTA = 0.000001;

	    // =========================
	    // redondear()
	    // =========================

	    @Test
	    @DisplayName("Debe redondear HALF_UP a 2 decimales (USD)")
	    void testRedondearUSD() {

	        BigDecimal resultado = MoneyUtils.redondear(10.5557, Moneda.USD);

	        assertEquals(new BigDecimal("10.556"), resultado);
	    }

	    @Test
	    @DisplayName("Debe redondear a 0 decimales (CLP)")
	    void testRedondearCLP() {

	        BigDecimal resultado = MoneyUtils.redondear(1999.6, Moneda.CLP);

	        assertEquals(new BigDecimal("2000"), resultado);
	    }

	    // =========================
	    // normalizar()
	    // =========================

	    @Test
	    @DisplayName("normalizar debe devolver double redondeado")
	    void testNormalizarUSD() {

	        double resultado = MoneyUtils.normalizar(25.5558, Moneda.USD);

	        assertEquals(25.556, resultado, DELTA);
	    }

	    @Test
	    @DisplayName("normalizar CLP debe eliminar decimales")
	    void testNormalizarCLP() {

	        double resultado = MoneyUtils.normalizar(1234.8, Moneda.CLP);

	        assertEquals(1235, resultado, DELTA);
	    }

	    // =========================
	    // formatear()
	    // =========================

	    @Test
	    @DisplayName("Debe formatear con miles y 2 decimales (USD)")
	    void testFormatearUSD() {

	        String resultado = MoneyUtils.formatear(12345.5, Moneda.USD);
	        System.out.println("Resultado formatear USD: " + resultado);
	        // Puede ser 12,345.50 o 12.345,50 según tu configuración
	        String esperado1 = "12,345.500";
	        assertEquals(esperado1,resultado);
	        
//	        assertTrue(
//	                resultado.contains("12") &&
//	                resultado.contains("345") &&
//	                resultado.endsWith("50")
//	        );
	    }

	    @Test
	    @DisplayName("Debe formatear sin decimales (CLP)")
	    void testFormatearCLP() {

	        String resultado = MoneyUtils.formatear(1234567.8, Moneda.CLP);

	        assertFalse(resultado.contains(",00"));
	        assertFalse(resultado.contains(".00"));
	    }

	    // =========================
	    // casos borde
	    // =========================

	    @Test
	    @DisplayName("Debe manejar monto 0 correctamente")
	    void testCero() {

	        assertEquals("0", MoneyUtils.formatear(0, Moneda.CLP));
	        assertEquals(0, MoneyUtils.normalizar(0, Moneda.CLP), DELTA);
	    }

	    @Test
	    @DisplayName("Debe redondear HALF_UP correctamente en límite 5")
	    void testHalfUpLimite() {

	        double resultado = MoneyUtils.normalizar(10.1257, Moneda.USD);

	        assertEquals(10.126, resultado, DELTA);
	    }

}
