package cl.alkemy.utilitarios;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.alkemy.business.MovimientosCuentaTest;


/**
 * Tests unitarios para la clase {@link MenuTest}.
 *
 * Se validan los distintos escenarios de depósito y giro,
 * así como la correcta inicialización y manejo de movimientos.
 *
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 */

public class MenuTest {

	 private final PrintStream originalOut = System.out;
	    private ByteArrayOutputStream outputStream;

	    @BeforeEach
	    void setUp() {
	        outputStream = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream));
	    }

	    @AfterEach
	    void tearDown() {
	        System.setOut(originalOut);
	    }

	    // =========================
	    // Constructores
	    // =========================

	    @Test
	    @DisplayName("Constructor vacío debe inicializar opcion en 0")
	    void testConstructorVacio() {
	        Menu menu = new Menu();
	        assertEquals(0, menu.getOpcion());
	    }

	    @Test
	    @DisplayName("Constructor con parámetro debe inicializar opcion")
	    void testConstructorConParametro() {
	        Menu menu = new Menu(5);
	        assertEquals(5, menu.getOpcion());
	    }

	    // =========================
	    // Getters / Setters
	    // =========================

	    @Test
	    @DisplayName("Setter y Getter deben funcionar correctamente")
	    void testGetterSetter() {
	        Menu menu = new Menu();
	        menu.setOpcion(3);

	        assertEquals(3, menu.getOpcion());
	    }

	    // =========================
	    // mostrarMenu()
	    // =========================

	    @Test
	    @DisplayName("mostrarMenu debe imprimir opciones cuando opcion != -1")
	    void testMostrarMenu() {

	        Menu menu = new Menu(0);

	        menu.mostrarMenu();

	        String salida = outputStream.toString();

	        assertAll(
	            () -> assertTrue(salida.contains("MENU WALLET")),
	            () -> assertTrue(salida.contains("1. Crear Cuenta")),
	            () -> assertTrue(salida.contains("6. Ver Movimiento")),
	            () -> assertTrue(salida.contains("0. Salir"))
	        );
	    }

	    // =========================
	    // limpiarConsola()
	    // =========================

	    @Test
	    @DisplayName("limpiarConsola debe imprimir múltiples líneas")
	    void testLimpiarConsola() {

	        Menu menu = new Menu();

	        menu.limpiarConsola();

	        String salida = outputStream.toString();

	        long lineas = salida.lines().count();

	        assertTrue(lineas >= 40);
	    }

	    // =========================
	    // esperarEnter()
	    // =========================

	    @Test
	    @DisplayName("esperarEnter debe continuar al presionar ENTER")
	    void testEsperarEnter() {

	        String input = "\n";
	        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
	        Scanner scanner = new Scanner(in);

	        Menu menu = new Menu();

	        menu.esperarEnter(scanner);

	        String salida = outputStream.toString();

	        assertTrue(salida.contains("Presione ENTER"));
	    }
	
}
