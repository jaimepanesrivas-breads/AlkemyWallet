package cl.alkemy.utilitarios.servicios.validaciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidadorNumeroImplTest {

	private final ValidadorDatos validador = new ValidadorNumeroImpl();

	    @Test
	    @DisplayName("Debe retornar false si dato es null")
	    void testNull() {
	        assertFalse(validador.validar(null));
	    }

	    @Test
	    @DisplayName("Debe validar número entero")
	    void testEntero() {
	        assertTrue(validador.validar("123"));
	    }

	    @Test
	    @DisplayName("Debe validar decimal con punto")
	    void testDecimalPunto() {
	        assertTrue(validador.validar("123.45"));
	    }

	    @Test
	    @DisplayName("Debe validar decimal con coma")
	    void testDecimalComa() {
	        assertTrue(validador.validar("123,45"));
	    }

	    @Test
	    @DisplayName("Debe validar con espacios")
	    void testConEspacios() {
	        assertTrue(validador.validar("   500   "));
	    }

	    @Test
	    @DisplayName("Debe retornar false para texto inválido")
	    void testTextoInvalido() {
	        assertFalse(validador.validar("abc"));
	    }

	    @Test
	    @DisplayName("Debe retornar false para mezcla inválida")
	    void testFormatoInvalido() {
	        assertFalse(validador.validar("12a34"));
	    }
	
}
