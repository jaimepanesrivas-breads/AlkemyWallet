package cl.alkemy.business;

import cl.alkemy.utilitarios.servicios.Moneda;


/**
 * Interfaz Cuenta
 * 
 * <p>
 * Define el contrato para las operaciones básicas
 * que una cuenta bancaria debe soportar.
 * </p>
 * 
 * <p>
 * Las implementaciones de esta interfaz deben proporcionar
 * la lógica para depositar, girar fondos, consultar saldo,
 * y gestionar la moneda asociada a la cuenta.
 * </p>
 * 
 *  
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 * 
 * <p>
 * Se agrega el método cambiarMonedaMovimiento y mostrarMovimientos para 
 * gestionar los movimientos de la cuenta y permitir el cambio de moneda.
 * </p>
 * 
 *  
 * @author Jaime Francisco Panes Rivas
 * @version 1.0
 * @since 2026-01
 */
public interface Cuenta {
   
	/**
	 * Deposita un monto en la cuenta.
	 * @param monto
	 */
	void depositar(double monto);
	
	
	/**
	 * Gira un monto desde la cuenta.
	 * @param monto
	 */
	void giro(double monto);
	
	/**
	 * Obtiene el saldo actual de la cuenta.
	 * @return saldo actual
	 */
	double getSaldoActual();	
	
	/**
	 * Obtiene el tipo de moneda de la cuenta.
	 * @return tipo de moneda
	 */
	Moneda getTipoMoneda();
	
	
	/**
	 * Obtiene el número de cuenta.
	 * @return número de cuenta
	 */
	int getNumeroCuenta();
	
	/**
	 * Obtiene el nombre del titular de la cuenta.
	 * @return nombre del titular
	 */
	String getNombreTitular();
	
	/**
	 * Imprime los detalles de la cuenta.
	 */
	void imprimir();
	
	/**
	 * Muestra los movimientos realizados en la cuenta.
	 */
	void mostrarMovimientos();
	
	/**
	 * Cambia el tipo de moneda de la cuenta.
	 * @param nuevaMoneda nueva moneda a establecer
	 */
	void cambiarMonedaMovimiento(Moneda nuevaMoneda);
	
	
	
}
