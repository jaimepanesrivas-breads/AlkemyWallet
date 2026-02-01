package cl.alkemy.utilitarios.servicios.validaciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidaFactoryTest {

	@Test
    @DisplayName("Debe retornar ValidadorStringImpl para STRING")
    void testFactoryString() {

        ValidadorDatos validador =
                ValidaFactory.obtenerValidador(TiposDeValidacion.STRING);

        assertNotNull(validador);
        assertTrue(validador instanceof ValidadorStringImpl);
    }

    @Test
    @DisplayName("Debe retornar ValidadorNumeroImpl para NUMERICO")
    void testFactoryNumerico() {

        ValidadorDatos validador =
                ValidaFactory.obtenerValidador(TiposDeValidacion.NUMERICO);

        assertNotNull(validador);
        assertTrue(validador instanceof ValidadorNumeroImpl);
    }

    @Test
    @DisplayName("Debe lanzar excepción si tipo es null")
    void testFactoryNull() {

        assertThrows(
                NullPointerException.class,
                () -> ValidaFactory.obtenerValidador(null)
        );
    }
    
    @Test
    void validadorNumericoDebeFuncionar() {

        ValidadorDatos v =
                ValidaFactory.obtenerValidador(TiposDeValidacion.NUMERICO);

        assertTrue(v.validar("123"));
        assertTrue(v.validar("12,5"));
        assertFalse(v.validar("abc"));
    }
}
