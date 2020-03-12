package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.ArregloDinamico;

public class TestArregloDinamico {

	/**
	 * Atributo de arreglo que ser� usado en las pruebas
	 */
	private ArregloDinamico arreglo;
	
	/**
	 * Tama�o fijo del arreglo para pruebas
	 */
	private static int TAMANO=100;
	
	/**
	 * Escenario 1 de pruebas.
	 */
	@Before
	public void setUp1() {
		arreglo= new ArregloDinamico(TAMANO);
	}

	/**
	 * Escenario 2 de pruebas.
	 */
	public void setUp2() {
		for(int i =0; i< TAMANO*2; i++){
			arreglo.agregar(""+i);
		}
	}

	/**
	 * M�todo que ejecuta pruebas sobre el m�todo constructor de la clase Arreglo Din�mico.
	 */
	@Test
	public void testArregloDinamico() {
			
		assertNotNull("El arreglo deber�a estar creado",arreglo);
		assertEquals(100, arreglo.darCapacidad());
		assertEquals(0,arreglo.darTamano());
	}

	/**
	 * M�todo que ejecuta pruebas sobre el m�todo constructor de la clase Arreglo Din�mico.
	 */
	@Test
	public void testDarElemento() {
		setUp2();
		assertNotNull("El arreglo deber�a estar creado",arreglo);
		assertEquals(200, arreglo.darCapacidad());
		assertEquals(200,arreglo.darTamano());
		
		assertNull("Deber�a ser null",arreglo.darElemento(200));
		
		String elemento = null;		
		for (int i = 0; i < arreglo.darTamano(); i++) 
		{
			elemento = (String)arreglo.darElemento(i);
			assertTrue("El elemento en la posici�n "+i+" deber�a ser "+i+" pero es "+elemento+".", elemento.equals(""+i));
		}
		
	}

}
