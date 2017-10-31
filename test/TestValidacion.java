package test;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Validacion;

public class TestValidacion {

	@Test
	public void mostrarExcepcionPorIngresarTresArgumentos() {
		try {
			Validacion validar = new Validacion();
			validar.validarContenido("3,321,87");
			fail();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Test
	public void mostrarExcepcionPorIngresarTamanoMayorADiez() {
		try {
			Validacion validar = new Validacion();
			validar.validarContenido("11,321");
			fail();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Test
	public void mostrarExcepcionPorIngresarTamanomenorAUno() {
		try {
			Validacion validar = new Validacion();
			validar.validarContenido("0,321");
			fail();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Test
	public void mostrarExcepcionPorIngresarseparadorEntreDigitosMayorACinco() {
		try {
			Validacion validar = new Validacion();
			validar.validarEspacioEntreDigitos("6");
			fail();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Test
	public void mostrarExcepcionPorIngresarseparadorEntreDigitosMenorACero() {
		try {
			Validacion validar = new Validacion();
			validar.validarEspacioEntreDigitos("-1");
			fail();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Test
	public void mostrarExcepcionPorIngresarseparadorEntreDigitosConDecimales() {
		try {
			Validacion validar = new Validacion();
			validar.validarEspacioEntreDigitos("1.1");
			fail();
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
