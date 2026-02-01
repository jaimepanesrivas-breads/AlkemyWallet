package cl.alkemy.business;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.alkemy.utilitarios.servicios.Moneda;

public class MovimientosCuentaTest {

	private static final double DELTA = 0.0001;

    @Test
    @DisplayName("Constructor vacío debe inicializar valores por defecto")
    void testConstructorVacio() {

        MovimientosCuenta mov = new MovimientosCuenta();

        assertAll(
            () -> assertEquals("", mov.getTipo()),
            () -> assertEquals(0, mov.getMonto(), DELTA),
            () -> assertEquals(0, mov.getSaldoResultante(), DELTA),
            () -> assertNull(mov.getTipoMoneda()),
            () -> assertNull(mov.getFecha())
        );
    }

    @Test
    @DisplayName("Constructor con parámetros debe inicializar correctamente")
    void testConstructorConParametros() {

        LocalDateTime antes = LocalDateTime.now();

        MovimientosCuenta mov =
                new MovimientosCuenta("ABONO", 10000, 15000, Moneda.CLP);

        LocalDateTime despues = LocalDateTime.now();

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
    @DisplayName("Setters deben modificar correctamente los valores")
    void testSetters() {

        MovimientosCuenta mov = new MovimientosCuenta();

        LocalDateTime fecha = LocalDateTime.of(2026, 1, 31, 10, 30);

        mov.setTipo("GIRO");
        mov.setMonto(5000);
        mov.setSaldoResultante(10000);
        mov.setTipoMoneda(Moneda.USD);
        mov.setFecha(fecha);

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

        MovimientosCuenta mov =
                new MovimientosCuenta("CREA", 0, 0, Moneda.CLP);

        assertNotNull(mov.getFecha());
    }

    @Test
    @DisplayName("Getters deben retornar los valores actuales")
    void testGetters() {

        MovimientosCuenta mov =
                new MovimientosCuenta("ABONO", 2000, 5000, Moneda.CLP);

        assertEquals("ABONO", mov.getTipo());
        assertEquals(2000, mov.getMonto(), DELTA);
        assertEquals(5000, mov.getSaldoResultante(), DELTA);
        assertEquals(Moneda.CLP, mov.getTipoMoneda());
        assertNotNull(mov.getFecha());
    }

}
