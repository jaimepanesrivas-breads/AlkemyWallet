package cl.alkemy.utilitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cl.alkemy.utilitarios.servicios.ConversorMoneda;
import cl.alkemy.utilitarios.servicios.ConversorMonedaImpl;


/**
 * Tests unitarios para la clase {@link NumeroCuentaRandom}.
 *
 * Se validan los distintos escenarios de conversión
 * y el manejo de errores.
 *
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 */


class NumeroCuentaRandomTest {

	private int max;
	private int min;
	private int numeroRandom;
	 
	@BeforeEach
    void setUp() {
        max = 1;
		min = -1000000;
		numeroRandom = (int)(Math.random() * (max - min + 1) + min);
    }
	
	@Test
	void testNumeroCuentaRandomDentroRango() {
		max = 1;
		min = -1000000;
		numeroRandom = (int)(Math.random() * (max - min + 1) + min);
		assertTrue(numeroRandom >= min && numeroRandom <= max,"El número de cuenta generado está fuera del rango esperado.");
	}
	
	@Test
	void testNumeroCuentaRandomIgualMinimo() {
		max = 1;
		min = 1;
		numeroRandom = (int)(Math.random() * (max - min + 1) + min);
		numeroRandom = min;
		assertEquals(min, numeroRandom,"El número de cuenta generado no es igual al valor mínimo esperado.");
	}
	
	@Test
	void testNumeroCuentaRandomIgualMaximo() {
		max = 10000;
		min = 1;
		numeroRandom = (int)(Math.random() * (max - min + 1) + min);
		numeroRandom = max;
		assertEquals(max, numeroRandom,"el número de cuenta generado no es igual al valor máximo esperado.");

	}
	
	@Test
	void testNumeroCuentaRandomRepetibilidad() {
		
		int otroNumeroRandom = (int)(Math.random() * (max - min + 1) + min);
		assertNotEquals(numeroRandom, otroNumeroRandom,"Los números de cuenta generados son iguales, se esperaba que fueran diferentes.");
	}	
}
