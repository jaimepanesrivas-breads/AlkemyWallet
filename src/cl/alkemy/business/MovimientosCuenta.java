package cl.alkemy.business;

import java.time.LocalDateTime;

import cl.alkemy.utilitarios.servicios.Moneda;

/**
 * Clase MovimientosCuenta
 * 
 * <p>Representa los movimientos que pueden haber en una cuenta creada.
 * Los moviminetos pueden ser :
 * Crear Cuenta ==> CREA
 * Abonar a la Cuenta ==> ABONO
 * Girar desde la cuenta ==> GIRO
 * </p>
 *  <p>
 * Esta clase se utiliza para mantener un historial de los movimientos de la cuenta.
 * 
 * Cada movimiento registra:
 * - La fecha de movimiento aaaa-mm-dd y horario
 * - Tipo de mobimiento (CREA-ABONO-GIRO)
 * - Monto involucrado
 * - Moneda de la cuenta
 * - Saldo antes del movimiento en la cuenta
 * 
 * </p>
 * 
 * @author Jaime Francisco Panes Rivas.
 * @version 1.0
 * @since 2026-01
 * 
 * <p>Se agrega constructor vacio
 * </p>
 * @author Jaime Francisco Panes Rivas.
 * @version 1.1
 * @since 2026-01
 * 
 */

public class MovimientosCuenta {

	
	//Atributos
	
	/**
	 * Indica tipo tipo de movimiento CREA o ABONO o GIRO
	 */
	private String tipo;
	
	/**
	 * Representa el monto del movimiento
	 */
	private double monto;           
	
	/**
	 * Representa el saldo de la cuenta previo al movimiento
	 */
	private double saldoResultante;
	
	/**
	 * Representa el tipo de moneda del movimiento
	 */
	private Moneda tipoMoneda;
	
	/**
	 * Representa la fecha y hora del movimiento
	 */
	private LocalDateTime fecha;

	
	//Constructors
	
	/**
	 * Constructor MovimientosCuenta sin parámetros
	 * 
	 * <p>
	 * Inicializa el objeto MovimientosCuenta sin parámetros, con datos
	 * por defecto.
	 * </P>
	 * 
	 * 
	 * <p>Se agrega inicializar objeto con valores por defecto,
	 * se recomienda inicializar con parámetros
	 * </p>
	 * 
	 * 
	 */
	
	public MovimientosCuenta() {
		this.tipo = "";
		this.monto = 0;
		this.saldoResultante = 0;
		this.tipoMoneda = null;
		this.fecha = null;
	}
	
	
	/**
	 * Constructor MovimientosCuenta con parámetros
	 * 
	 * <p>
	 * Inicializa el objeto MovimientosCuenta con parámetros, dados por el usuario.
	 * </P>
	 * 
	 * @param tipo            Tipo de movimiento (CREA, ABONO, GIRO)
	 * @param monto           Monto involucrado en el movimiento
	 * @param saldoResultante Saldo de la cuenta luego del movimiento
	 * @param tipoMoneda      Tipo de moneda del movimiento
	 * 
	 * 
	 */
		
	public MovimientosCuenta(String tipo, double monto, double saldoResultante,Moneda tipoMoneda) {
		this.tipo = tipo;
		this.monto = monto;
		this.saldoResultante = saldoResultante;
		this.tipoMoneda = tipoMoneda;
		this.fecha = LocalDateTime.now();
	}
	
	
	
	// Getters and Setters
	
	/**
     * Obtiene el tipo de movimiento actual a realizar.
     * 
     * @return valor del tipo de movimiento
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
     * Obtiene el monto asociado al movimiento.
     * 
     * @return valor monto del movimiento
     */
	public double getMonto() {
		return monto;
	}
	
	
	/**
     * Establece el monto asociado al movimiento.
     * 
     * @param monto nuevo monto del movimiento
     */
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
	/**
     * Obtiene el tipo de moneda del movimiento.
     * 
     * @return valor del tipo de moneda
     */
	public Moneda getTipoMoneda() {
		return tipoMoneda;
	}

	
	/**
    * Establece el tipo de moneda del movimiento.
    * 
    * @param tipoMoneda nuevo valor de tipo de moneda
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
     * @param saldoResultante nuevo valor de saldo luego del movimiento
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
     * @param fecha nuevo valor de fecha del movimiento
     */
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
}
