package TestModelo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Modelo.Erabiltzaile;

public class ModeloTestErabiltzailea {

	@Test
	public void sartuErabiltzailea(){

		Erabiltzaile esperotakoa = new Erabiltzaile("esperotakoa", "esperotakoa1");

		Erabiltzaile usuarioa = new Erabiltzaile(null, null);		
		
		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(esperotakoa, usuarioa.sartuErabiltzailea("esperotakoa", "esperotakoa1", esperotakoa));
	}
}
