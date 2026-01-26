package cl.alkemy.utilitarios;

import java.util.Scanner;


/**
 * 
 * Clase Menu
 * -----------
 * 
 * Clase encargada de mostrar el menú principal del sistema
 * y gestionar interacciones básicas con el usuario por consola.
 * 
 * <p>
 * Centraliza la presentación de opciones y utilidades
 * relacionadas con la navegación del programa.
 * </p>
 * 
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 */

public class Menu {
	
	
	/**
	 * Atributos
	 */

	private int opcion; // indica atributo de opcion del menu.

	
	
	/**
	 * Constructor
	 * @return
	 */
	
	/**
	 * Constructors
	 * ------------ 
	 * 
	 * Inicializa el objeto con los parámetros
	 * 
	 *  @param opcion  atributo que permite o no el despliegue del menú. 
	 *  
	 * Inicializador parametros por defecto, no se despliega el menú.
	 * 
	 * 
	 * @version 1.0
	 *
	 */
	// constructos datos por defecto
	public Menu() {
		this.opcion = -1; // por defecto no despliega menú
	}
	
	// Constructor datos parámetros
	public Menu(int opcion) {
		this.opcion = opcion;
	}

	/**
	 * getter and setter
	 * -----------------
	 * @return
	 */
	
	/**
     * Obtiene la opcion del despliegue del menú
     * 
     * @return opcipn valor de si se despliega o no el menú.
     */
	public int getOpcion() {
		return opcion;
	}

	/**
     * Establece el valor de atributo opcion para el despliegue del menú.
     * 
     * @param opcion
     */
	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}
	
	
	/**
	 * metodos custom
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
	
	public void esperarEnter(Scanner scanner) {
        System.out.println("\nPresione ENTER para continuar...");
        scanner.nextLine();
    }
	
}
