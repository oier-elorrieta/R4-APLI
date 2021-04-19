package TestModelo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Modelo.Erabiltzaile;
import Modelo.metodoakErabiltzaile;

public class ModeloTestErabiltzailea {

	@Test
	public void sartuErabiltzailea(){

		Erabiltzaile esperotakoa = new Erabiltzaile("esperotakoa", "esperotakoa1");

		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(esperotakoa, metodoakErabiltzaile.sartuErabiltzailea("esperotakoa", "esperotakoa1", esperotakoa));
	}
}
