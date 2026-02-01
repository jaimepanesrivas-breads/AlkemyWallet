package cl.alkemy.utilitarios.servicios.validaciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidadorStringImplTest {

	private final ValidadorDatos validador = new ValidadorStringImpl();

    @Test
    @DisplayName("Null debe ser inválido")
    void testNull() {
        assertFalse(validador.validar(null));
    }

    @Test
    @DisplayName("String vacío debe ser inválido")
    void testVacio() {
        assertFalse(validador.validar(""));
    }

    @Test
    @DisplayName("Solo espacios debe ser inválido")
    void testEspacios() {
        assertFalse(validador.validar("   "));
    }

    @Test
    @DisplayName("Texto válido debe ser true")
    void testTextoValido() {
        assertTrue(validador.validar("Jaime"));
    }
}
