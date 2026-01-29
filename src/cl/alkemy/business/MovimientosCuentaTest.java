package cl.alkemy.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovimientosCuentaTest {

	private MovimientosCuenta movimientosCuenta;
	@BeforeEach
	void setUp() throws Exception {
		movimientosCuenta = new MovimientosCuenta();
		
	}
	
	
	@Test
	void test() {
		assertNotNull(movimientosCuenta);
	}
	
//	@Test
	//void testAgregarMovimiento() {
		//movimientosCuenta.agregarMovimiento("Depósito", 1000.0);
	//	assertEquals(1, movimientosCuenta.getMovimientos().size());
	//}

}
