package TestModelo;

import static org.junit.Assert.assertEquals;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import ModeloBBDD.BBDDKonexioa;
import Modelo.metodoak;

public class ModeloTestTransferentziaZbk {

	@Test
	public void testGehituTransferentziaZenbakia() {

		int esperotakoa = 1;

		assertEquals(esperotakoa, metodoak.gehituTransferentziaZenbakia(0));

	}

	@Test
	public void jasoTransakzioZbk() throws ClassNotFoundException, SQLException {

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("SELECT max(NumTrans) from operaciones;");
		int esperotakoa = 0;
		try {
			ResultSet rs;
			PreparedStatement q;
			q = konekzioa.prepareStatement(query1);
			rs = q.executeQuery();
			if (rs.next()) {
				if (rs.getInt("max(NumTrans)") == 0) {
					esperotakoa = 1;
				} else {
					esperotakoa = rs.getInt("max(NumTrans)");
					esperotakoa++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(esperotakoa, metodoak.jasoTransakzioZbk());

	}
}