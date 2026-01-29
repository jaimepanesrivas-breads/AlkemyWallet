import java.util.Scanner;

import cl.alkemy.business.AlkemyCuenta;
import cl.alkemy.business.Cuenta;
import cl.alkemy.utilitarios.Menu;
import cl.alkemy.utilitarios.NumeroCuentaRandom;
import cl.alkemy.utilitarios.servicios.ConversorMoneda;
import cl.alkemy.utilitarios.servicios.ConversorMonedaImpl;
import cl.alkemy.utilitarios.servicios.Moneda;


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
 * Modificamos para que se pueda usar AlkemyCuenta como superclase y Cuenta como Interfaz.
 * Aidiconalmente se castea a AlkemyCuenta para usar setters 
 * </p>
 * 
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
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
		int opcion=-1;
		
		/**
		 * Objeto AlkemyCuenta que representa la cuenta del usuario.
		 */
		//AlkemyCuenta cuenta = null; //Cambiar a interfaz Cuenta
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
		
		
		while (opcion != 0) {
			
			menu.mostrarMenu();
			opcion = leer.nextInt();
			
			switch (opcion) {
			
				case 0: {
					System.out.println("\nSaliendo del sistema.....");
					break;
	
				}
				
				case 1:{
					
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
						
						//System.out.print("\nTeléfono de contacto                : ");
						//telefonoContacto = leer.nextline();
						
						//System.out.print("\nCorreo de contacto                  : ");
						//correoContacto = leer.nextline();
						
						System.out.print("\nIngrese Saldo cuenta                  : ");
						saldoActual = leer.nextDouble();
						
						System.out.print("\nIngrese Tipo de Moneda de la Cuenta  (use CLP para peso Chileno y USD para Dolar Americano) : ");
						tipoMoneda = leer.next();
						
						if (tipoMoneda.equalsIgnoreCase(Moneda.CLP.name()) || tipoMoneda.equalsIgnoreCase(Moneda.USD.name())) {
							
							if (tipoMoneda.equalsIgnoreCase(Moneda.CLP.name())) {
								//Creacion de la cuenta
								cuenta = new AlkemyCuenta(numeroCuenta, nombreTitular, saldoActual, Moneda.CLP);
							} else {
								//Creacion de la cuenta
								cuenta = new AlkemyCuenta(numeroCuenta, nombreTitular, saldoActual, Moneda.USD);
								
								
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
						break;
					} else {
						System.out.print("\nEstimado " + cuenta.getNombreTitular() + " Ud. ya tiene la cuenta N° " + cuenta.getNumeroCuenta() + " activa. No puede crear otra.");
						leer.nextLine(); //Limpiar buffer de lectura
						menu.esperarEnter(leer);
						continue;
					}
					
				}
				
				case 2:{
					if (cuenta != null) {
						System.out.println("\nEl saldo en su cuenta N° " + cuenta.getNumeroCuenta() + " es de $" + cuenta.getSaldoActual() + " " + cuenta.getTipoMoneda());
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
				
				case 3:{
					if (cuenta != null) {
						System.out.print("\nIngrese el mondo a abonar : $");
						montoAbono = leer.nextDouble();
						cuenta.depositar(montoAbono);
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
				
				case 4:{
					if (cuenta != null) {
						System.out.print("\nIngrese el mondo a girar : $");
						montoGiro = leer.nextDouble();
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
				
				case 5:{
					if (cuenta != null) {
						System.out.println("hacer conversion de moneda");
						System.out.println("\nSu Cuenta N° " + cuenta.getNumeroCuenta() + " esta en " + cuenta.getTipoMoneda());
						
						if(cuenta.getTipoMoneda() == Moneda.CLP) {
							
							System.out.println("¿Quiere modificar si cuenta a USD? (Si/No)");
							String cambioMoneda = leer.next();
							if (cambioMoneda.equalsIgnoreCase("SI")) {
								
								ConversorMoneda conversor = new ConversorMonedaImpl();
								double nuevoSaldo = conversor.convertir(cuenta.getSaldoActual(), Moneda.CLP, Moneda.USD);
								System.out.println(nuevoSaldo);
								((AlkemyCuenta) cuenta).setSaldoActual(nuevoSaldo);// casteamos a AlkemyCuenta para usar el metodo setSaldoActual
								((AlkemyCuenta) cuenta).setTipoMoneda(Moneda.USD);// casteamos a AlkemyCuenta para usar el metodo setSaldoActual
								
								leer.nextLine(); //Limpiar buffer de lectura
								menu.esperarEnter(leer);
								
							}
						} else {
							System.out.println("¿Quiere modificar si cuenta a CLP?");
							String cambioMoneda = leer.next();
							if (cambioMoneda.equalsIgnoreCase("SI")) {
								
								ConversorMoneda conversor = new ConversorMonedaImpl();
								double nuevoSaldo = conversor.convertir(cuenta.getSaldoActual(), Moneda.USD, Moneda.CLP);
								System.out.println(nuevoSaldo);
								((AlkemyCuenta) cuenta).setSaldoActual(nuevoSaldo);// casteamos a AlkemyCuenta para usar el metodo setSaldoActual
								((AlkemyCuenta) cuenta).setTipoMoneda(Moneda.CLP); // casteamos a AlkemyCuenta para usar el metodo setTipoMoneda
								
								leer.nextLine(); //Limpiar buffer de lectura
								menu.esperarEnter(leer);
							}
						}						
						break;
					} else {
						System.out.print("\n No existe cuenta para hacer cambio de moneda.");
						leer.nextLine(); //Limpiar buffer de lectura
						menu.esperarEnter(leer);
						continue;
					}
				}
				
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
			
			}			
			
		}
			
		System.out.println("\nFIN");
		
		leer.close();
		
	}

}
