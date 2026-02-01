package cl.alkemy.utilitarios.servicios;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Tests unitarios para la clase {@link ConversorMonedaImpl}.
 *
 * Se validan los distintos escenarios de conversión
 * y el manejo de errores.
 *
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 */

public class ConversorMonedaImplTest {

		private ConversorMoneda conversor;
	 
		@BeforeEach
	    void setUp() {
	        conversor = new ConversorMonedaImpl();
	    }
	
	/**
	 * Test: Conversión válida de CLP a USD
	 */
	@Test
	void test() {
		double montoCLP = 9000;
		double resultadoUSD = conversor.convertir(montoCLP, Moneda.CLP, Moneda.USD);
		assertEquals(10, resultadoUSD, 0.0001);
		
	}
	
	/**
	 * Test: Conversión válida de CLP a USD pero con monto cero
	 */
	@Test
	void convertirConMontoOrigenCero() {
		double montoCLP = 0;
		double resultadoUSD = conversor.convertir(montoCLP, Moneda.CLP, Moneda.USD);
		assertEquals(0, resultadoUSD, 0.0001);
		
	}
	
	
	
	/**
     * Test: Conversión con misma moneda
     * Debe retornar el mismo monto
     */
    @Test
    void convertirMismaMonedaCLPCLP() {
        double monto = 1000;
        double resultado = conversor.convertir(monto, Moneda.CLP, Moneda.CLP);

        assertEquals(monto, resultado);
    }
    
    /**
     * Test: Conversión con misma moneda
     * Debe retornar el mismo monto
     */
    @Test
    void convertirMismaMonedaUSDUSD() {
        double monto = 1000;
        double resultado = conversor.convertir(monto, Moneda.USD, Moneda.USD);

        assertEquals(monto, resultado);
    }
	
	  /**
     * Test: Conversión válida de USD a CLP
     */
    @Test
    void convertirUSDaCLP() {
        double montoUSD = 1;
        double resultado = conversor.convertir(montoUSD, Moneda.USD, Moneda.CLP);

        assertEquals(900.0, resultado, 0.0001);
    }
    
    /**
	 * Test: Conversión con monto negativo
	 * Debe retornar 0
	 */
    @Test
    void convertirMontoNegativo() {
		double montoNegativo = -500;
		double resultado = conversor.convertir(montoNegativo, Moneda.CLP, Moneda.USD);

		assertEquals(0, resultado, 0.0001);
	}
    
   /**
    *  Test: Concersión válida de CLP a EURO
    */
    @Test
    void convertirCLPEURO() {
    	double montoCLP=1;
    	double resultado = conversor.convertir(montoCLP, Moneda.CLP, Moneda.EURO);
    	
    	assertEquals(0.001,resultado);
    }
    
    /**
     *  Test: Concersión válida de USD a EURO
     */
     @Test
    void convertirUSDEURO() {
    	double montoUSD=1;
    	double resultado = conversor.convertir(montoUSD, Moneda.USD, Moneda.EURO);
    	
    	assertEquals(0.909,resultado);
    }
    
     
     /**
      *  Test: Concersión válida de EURO a CLP
      */
      @Test
      void convertirEUROCLP() {
      	double montoEURO=1;
      	double resultado = conversor.convertir(montoEURO, Moneda.EURO, Moneda.CLP);
      	
      	assertEquals(1000,resultado);
      }
      
      /**
       *  Test: Concersión válida de EURO a USD
       */
       @Test
      void convertirEUROUSD() {
      	double montoEURO=1;
      	double resultado = conversor.convertir(montoEURO, Moneda.EURO, Moneda.USD);
      	
      	assertEquals(0.909,resultado);
      }
    
    
    
    /**
     * Test: Conversión no soportada
     * Debe lanzar IllegalArgumentException
     */
    @Test
    void convertirMonedaNoSoportada() {
        assertThrows(
            IllegalArgumentException.class,
            () -> conversor.convertir(1000, Moneda.valueOf("CLP"), null)
        );
    }

}
