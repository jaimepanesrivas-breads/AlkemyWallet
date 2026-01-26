package cl.alkemy.utilitarios;

public class NumeroCuentaRandom {

	/**
	 * Atributos
	 */
	
	int max;
	int min;
	int numeroRandom;
	
	/**
	 * Constructors
	 */
	
	public NumeroCuentaRandom() {
		this.max = 1;
		this.min = 1;
		this.numeroRandom = (int)(Math.random() * (max - min + 1) + min);
		//System.out.println(numeroRandom); // Número entre 1 (min) y 1(msx)
	}
	
	public NumeroCuentaRandom(int max, int min) {
		this.max = max;
		this.min = min;
		this.numeroRandom = (int)(Math.random() * (max - min + 1) + min);
		//System.out.println(numeroRandom); // Número entre (min) y (msx
	}
	
	/**
	 * Getters and Setters
	 */
	
	public int getNumeroRandom() {
		return numeroRandom;
	}

	public void setNumeroRandom(int numeroRandom) {
		this.numeroRandom = numeroRandom;
	}

	
	
	
	
	
	
}
