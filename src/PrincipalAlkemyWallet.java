import java.util.Scanner;

import cl.alkemy.business.AlkemyCuenta;
import cl.alkemy.business.Cuenta;
import cl.alkemy.utilitarios.Menu;
import cl.alkemy.utilitarios.MoneyUtils;
import cl.alkemy.utilitarios.NumeroCuentaRandom;
import cl.alkemy.utilitarios.servicios.ConversorMoneda;
import cl.alkemy.utilitarios.servicios.ConversorMonedaImpl;
import cl.alkemy.utilitarios.servicios.Moneda;
import cl.alkemy.utilitarios.servicios.validaciones.*;

/**
 * 
 * Clase PrincipalAlkemyWallet
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
 * 
 * <p>
 * Modificamos para que se pueda usar AlkemyCuenta como superclase y cuenta como Interfaz.
 * Aidiconalmente se castea a AlkemyCuenta para usar setters 
 * </p>
 * 
 * @author Jaime Francisco Panes Rivas
 * @version 1.1
 * @since 2026-01
 * 
 * <p>
 * Modificamos para poder validar que los cammpos de ingreso de datos cumplan con su utilidad.
 *  - ejemplo campo saldo debe ser número.
 *  - ejemplo campo Nombre Titular debe no ser vacio.  
 * </p>
 * 
 * @author Jaime Francisco Panes Rivas
 * @version 1.2
 * @since 2026-01
 * 
 * 
 */


public class PrincipalAlkemyWallet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Declaracion de variables y constantes
		
		//Constantes para generar numero de cuenta random
		int MAX = 1000000;
		int MIN = 1;
		
		// Variables
		
		/**
		 * Objeto Scanner para lectura de datos por consola.
		 */
		Scanner leer = new Scanner(System.in);
		
		/**
		 * Opción seleccionada en el menú.
		 */
		int opcion;;
		
		/**
		 * Objeto AlkemyCuenta que representa la cuenta del usuario.
		 */
		//AlkemyCuenta cuenta = null; 
		Cuenta cuenta = null;
		
		/** 
		 * Variables para capturar datos de la cuenta.
		 */
		int numeroCuenta;
		
		/**
		 * Nombre del titular de la cuenta.
		 */
		String nombreTitular;
		
		/** 
		 * Saldo actual de la cuenta.
		 */
		double saldoActual;
		
		/**
		 * Monto a abonar en la cuenta.
		 */
		double montoAbono;
		
		/**
		 * Monto a girar de la cuenta.
		 */
		double montoGiro;
		
		/**
		 * Tipo de moneda de la cuenta.
		 */
		String tipoMoneda;
		
		
		System.out.println("BIEN VENIDO AL ALKEMY WALLET");
		System.out.println("");
		
		Menu menu = new Menu(2);//Constructor con valor 2		
		opcion = menu.getOpcion();
		
		
		
		// Bucle principal del menú
		while (opcion != 0) {
			
			// Mostrar el menú
			menu.mostrarMenu();
			
			while (!leer.hasNextInt()) {
				// descarta la entrada inválida
			    leer.nextLine(); 
			    // Mostrar el menú
				menu.limpiarConsola();
				System.out.println("Opción inválida. Ingrese un número del 0 al 6.");
			    menu.mostrarMenu();
			}
			opcion = leer.nextInt();
			
			
			
			// Procesar la opción seleccionada
			switch (opcion) {
				// Salir
				case 0: {
					System.out.println("\nSaliendo del sistema.....");
					break;
	
				}
				// Crear Cuenta
				// el número de cuenta se genera automáticamente, los demas datos se piden al usuario
				case 1:{
					// Verificar si ya existe una cuenta
					if (cuenta == null) {
						System.out.print("\nFavor ingresar los datos que se solicitarán para crear la cuenta");
						System.out.println();
						
						// generar automatixamente un numero random para numero de cuenta conrriente.
						NumeroCuentaRandom randomCuenta = new NumeroCuentaRandom(MAX,MIN);
						numeroCuenta = randomCuenta.getNumeroRandom();
						
						
						System.out.print("\nNúmero de Cuenta                      : " + randomCuenta.getNumeroRandom());
						leer.nextLine(); //Limpiar buffer de lectura
						
						System.out.print("\nIngrese Nombre Titular                : ");
						nombreTitular = leer.nextLine();
						
						// Validar nombre titular no este vacio ni nulo
						ValidadorDatos validaNombre = ValidaFactory.obtenerValidador(TiposDeValidacion.STRING);
						
						while (!validaNombre.validar(nombreTitular)) {
							System.out.print("\nNombre inválido. Ingrese Nombre Titular                : ");
							nombreTitular = leer.nextLine();
						}
						
						
						//System.out.print("\nTeléfono de contacto                : ");
						//telefonoContacto = leer.nextline();
						
						//System.out.print("\nCorreo de contacto                  : ");
						//correoContacto = leer.nextline();
						
						System.out.print("\nIngrese Saldo cuenta                  : ");
						String saldoInput = leer.next();
						
						// Validar saldo sea un numero
						ValidadorDatos validador = ValidaFactory.obtenerValidador(TiposDeValidacion.NUMERICO);
						saldoInput = saldoInput.trim();
						if (validador.validar(saldoInput)) {
								saldoActual = Double.parseDouble(saldoInput.replace(",", "."));
							} else {
								saldoActual = -1; // Asignar un valor inválido para entrar al bucle de validación
							}
																
						// Validar saldo sea un numero positivo
						
						ValidadorDatos validaSaldo = ValidaFactory.obtenerValidador(TiposDeValidacion.NUMERICO);
						//ValidadorDatos validaSaldo = new ValidaFactory().obtenerValidador(TiposDeValidacion.NUMERICO);
						while (!validaSaldo.validar(String.valueOf(saldoActual)) || saldoActual < 0) {
							System.out.print("\nMonto ingresado para el campo Saldo es inválido.");
							System.out.print(" Saldo cuenta                  : ");
							saldoActual = leer.nextDouble();
						}				
						
						System.out.print("\nIngrese Tipo de Moneda de la Cuenta  (use 'CLP' para peso Chileno, 'USD' para Dolar Americano y 'EURO' para moneda Europea) : ");
						tipoMoneda = leer.next().toUpperCase();
						// Validar tipo de moneda
						if (tipoMoneda.equalsIgnoreCase(Moneda.CLP.name()) || tipoMoneda.equalsIgnoreCase(Moneda.EURO.name()) || tipoMoneda.equalsIgnoreCase(Moneda.USD.name())) {
							// Crear la cuenta según el tipo de moneda
							if (tipoMoneda.equalsIgnoreCase(Moneda.CLP.name())) {
								//Creacion de la cuenta
								saldoActual = MoneyUtils.normalizar(saldoActual, Moneda.CLP);
								cuenta = new AlkemyCuenta(numeroCuenta, nombreTitular, saldoActual, Moneda.CLP);
							} else  if (tipoMoneda.equalsIgnoreCase(Moneda.USD.name())) {
								//Creacion de la cuenta
								saldoActual = MoneyUtils.normalizar(saldoActual, Moneda.USD);
								cuenta = new AlkemyCuenta(numeroCuenta, nombreTitular, saldoActual, Moneda.USD);								
								
							} else {
								//Creacion de la cuenta
								saldoActual = MoneyUtils.normalizar(saldoActual, Moneda.EURO);
								cuenta = new AlkemyCuenta(numeroCuenta, nombreTitular, saldoActual, Moneda.EURO);
							}
							
						} else {
							System.out.println("Tipo de moneda no reconocida.");
							leer.nextLine(); //Limpiar buffer de lectura
							menu.esperarEnter(leer);
							continue;
						}						
											
						cuenta.imprimir();
						leer.nextLine(); //Limpiar buffer de lectura
						menu.esperarEnter(leer);
						break; // Salir del case 1
					} else {
						System.out.print("\nEstimado " + cuenta.getNombreTitular() + " Ud. ya tiene la cuenta N° " + cuenta.getNumeroCuenta() + " activa. No puede crear otra.");
						leer.nextLine(); //Limpiar buffer de lectura
						menu.esperarEnter(leer);
						continue; // Volver al menú principal
					}
					
				}
				// Consultar Saldo
				case 2:{
					if (cuenta != null) {// Verificar si la cuenta existe
						System.out.println("\nEl saldo en su cuenta N° " + cuenta.getNumeroCuenta() + " es de $" + MoneyUtils.formatear(cuenta.getSaldoActual(), cuenta.getTipoMoneda())    + " " + cuenta.getTipoMoneda());
						leer.nextLine(); //Limpiar buffer de lectura
						menu.esperarEnter(leer);
						break;
					} else {
						System.out.println("\nNo es posible consultar saldo de una cuenta que no existe. Por favor crear ante su cuenta");
						leer.nextLine(); //Limpiar buffer de lectura
						menu.esperarEnter(leer);
						continue;
					}
					
				}
				// Abonar
				case 3:{
					// Varificar si la cuenta existe
					if (cuenta != null) {
						
						ValidadorDatos validador = ValidaFactory.obtenerValidador(TiposDeValidacion.NUMERICO);
						
						montoAbono = -1; // Inicializar con valor inválido
						
						// Validar montoAbono sea un número positivo, mientras no sea así se repite el ingreso.
						do {
							
							System.out.print("\nIngrese el mondo a abonar : $");
							String montoAbonoInput = leer.next();
						
							// Validar montoAbonoInput sea un numero positivo
							
							if (validador.validar(montoAbonoInput)) {
								montoAbono = Double.parseDouble(montoAbonoInput.replace(",", "."));
								cuenta.depositar(montoAbono);
							} else {
								System.out.print("\nMonto ingresado para el campo Abono es inválido.");
							}
						
						} while (!validador.validar(String.valueOf(montoAbono)) || montoAbono < 0);
																		
						
						leer.nextLine(); //Limpiar buffer de lectura
						menu.esperarEnter(leer);
						break;
						
					} else {
						System.out.println("\nNo es posible realizar un abono/deposito a una cuenta que no existe. Por favor crear ante su cuenta");
						leer.nextLine(); //Limpiar buffer de lectura
						menu.esperarEnter(leer);
						continue;
						
					}
					
				}
				
				// Girar
				case 4:{
					// Verificar si la cuenta existe
					if (cuenta != null) {
						
						ValidadorDatos validador = ValidaFactory.obtenerValidador(TiposDeValidacion.NUMERICO);
						
						montoGiro = -1; // Inicializar con valor inválido
						
						do {
							System.out.print("\nIngrese el mondo a girar : $");
							String montoGiroInput = leer.next();
							
							// Validar montoGiroInput sea un numero positivo
							if (validador.validar(montoGiroInput)) {
								montoGiro = Double.parseDouble(montoGiroInput.replace(",", "."));
							} else {
								System.out.print("\nMonto ingresado para el campo Giro es inválido.");
							}
							
						} while (!validador.validar(String.valueOf(montoGiro)) || montoGiro < 0);
						
						
						// Agrega movimiento de giro y actualiza saldo
						cuenta.giro(montoGiro);
						leer.nextLine(); //Limpiar buffer de lectura
						menu.esperarEnter(leer);
						break;
						
					} else {
						System.out.println("\nNo es posible realizar un giro de una cuenta que no existe. Por favor crear ante su cuenta");
						leer.nextLine(); //Limpiar buffer de lectura
						menu.esperarEnter(leer);
						continue;
						
					}
					
				}
				
				
				// Convertir Moneda
				case 5:{
					if (cuenta != null) {
						System.out.println("Recuerde que sólo es posible convertir entre CLP y USD o entre CLP y EURO, y viceversa.");
						System.out.println("\nSu Cuenta N° " + cuenta.getNumeroCuenta() + " esta en " + cuenta.getTipoMoneda());
						
						//Listar monedas disponibles
						System.out.println("\nSeleccione Monedas disponibles para conversión:");
						for (Moneda moneda : Moneda.values()) {
							if (moneda != cuenta.getTipoMoneda())
								System.out.println("- " + moneda);
						}
						
						leer.nextLine(); //Limpiar buffer de lectura
						System.out.print("\n Por favor ingrese la moneda a la que desea convertir su cuenta: ");
						String monedaNueva = leer.nextLine();
						
						// Validar moneda ingresada
						// recorrer el enum Moneda para verificar si existe
					
						try {
						    Moneda moneda = Moneda.valueOf(monedaNueva.trim().toUpperCase());

						    System.out.println("\nMoneda seleccionada para conversión es: " + moneda);
						    System.out.print("\n¿Quiere modificar si cuenta de " + cuenta.getTipoMoneda() + " a " + monedaNueva  +" ? (Si/No)");
							String cambioMoneda = leer.next().toUpperCase();
							
							// Verificar si el usuario quiere hacer el cambio
							if (cambioMoneda.equalsIgnoreCase("SI")) {
								
								// Realizar conversión
								ConversorMoneda conversor = new ConversorMonedaImpl();
								double nuevoSaldo = conversor.convertir(cuenta.getSaldoActual(), cuenta.getTipoMoneda(), moneda);	
								((AlkemyCuenta) cuenta).setSaldoActual(nuevoSaldo);// casteamos a AlkemyCuenta para usar el metodo setSaldoActual
								((AlkemyCuenta) cuenta).setTipoMoneda(moneda);// casteamos a AlkemyCuenta para usar el metodo setTipoMoneda
								System.out.println("\nSu nuevo saldo es: $" + MoneyUtils.formatear(cuenta.getSaldoActual(),cuenta.getTipoMoneda()) + " y su moneda es: " + cuenta.getTipoMoneda());
								leer.nextLine(); //Limpiar buffer de lectura
								menu.esperarEnter(leer);
								
								// Agregar movimiento de cambio de moneda
								cuenta.cambiarMonedaMovimiento(moneda);
								break;
							}

						} catch (IllegalArgumentException e) {
						    System.out.println("\nMoneda a convertir no es soportada por el sistema.");
						    break;
						}
					
					} else {
						System.out.print("\n No existe cuenta para hacer cambio de moneda.");
						leer.nextLine(); //Limpiar buffer de lectura
						menu.esperarEnter(leer);
						continue;
					}
				}
				
				// Ver Movimientos
				case 6:{
					if (cuenta != null) {
						System.out.print("\nA continuación se listan los movimiento de su cuenta N° " + cuenta.getNumeroCuenta());
						cuenta.mostrarMovimientos();
						
						leer.nextLine(); //Limpiar buffer de lectura
						menu.esperarEnter(leer);
						break;
						
					} else {
						System.out.println("\nNo es posible realizar un giro de una cuenta que no existe. Por favor crear ante su cuenta");
						leer.nextLine(); //Limpiar buffer de lectura
						menu.esperarEnter(leer);
						continue;
						
					}					
					
				}
				// Opción no válida
				default:{
					System.out.println("\nOpción no válida. Por favor seleccione una opción del menú.");
					leer.nextLine(); //Limpiar buffer de lectura
					menu.esperarEnter(leer);
					break;
				}
			
			}			
			
		}
			
		System.out.println("\nFIN");
		
		leer.close();
		
	}

}
