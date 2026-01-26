package cl.alkemy.business;

import java.util.ArrayList;

import cl.alkemy.utilitarios.servicios.Moneda;

public class AlkemyCuenta {
	
	/**
	 * Atributos
	 */
	
	private int numeroCuenta;
	private String nombreTitular;
	private double saldoActual;
	private ArrayList<MovimientosCuenta> movimientos = new ArrayList<>();
	private Moneda tipoMoneda;
	
	/**
	 * Constructors
	 */
	
	public AlkemyCuenta() {
		this.numeroCuenta = 0;
		this.nombreTitular = "";
		this.saldoActual = -1;
		this.tipoMoneda = Moneda.CLP;
	}
	
	
	public AlkemyCuenta(int numeroCuenta, String nombreTitular, double saldoActual, Moneda tipoMoneda) {
		this.numeroCuenta = numeroCuenta;
		this.nombreTitular = nombreTitular;
		this.saldoActual = saldoActual;
		this.tipoMoneda = tipoMoneda;
		this.movimientos.add(new MovimientosCuenta("CREA",saldoActual,0, tipoMoneda));
	
	}
	
	
	
	/**
	 * Getters and Setters
	 */
	
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getNombreTitular() {
		return nombreTitular;
	}
	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}
	public double getSaldoActual() {
		return saldoActual;
	}
	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}
	
	public ArrayList<MovimientosCuenta> getMovimientos() {
		return movimientos;
	}


	public void setMovimientos(ArrayList<MovimientosCuenta> movimientos) {
		this.movimientos = movimientos;
	}


	public Moneda getTipoMoneda() {
		return tipoMoneda;
	}


	public void setTipoMoneda(Moneda tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
	
	
	/**
	 * Métodos propios 
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
	
	
	public void giro (double montoGiro) {
		
		if (montoGiro <= 0) {
			System.out.println("\nHubo problemas en su giro. El monto a girar debe ser mayor a 0");
		} else if(montoGiro > this.saldoActual) {
			System.out.println("\nHubo problemas en su giro. El saldo es insuficiente para realizar el giro, su saldo actual es de $ " + this.saldoActual);
		} else {	
			this.movimientos.add(new MovimientosCuenta("GIRO",montoGiro,saldoActual,tipoMoneda));
			this.saldoActual -= montoGiro; 
			System.out.println("\nGiro realizado exitosamente");
			System.out.println("\nEstimados " + this.nombreTitular + " se ha realizado un giro de $ " + montoGiro + " en su cuenta N° " + this.numeroCuenta + ".\nSu nuesvo saldo es de $" + this.saldoActual);
			
		}
		
	}
	
	public void imprimir () {
		System.out.println("\nImpresión Cliente");
		System.out.println("Número Cuenta  : " + this.numeroCuenta);
		System.out.println("Nombre Titular : " + this.nombreTitular);
		System.out.println("Saldo Cuenta   : $" + this.saldoActual);
		System.out.println("Moneda         : " + this.getTipoMoneda());
		
	}
	
	public void mostrarMovimientos() {
		System.out.println("\n--- HISTORIAL DE MOVIMIENTOS ---");
	    for (MovimientosCuenta m : this.movimientos) {
	        System.out.println(
	            "FECHA MOVIMIENTO :" + m.getFecha() + " | " +
	            "TIPO MOVIMIENTO :" + m.getTipo() + " | " +
	            "MONTO MOVIMIENTO :" + m.getMonto() + " | " +
	            "TIPO MONEDA CUENTA :" + m.getTipoMoneda() + " | " +
	            "SALDO PREVIO MOVIMIENTO :" + m.getSaldoResultante() 
	        );
	    }
	}
	
}
