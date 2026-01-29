package cl.alkemy.business;

import cl.alkemy.utilitarios.servicios.Moneda;

public interface Cuenta {

	void depositar(double monto);
	void giro(double monto);
	
	double getSaldoActual();	
	Moneda getTipoMoneda();
	
	int getNumeroCuenta();
	String getNombreTitular();
	
	void imprimir();
	void mostrarMovimientos();
	//void setTipoMoneda(Moneda moneda);
	//void setSaldoActual(double nuevoSaldo);
	
	
	
}
