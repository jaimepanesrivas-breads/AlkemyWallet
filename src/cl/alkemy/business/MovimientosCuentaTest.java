package cl.alkemy.business;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.alkemy.utilitarios.servicios.Moneda;


/**
 * Tests unitarios para la clase {@link MovimientosCuentaTest}.
 *
 * Se validan los distintos escenarios de depósito y giro,
 * así como la correcta inicialización y manejo de movimientos.
 *
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 */

public class MovimientosCuentaTest {

	private static final double DELTA = 0.0001;

    @Test
    @DisplayName("Constructor de MovimientosCuenta vacío debe inicializar valores por defecto")
    void testConstructorVacio() {

        MovimientosCuenta mov = new MovimientosCuenta();

        assertAll(
            () -> assertEquals("", mov.getTipo()),
            // Verificar que el monto sea double
            () -> assertEquals(0, mov.getMonto(), DELTA),
            // Verificar que el Saldo sea double
            () -> assertEquals(0, mov.getSaldoResultante(), DELTA),
            () -> assertNull(mov.getTipoMoneda()),
            () -> assertNull(mov.getFecha())
        );
    }

    @Test
    @DisplayName("Constructor con parámetros debe inicializar correctamente")
    void testConstructorConParametros() {

        LocalDateTime antes = LocalDateTime.now();
        // Simulamos el crear un movimiento de ABONO en CLP
        MovimientosCuenta mov =  new MovimientosCuenta("ABONO", 10000, 15000, Moneda.CLP);

        LocalDateTime despues = LocalDateTime.now();
        
        // Validación de los datos ingresados en el constructor
        assertAll(
            () -> assertEquals("ABONO", mov.getTipo()),
            () -> assertEquals(10000, mov.getMonto(), DELTA),
            () -> assertEquals(15000, mov.getSaldoResultante(), DELTA),
            () -> assertEquals(Moneda.CLP, mov.getTipoMoneda()),
            () -> assertNotNull(mov.getFecha()),
            () -> assertTrue(
                    !mov.getFecha().isBefore(antes) &&
                    !mov.getFecha().isAfter(despues)
            )
        );
    }

    @Test
    @DisplayName("Setters deben modificar correctamente los valores en MovimientosCuenta")
    void testSetters() {
    	// Simulamos la creación de un objeto con el constructor vacio
        MovimientosCuenta mov = new MovimientosCuenta();

        LocalDateTime fecha = LocalDateTime.of(2026, 1, 31, 10, 30);
        
        //Seteamos los valores por cada setters
        mov.setTipo("GIRO");
        mov.setMonto(5000);
        mov.setSaldoResultante(10000);
        mov.setTipoMoneda(Moneda.USD);
        mov.setFecha(fecha);

        // Verificamos que se hayan guardado los valores seteados
        assertAll(
            () -> assertEquals("GIRO", mov.getTipo()),
            () -> assertEquals(5000, mov.getMonto(), DELTA),
            () -> assertEquals(10000, mov.getSaldoResultante(), DELTA),
            () -> assertEquals(Moneda.USD, mov.getTipoMoneda()),
            () -> assertEquals(fecha, mov.getFecha())
        );
    }

    @Test
    @DisplayName("Fecha debe generarse automáticamente en constructor con parámetros")
    void testFechaAutoGenerada() {

        // Simulamos la creacion de un movimiento  de creacion de cuenta con parámetros
    	MovimientosCuenta mov = new MovimientosCuenta("CREA", 0, 0, Moneda.CLP);
    	
    	// Validamos que el movimiento mov no sea nulo
        assertNotNull(mov.getFecha());
    }

    @Test
    @DisplayName("Getters deben retornar los valores actuales")
    void testGetters() {

    	// Simulamos un abono
        MovimientosCuenta mov = new MovimientosCuenta("ABONO", 2000, 5000, Moneda.CLP);

        // Validamos que el movimiento guardado en el constructor cuente con los valores enviados
        assertEquals("ABONO", mov.getTipo());
        assertEquals(2000, mov.getMonto(), DELTA);
        assertEquals(5000, mov.getSaldoResultante(), DELTA);
        assertEquals(Moneda.CLP, mov.getTipoMoneda());
        assertNotNull(mov.getFecha());
    }

}
