

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

// Importar las clases de prueba individuales paquete por paquete
import cl.alkemy.utilitarios.servicios.validaciones.ValidaFactoryTest;
import cl.alkemy.utilitarios.servicios.validaciones.ValidadorNumeroImplTest;
import cl.alkemy.utilitarios.servicios.validaciones.ValidadorStringImplTest;

import cl.alkemy.utilitarios.servicios.MonedaTest;
import cl.alkemy.utilitarios.servicios.ConversorMonedaImplTest;

import cl.alkemy.utilitarios.MoneyUtilsTest;
import cl.alkemy.utilitarios.MenuTest;
import cl.alkemy.utilitarios.NumeroCuentaRandomTest;

import cl.alkemy.business.MovimientosCuentaTest;
import cl.alkemy.business.AlkemyCuentaTest;

// Definición del suite de pruebas
	
	@Suite
	@SelectClasses({
	   
		MovimientosCuentaTest.class,
		AlkemyCuentaTest.class,
		MoneyUtilsTest.class,
		MenuTest.class,
		NumeroCuentaRandomTest.class,
		ConversorMonedaImplTest.class,
		MonedaTest.class,
	    ValidadorNumeroImplTest.class,
	    ValidadorStringImplTest.class,
	    ValidaFactoryTest.class
	})
	
	/**
	 * Calse AllSuiteTest
	 * 
	 * <p>
	 * Suite de pruebas unitarias para todo el proyecto AlkemyWallet.
	 * </p>
	 * <p>
	 * Esta clase agrupa todas las pruebas unitarias definidas en
	 * los distintos paquetes del proyecto, permitiendo su ejecución
	 * conjunta.
	 * </p>
	 * 
	 * @author Jaime Francisco Panes Rivas
	 * @version 1.0
	 * @since 2026-01
	 * 
	 * 
	 */	
	public class AllTestsSuite {
	}


