package cl.alkemy.business;

import java.time.LocalDateTime;

import cl.alkemy.utilitarios.servicios.Moneda;

/*
 * Clase MovimientosCuenta
 * -----------------------
 * 
 * Representa los movimientos que pueden haber en una cuenta creada.
 * Los moviminetos pueden ser :
 * Crear Cuenta ==> CREA
 * Abonar a la Cuenta ==> ABONO
 * Girar desde la cuenta ==> GIRO
 * 
 * Esta clase se utiliza para mantener un historial de los movimientos de la cuenta.
 * 
 * Cada movimiento registra:
 * - La fecha de movimiento aaaa-mm-dd y horario
 * - Tipo de mobimiento (CREA-ABONO-GIRO)
 * - Monto involucrado
 * - Moneda de la cuenta
 * - Saldo antes del movimiento en la cuenta
 * 
 * @autor Jaime Francisco Panes Rivas.
 * @version 1.0
 * 
 * Se agrega constructor vacio
 * @autor Jaime Francisco Panes Rivas.
 * @version 1.1
 * 
 */
public class MovimientosCuenta {

	
	/**
	 * Atributos de la clase MovimientosCuenta
	 */
	
	private String tipo;            // tipo de movimiento CREA o ABONO o GIRO
	private double monto;           // monto asociado al tipo de movimiento
	private double saldoResultante; // saldo de la cuenta previo al movimiento
	private Moneda tipoMoneda;      // moneda base que usa la cuenta
	private LocalDateTime fecha;    // fecha del movimiento

	/**
	 * Constructors
	 * 
	 * Inicializa el objeto con los parámetros.
	 * 
	 * @version 1.0
	 * 
	 * Se agrega inicializar objeto con valores por defecto,
	 * se recomienda inicializar con parámetros
	 * 
	 * @version 1.1
	 */
	
	
	// Inicializador con valores por defecto
	public MovimientosCuenta() {
		this.tipo = "";
		this.monto = 0;
		this.saldoResultante = 0;
		this.tipoMoneda = null;
		this.fecha = null;
	}
	
	/** 
	 * Inicializador con parametros (recomendado)
	 * 
	 * @param tipo            Tipo de movimiento (CREA, ABONO, GIRO)
	 * @param monto           Monto involucrado en el movimiento
	 * @param saldoResultante Saldo de la cuenta luego del movimiento
	 * @param tipoMoneda      Tipo de moneda del movimiento
	 * 
	 */
	public MovimientosCuenta(String tipo, double monto, double saldoResultante,Moneda tipoMoneda) {
		this.tipo = tipo;
		this.monto = monto;
		this.saldoResultante = saldoResultante;
		this.tipoMoneda = tipoMoneda;
		this.fecha = LocalDateTime.now();
	}
	
	/**
	 * Getters and Setters
	 * 
	 */
	
	
	/**
     * Obtiene el tipo de movimiento.
     * 
     * @return tipo de movimiento
     */
	public String getTipo() {
		return tipo;
	}
	
	
	/**
     * Establece el tipo de movimiento.
     * 
     * @param tipo tipo de movimiento
     */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	/**
     * Obtiene el monto del movimiento.
     * 
     * @return monto del movimiento
     */
	public double getMonto() {
		return monto;
	}
	
	
	/**
     * Establece el monto del movimiento.
     * 
     * @param monto monto del movimiento
     */
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
	/**
     * Obtiene el tipo de moneda del movimiento.
     * 
     * @return tipo de moneda
     */
	public Moneda getTipoMoneda() {
		return tipoMoneda;
	}

	
	/**
    * Establece el tipo de moneda del movimiento.
    * 
    * @param tipoMoneda tipo de moneda
    */
	public void setTipoMoneda(Moneda tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	
	
	/**
     * Obtiene el saldo resultante luego del movimiento.
     * 
     * @return saldo resultante
     */
	public double getSaldoResultante() {
		return saldoResultante;
	}
	
	
	
	/**
     * Establece el saldo resultante del movimiento.
     * 
     * @param saldoResultante saldo luego del movimiento
     */
	public void setSaldoResultante(double saldoResultante) {
		this.saldoResultante = saldoResultante;
	}
	
	
	
	/**
     * Obtiene la fecha y hora del movimiento.
     * 
     * @return fecha del movimiento
     */
	public LocalDateTime getFecha() {
		return fecha;
	}
	
	
	
	/**
     * Establece la fecha del movimiento.
     * Normalmente no se modifica manualmente.
     * 
     * @param fecha fecha del movimiento
     */
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
}
