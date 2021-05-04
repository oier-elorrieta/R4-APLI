package TestModelo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Modelo.metodoak;

public class ModeloTestTransferentziaZbk {

	@Test
	public void testGehituTransferentziaZenbakia() {

		int esperotakoa = 1;

		assertEquals(esperotakoa, metodoak.gehituTransferentziaZenbakia(0));

	}
}