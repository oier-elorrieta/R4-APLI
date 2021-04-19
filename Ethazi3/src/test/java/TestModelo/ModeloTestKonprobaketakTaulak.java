package TestModelo;

import static org.junit.Assert.assertFalse;
import java.sql.SQLException;
import org.junit.Test;
import Modelo.metodoakIncluye;
import Modelo.metodoakOfrece;
import Modelo.metodoakTiene;

public class ModeloTestKonprobaketakTaulak {


	@Test
	public void begiratuTiene(){

		assertFalse(metodoakTiene.begiratuTiene(null, 0));

	}

	@Test
	public void begiratuIncluye() throws ClassNotFoundException, SQLException{

		assertFalse(metodoakIncluye.begiratuIncluye(0, 0));

	}		

	@Test
	public void begiratuOfrece(){

		assertFalse(metodoakOfrece.begiratuLocalOfrece(null, 0));

	}
}
