package cl.alkemy.business;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import cl.alkemy.utilitarios.servicios.Moneda;


/**
 * Tests unitarios para la clase {@link AlkemyCuenta}.
 *
 * Se validan los distintos escenarios de depósito y giro,
 * así como la correcta inicialización y manejo de movimientos.
 *
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 */


public class AlkemyCuentaTest {

	// Atributo de prueba
	@SuppressWarnings("unused")
	private Cuenta cuenta;
	
	// Configuración previa a cada test
	@BeforeEach
	void setUp() throws Exception {
		cuenta = new AlkemyCuenta();		
	
	}
	
	/** 
	 * Test de existencia del objeto cuenta
	 * 
	 */
	@Test
	@DisplayName("Prueba que objeto cuenta no sea vacio")
	void test() {
		
		assertNotNull(cuenta);
	}
	
	/**
	 * Test instancia de tipo Cuenta
	 */
	@Test
	@DisplayName("genra instancia")
	void testTipoCuenta() {
		assertTrue(cuenta instanceof Cuenta);
	}

	/** 
	 * Test de inicialización movimientos
	 */
	@Test
	@DisplayName("Obtener movimientos")
	void testInicializacionMovimientos() {
		assertNotNull(((AlkemyCuenta)cuenta).getMovimientos());
	}
	
	/** 
	 * Test de inicialización saldo
	 */
	@Test
	void testInicializacionSaldo() {
		assertEquals(-1.0, ((AlkemyCuenta)cuenta).getSaldoActual());
	}
	
	
	/** 
	 * Test de inicialización número cuenta
	 */
	@Test
	void testInicializacionNumeroCuenta() {
		assertEquals(0, ((AlkemyCuenta)cuenta).getNumeroCuenta());
	}
	
	/** 
	 * Test de movimientos en lista vacía
	 */
	@Test
	void testMovimientosListaVacia() {
		assertEquals(0, ((AlkemyCuenta)cuenta).getMovimientos().size());
	}	
	
	/** 
	 * Test de depósito válido
	 */
	@Test
	void testDepositar() {
		cuenta.depositar(1000);
		assertEquals(999.0, cuenta.getSaldoActual());
		// verificar que se agregó un movimiento de tipo ABONO
		assertEquals(1, ((AlkemyCuenta)cuenta).getMovimientos().size());
		assertEquals("ABONO", ((AlkemyCuenta)cuenta).getMovimientos().get(0).getTipo());
		assertEquals(1000.0, ((AlkemyCuenta)cuenta).getMovimientos().get(0).getMonto());
	}
	
	/** 
	 * Test de múltiples depósitos válidos
	 */
	@Test
	void testDepositarVarios() {
		cuenta.depositar(1000);
		cuenta.depositar(500);
		assertEquals(1499.0, cuenta.getSaldoActual());
		assertEquals(2, ((AlkemyCuenta)cuenta).getMovimientos().size());
	}
	
	/** 
	 * Test de depósito cero
	 */
	@Test
	void testDepositarCero() {
		cuenta.depositar(0);
		assertEquals(-1.0, cuenta.getSaldoActual());
		assertEquals(0, ((AlkemyCuenta)cuenta).getMovimientos().size());
	}
	
	/** 
	 * Test de depósito negativo
	 */
	@Test
	void testDepositarNegativo() {
		cuenta.depositar(-500);
		assertEquals(-1.0, cuenta.getSaldoActual());
		assertEquals(0, ((AlkemyCuenta)cuenta).getMovimientos().size());
	}
	
	/** 
	 * Test de retiro válido desopués de depósito
	 */
	@Test
	void testRetirar() {
		cuenta.depositar(1000);
		cuenta.giro(400);
		assertEquals(599.0, cuenta.getSaldoActual());
		assertEquals(2, ((AlkemyCuenta)cuenta).getMovimientos().size());
		assertEquals("GIRO", ((AlkemyCuenta)cuenta).getMovimientos().get(1).getTipo());
		assertEquals(400.0, ((AlkemyCuenta)cuenta).getMovimientos().get(1).getMonto());
	}

	/** 
	 * Test de retiro insuficiente
	 */
	@Test
	void testRetirarInsuficiente() {
		cuenta.depositar(100);
		cuenta.giro(200);
		// saldo no cambia por giro insuficiente
		assertEquals(99.0, cuenta.getSaldoActual());
		// no debe agregarse movimiento GIRO
		assertEquals(1, ((AlkemyCuenta)cuenta).getMovimientos().size());
	}
	
	/** 
	 * Test de retiro cero o negativo
	 */
	@Test
	void testRetirarCeroONegativo() {
		cuenta.depositar(100);
		cuenta.giro(0);
		cuenta.giro(-50);
		assertEquals(99.0, cuenta.getSaldoActual());
		// no agrega movimientos adicionales
		assertEquals(1, ((AlkemyCuenta)cuenta).getMovimientos().size());
	}
	
	/** 
	 * Test constructor parametrizado y movimiento CREA
	 */
	@Test
	void testConstructorParametrizadoYMovimientoCrea() {
		AlkemyCuenta c = new AlkemyCuenta(123, "Pepe", 500.0, Moneda.USD);
		assertEquals(123, c.getNumeroCuenta());
		assertEquals("Pepe", c.getNombreTitular());
		assertEquals(500.0, c.getSaldoActual());
		assertEquals(Moneda.USD, c.getTipoMoneda());
		// constructor parametrizado agrega movimiento CREA
		assertEquals(1, c.getMovimientos().size());
		assertEquals("CREA", c.getMovimientos().get(0).getTipo());
		assertEquals(500.0, c.getMovimientos().get(0).getMonto());
	}

	/** 
	 * Test setters y getters
	 */
	@Test
	void testSettersAndGetters() {
		AlkemyCuenta c = new AlkemyCuenta();
		c.setNumeroCuenta(77);
		c.setNombreTitular("Maria");
		c.setSaldoActual(250.0);
		c.setTipoMoneda(Moneda.CLP);
		assertEquals(77, c.getNumeroCuenta());
		assertEquals("Maria", c.getNombreTitular());
		assertEquals(250.0, c.getSaldoActual());
		assertEquals(Moneda.CLP, c.getTipoMoneda());
	}
	
	/** 
	 * Test de impresión de cuenta y movimientos
	 */
	 @Test
	    void testSaldoPrevioEnDeposito() {
	        AlkemyCuenta c = new AlkemyCuenta(1, "User", 200.0, Moneda.CLP);
	        c.depositar(80.0);
	        assertEquals(280.0, c.getSaldoActual());
	        assertEquals(2, c.getMovimientos().size());
	        // movimiento ABONO debe registrar saldo previo (200.0)
	        assertEquals(200.0, c.getMovimientos().get(1).getSaldoResultante());
	    }

	 /** 
	  * Test saldo previo ante un giro
	  */   
	 @Test
	    void testSaldoPrevioEnGiro() {
	        AlkemyCuenta c = new AlkemyCuenta(2, "User2", 500.0, Moneda.CLP);
	        c.giro(150.0);
	        assertEquals(350.0, c.getSaldoActual());
	        assertEquals(2, c.getMovimientos().size());
	        assertEquals(500.0, c.getMovimientos().get(1).getSaldoResultante());
	    }

	 /** 
	  * Test salida por consola de imprimir y mostrarMovimientos
	  */  
	 @Test
	    void testImprimirYMostrarMovimientosOutput() {
	        AlkemyCuenta c = new AlkemyCuenta(3, "Ana", 1000.0, Moneda.USD);
	        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	        PrintStream originalOut = System.out;
	        try {
	            System.setOut(new PrintStream(outContent));
	            c.imprimir();
	            c.mostrarMovimientos();
	        } finally {
	            System.setOut(originalOut);
	        }
	        String output = outContent.toString();
	        assertTrue(output.contains("Número Cuenta"));
	        assertTrue(output.contains("Nombre Titular"));
	        assertTrue(output.contains("HISTORIAL DE MOVIMIENTOS") || output.contains("HISTORIAL"));
	        assertTrue(output.contains("CREA"));
	    }

	   
	 /** 
	  * Test de constructores y fecha en MovimientosCuenta
	  */
	 @Test
	    void testMovimientosCuentaConstructorsYFecha() {
	        MovimientosCuenta m1 = new MovimientosCuenta();
	        assertNull(m1.getFecha());
	        m1.setTipo("TEST");
	        m1.setMonto(10.0);
	        m1.setSaldoResultante(0.0);
	        m1.setTipoMoneda(Moneda.CLP);
	        assertEquals("TEST", m1.getTipo());
	        assertEquals(10.0, m1.getMonto());
	        assertEquals(Moneda.CLP, m1.getTipoMoneda());

	        MovimientosCuenta m2 = new MovimientosCuenta("CREA", 50.0, 0.0, Moneda.USD);
	        assertNotNull(m2.getFecha());
	        // la fecha debe ser cercana a ahora (solo comprobamos que no es nula)
	        assertEquals("CREA", m2.getTipo());
	        assertEquals(50.0, m2.getMonto());
	    }

	 /** 
	  * Test de reemplazo de lista de movimientos
	  */   
	 @Test
	    void testSetMovimientosReplaceList() {
	        AlkemyCuenta c = new AlkemyCuenta();
	        assertNotNull(c.getMovimientos());
	        java.util.ArrayList<MovimientosCuenta> nueva = new java.util.ArrayList<>();
	        nueva.add(new MovimientosCuenta("CREA", 10.0, 0.0, Moneda.CLP));
	        c.setMovimientos(nueva);
	        assertEquals(1, c.getMovimientos().size());
	        assertEquals("CREA", c.getMovimientos().get(0).getTipo());
	    }

	 /** 
	  * Test de varios movimientos y saldo final
	  */
	 @Test
	    void testVariosMovimientosYSaldo() {
	        AlkemyCuenta c = new AlkemyCuenta(4, "Luis", 300.0, Moneda.CLP);
	        c.depositar(200.0); // saldo 500.0
	        c.giro(100.0);      // saldo 400.0
	        c.depositar(50.0);  // saldo 450.0
	        c.giro(500.0);      // giro insuficiente, saldo sigue 450.0

	        assertEquals(450.0, c.getSaldoActual());
	        assertEquals(4, c.getMovimientos().size());

	        assertEquals("CREA", c.getMovimientos().get(0).getTipo());
	        assertEquals("ABONO", c.getMovimientos().get(1).getTipo());
	        assertEquals("GIRO", c.getMovimientos().get(2).getTipo());
	        assertEquals("ABONO", c.getMovimientos().get(3).getTipo());
	    }	    
}