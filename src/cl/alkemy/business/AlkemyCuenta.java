package cl.alkemy.business;

import java.util.ArrayList;

import cl.alkemy.utilitarios.MoneyUtils;
import cl.alkemy.utilitarios.servicios.Moneda;



/**
 * 
 * Clase AlkemyCuenta
 * 
 * <p>
 * Representa una billetera en el sistema Alkemy Wallet.
 * </p>
 * 
 * <p>
 * Gestiona información del titular, saldo actual,
 * tipo de moneda y movimientos asociados a la cuenta.
 * </p>
 * 
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 * 
 * <p>
 * Se agrega metodo de mostrarMovimientos para visualizar los movimientos asociados al cambio de moneda de la cuenta.
 * </p>
 * 
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 * 
 */


public class AlkemyCuenta implements Cuenta {
	
	// Atributos
	
	
	/**
	 * Número único que identifica la cuenta.
	 */
	private int numeroCuenta;
	
	/**
	 * Nombre del titular de la cuenta.
	 */	
	private String nombreTitular;
	
	/**
	 * Saldo actual disponible en la cuenta.
	 */
	private double saldoActual;
	
	/**
	 * Lista de movimientos realizados en la cuenta.
	 */
	private ArrayList<MovimientosCuenta> movimientos = new ArrayList<>();
	
	/**
	 * Tipo de moneda utilizada en la cuenta.
	 */
	private Moneda tipoMoneda;
	
	// Constructors
	
	/**
	 * Constructor por defecto
	 * 
	 * <p> Incializador de la clase AlkemyCuenta sin parámetros.
	 * Por defecto inicializa los atributos con valores predeterminados.
	 * </p>
	 * <p> Valores por defecto: 
	 * <br> numeroCuenta = 0
	 * <br> nombreTitular = ""
	 * <br> saldoActual = -1
	 * <br> tipoMoneda = Moneda.CLP = Peso Chileno
	 * </p>
	 * 
	 */
	public AlkemyCuenta() {
		this.numeroCuenta = 0;
		this.nombreTitular = "";
		this.saldoActual = -1;
		this.tipoMoneda = Moneda.CLP;
	}
	
	/**
	 * Constructor con parámetros
	 * 
	 * <p> Incializador de la clase AlkemyCuenta con parámetros.
	 * </p>
	 * 
	 * @param numeroCuenta  Número único que identifica la cuenta.
	 * @param nombreTitular Nombre del titular de la cuenta.
	 * @param saldoActual   Saldo actual disponible en la cuenta.
	 * @param tipoMoneda    Tipo de moneda utilizada en la cuenta.
	 * 
	 *
	 */
	public AlkemyCuenta(int numeroCuenta, String nombreTitular, double saldoActual, Moneda tipoMoneda) {
		this.numeroCuenta = numeroCuenta;
		this.nombreTitular = nombreTitular;
		this.saldoActual = saldoActual;
		this.tipoMoneda = tipoMoneda;
		this.movimientos.add(new MovimientosCuenta("CREA",saldoActual,0, tipoMoneda));
	
	}
	
	
	
	// Getters and Setters
	
	
	/**
	 * Obtiene el número de cuenta.
	 *  
	 * @return numeroCuenta Número único que identifica la cuenta.
	 */
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	
	/**
	 * Establece el número de cuenta.
	 * 
	 * @param numeroCuenta Nuevo número único que identifica la cuenta.
	 */
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	
	/**
	 * Obtiene el nombre del titular de la cuenta.
	 *  
	 * @return nombreTitular Nombre del titular de la cuenta.
	 */
	public String getNombreTitular() {
		return nombreTitular;
	}
	
	/**
	 * Establece el nombre del titular de la cuenta.
	 * 
	 * @param nombreTitular Nuevo nombre del titular de la cuenta.
	 */
	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}
	
	/**
	 * Obtiene el saldo actual de la cuenta.
	 *  
	 * @return saldoActual Saldo actual disponible en la cuenta.
	 */
	public double getSaldoActual() {
		return saldoActual;
	}
	
	/**
	 * Establece el saldo actual de la cuenta.
	 * 
	 * @param saldoActual Nuevo saldo actual disponible en la cuenta.
	 */
	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}
	
	/**
	 * Obtiene la lista de movimientos de la cuenta.
	 *  
	 * @return movimientos Lista de movimientos realizados en la cuenta.
	 */
	public ArrayList<MovimientosCuenta> getMovimientos() {
		return movimientos;
	}

	/**
	 * Establece la lista de movimientos de la cuenta.
	 * 
	 * @param movimientos Nueva lista de movimientos realizados en la cuenta.
	 */
	public void setMovimientos(ArrayList<MovimientosCuenta> movimientos) {
		this.movimientos = movimientos;
	}

	/**
	 * Obtiene el tipo de moneda de la cuenta.
	 *  
	 * @return tipoMoneda Tipo de moneda utilizada en la cuenta.
	 */
	public Moneda getTipoMoneda() {
		return tipoMoneda;
	}


	/**
	 * Establece el tipo de moneda de la cuenta.
	 * 
	 * @param tipoMoneda Nuevo tipo de moneda utilizada en la cuenta.
	 */
	public void setTipoMoneda(Moneda tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
	
	// Métodos
	
	
	/**
	 * Realiza un depósito en la cuenta.
	 * 
	 * <p> Agrega un movimiento de tipo "ABONO" a la lista de movimientos
	 * y actualiza el saldo actual de la cuenta.
	 * </p>
	 * 
	 * @param montoDeposito Monto a depositar en la cuenta.
	 */
	public void depositar (double montoDeposito) {
		
		if (montoDeposito<=0) {
			System.out.println("\nHubo problemas en su deposito. El monto a despositar debe ser mayor a 0");
		} else {
			this.movimientos.add(new MovimientosCuenta("ABONO",montoDeposito,saldoActual,tipoMoneda));
			this.saldoActual += montoDeposito;
			
			System.out.println("\nDeposito realizado exitosamente");
			System.out.println("\nEstimados " + this.nombreTitular + " se ha realizado un deposito de $ " + montoDeposito + " en su cuenta N° " + this.numeroCuenta + ".\nSu nuesvo saldo es de $" + this.saldoActual);
			
		}

		
	}
	
	/**
	 * Realiza un giro desde la cuenta.
	 * 
	 * <p> Agrega un movimiento de tipo "GIRO" a la lista de movimientos
	 * y actualiza el saldo actual de la cuenta.
	 * </p>
	 * 
	 * @param montoGiro Monto a girar desde la cuenta.
	 */
	public void giro (double montoGiro) {
		
		// para girar debe haber saldo suficiente y el monto debe ser mayor a 0
		if (montoGiro <= 0) {
			System.out.println("\nHubo problemas en su giro. El monto a girar debe ser mayor a 0");
		} else if(montoGiro > this.saldoActual) {
			System.out.println("\nHubo problemas en su giro. El saldo es insuficiente para realizar el giro, su saldo actual es de $ " + this.saldoActual);
		} else {	
			this.movimientos.add(new MovimientosCuenta("GIRO",MoneyUtils.normalizar(montoGiro, tipoMoneda),saldoActual,tipoMoneda));//Genera un nuevo movimiento de tipo GIRO
			this.saldoActual -= montoGiro; 
			System.out.println("\nGiro realizado exitosamente");
			System.out.println("\nEstimados " + this.nombreTitular + " de moneda " + this.tipoMoneda + " se ha realizado un giro de $ " + MoneyUtils.formatear(montoGiro, tipoMoneda) + " en su cuenta N° " + this.numeroCuenta + ".\nSu nuesvo saldo es de $" + MoneyUtils.formatear(this.saldoActual,tipoMoneda) + this.getTipoMoneda() + " " + this.tipoMoneda);
			
		}
		
	}
	
	
	/**
	 * Agrega un movimiento de cambio de moneda a la lista de movimientos
	 * y actualiza el tipo de moneda de la cuenta.
	 * 
	 * @param nuevaMoneda Nuevo tipo de moneda para la cuenta.
	 */
	public void cambiarMonedaMovimiento(Moneda nuevaMoneda) {
		this.tipoMoneda = nuevaMoneda;
		System.out.println("\nEl tipo de moneda de la cuenta ha sido cambiado a: " + this.tipoMoneda);
		this.movimientos.add(new MovimientosCuenta("CAMBIO MONEDA",	0,saldoActual,tipoMoneda));
	}
	
	/**
	 * Imprime los detalles de la cuenta por consola.
	 * 
	 * 
	 */
	public void imprimir () {
		System.out.println("\nImpresión Cliente");
		System.out.println("Número Cuenta  : " + this.numeroCuenta);
		System.out.println("Nombre Titular : " + this.nombreTitular);
		if (this.tipoMoneda== Moneda.CLP) {
			System.out.println("Saldo Cuenta   : $" + MoneyUtils.formatear(this.saldoActual, Moneda.CLP));
		} else if (this.tipoMoneda== Moneda.USD) {
			System.out.println("Saldo Cuenta   : $" + MoneyUtils.formatear(this.saldoActual, Moneda.USD));
		} else if (this.tipoMoneda== Moneda.EURO) {
			System.out.println("Saldo Cuenta   : $" + MoneyUtils.formatear(this.saldoActual, Moneda.EURO));
		}
		
		System.out.println("Moneda         : " + this.getTipoMoneda());
		
	}
	
	/**
	 * Muestra el historial de movimientos de la cuenta por consola.
	 * 
	 */
	public void mostrarMovimientos() {
		System.out.println("\n--- HISTORIAL DE MOVIMIENTOS ---");
		
		//recorre la lista de movimientos e imprime cada uno
	    for (MovimientosCuenta m : this.movimientos) {
	        System.out.println(
	            "FECHA MOVIMIENTO :" + m.getFecha() + " | " +
	            "TIPO MOVIMIENTO :" + m.getTipo() + " | " +
	            "MONTO MOVIMIENTO :" + MoneyUtils.formatear(m.getMonto(), m.getTipoMoneda()) + " | " +
	            "TIPO MONEDA CUENTA :" + m.getTipoMoneda() + " | " +
	            "SALDO PREVIO MOVIMIENTO :" + m.getSaldoResultante() 
	        );
	    }
	}
	
}
