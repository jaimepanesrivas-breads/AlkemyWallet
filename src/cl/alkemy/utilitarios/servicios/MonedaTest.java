package cl.alkemy.utilitarios.servicios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.alkemy.utilitarios.MoneyUtils;


/**
 * Tests unitarios para la clase {@link MonedaTest}.
 *
 * Se validan si lo elementos de formato de moneda para CLP, USD, y EURO
 * operan correctamente.
 * 
 * Adicionalmente si solo existen esas tres monedas.
 *
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 */



public class MonedaTest {

	@Test
	void testFormatearUSD() {

	    String resultado = MoneyUtils.formatear(12345.5, Moneda.USD);

	    assertEquals("12,345.500", resultado);
	}
	
	@Test
	void testFormatearCLP() {

	    String resultado = MoneyUtils.formatear(12345.9, Moneda.CLP);

	    assertEquals("12.346", resultado);
	}
	void testFormatearEURO() {

	    String resultado = MoneyUtils.formatear(12345.5, Moneda.EURO);

	    assertEquals("12,345.500", resultado);
	}
	
	@Test
	void testNormalizarUSD() {

	    double resultado = MoneyUtils.normalizar(10.1264, Moneda.USD);

	    assertEquals(10.126, resultado, 0.000001);
	}

	@Test
	void testNormalizarEURO() {

	    double resultado = MoneyUtils.normalizar(10.1264, Moneda.EURO);

	    assertEquals(10.126, resultado, 0.000001);
	}
	
	@Test
	void testNormalizarCLP() {

	    double resultado = MoneyUtils.normalizar(10.1264, Moneda.CLP);

	    assertEquals(10, resultado, 0.000001);
	}
	
    // Existencia de constantes

    @Test
    @DisplayName("Debe contener 3 monedas")
    void testCantidadMonedas() {
        assertEquals(3, Moneda.values().length);
    }

    @Test
    @DisplayName("Debe existir CLP, USD y EURO")
    void testExistenciaConstantes() {

        assertNotNull(Moneda.valueOf("CLP"));
        assertNotNull(Moneda.valueOf("USD"));
        assertNotNull(Moneda.valueOf("EURO"));
    }

    // CLP

    @Test
    @DisplayName("CLP debe tener 0 decimales y separadores correctos")
    void testCLP() {

        Moneda clp = Moneda.CLP;

        assertAll(
            () -> assertEquals(0, clp.getDecimales()),
            () -> assertEquals('.', clp.getMiles()),
            () -> assertEquals(',', clp.getDecimal())
        );
    }

    // USD

    @Test
    @DisplayName("USD debe tener 3 decimales y separadores correctos")
    void testUSD() {

        Moneda usd = Moneda.USD;

        assertAll(
            () -> assertEquals(3, usd.getDecimales()),
            () -> assertEquals(',', usd.getMiles()),
            () -> assertEquals('.', usd.getDecimal())
        );
    }

    // EURO

    @Test
    @DisplayName("EURO debe tener 3 decimales y separadores correctos")
    void testEURO() {

        Moneda eur = Moneda.EURO;

        assertAll(
            () -> assertEquals(3, eur.getDecimales()),
            () -> assertEquals(',', eur.getMiles()),
            () -> assertEquals('.', eur.getDecimal())
        );
    }
	
}
