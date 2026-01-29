package cl.alkemy.utilitarios;

import java.util.Scanner;


/**
 * 
 * Clase Menu
 * 
 * <p>
 * Encargada de mostrar el menú principal del sistema
 * y gestionar interacciones básicas con el usuario por consola.
 * </p>
 * 
 * <p>
 * Centraliza la presentación de opciones y utilidades
 * relacionadas con la navegación del programa.
 * </p>
 * 
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 */

public class Menu {
	
	
	// Atributos
	
	/**
	 *  Indica  la opcion seleccionada o el estado del menú.
	 */
	private int opcion;

	
	// Constructors
	
	
	/**
	 * Constructor por defecto
	 * 
	 * <p> Incializador de la clase Menu sin parámetros.
	 * Por defecto no se despliega el menú.
	 * </p>
	 * 

	 * @since 2026-01
	 */
	
	public Menu() {
		this.opcion = -1; // por defecto no despliega menú
	}
	
	
	/**
	 * Constructor con parámetros
	 * 
	 * <p> Incializador de la clase Menu con parámetros.
	 * </p>
	 * 
	 * @param opcion valor inicial de la opción del menú.
	 * 
	 *
	 */

	public Menu(int opcion) {
		this.opcion = opcion;
	}

	
	// Getters and Setters
	
	
	
	/**
     * Obtiene la opción actual del menú
     *  
     * @return opcipn valor de si se despliega o no el menú.
     */
	public int getOpcion() {
		return opcion;
	}

	/**
     * Establece opción del menú.
     * 
     * @param opcion nuevo valor de la opción del menú.
     */
	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}
	
	
	// Métodos
	
	/**
     * Muestra el menú principal por consola.
     */
	
	public void mostrarMenu () {
		
		System.out.println("\n =============== Bienvenido a Banco XXXXXXXXXXXXXXXXXXXXXXXX ===============");
		System.out.println("\n");
		System.out.println("MENU");
		System.out.println("\n");
		
		if (this.opcion != 1) {
			
			// depliega menu
			System.out.println("1. Crear Cuenta");
			System.out.println("2. Consultar Saldo");
			System.out.println("3. Abonar");
			System.out.println("4. Transferir");
			System.out.println("5. Convertir Moneda");
			System.out.println("6. Ver Movimiento");
			System.out.println("0. Salir");
			System.out.print("\nSeleccione la Opcion : ");
		} else {
			// 
		}
	}
	
	
	/**
     * Pausa la ejecución hasta que el usuario presione ENTER.
     */
	public void esperarEnter(Scanner scanner) {
        System.out.println("\nPresione ENTER para continuar...");
        scanner.nextLine();
    }
	
}
