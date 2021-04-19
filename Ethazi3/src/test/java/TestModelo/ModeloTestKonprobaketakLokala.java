package TestModelo;

import static org.junit.Assert.assertEquals;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import Modelo.BBDDKonexioa;
import Modelo.metodoakKonprobaketak;

public class ModeloTestKonprobaketakLokala {

	@Test
	public void komprobatuLokalarenIzena() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query2 = ("SELECT NIF FROM local LIMIT 1");
		String lehenengoNIF = null;
		try {
			ResultSet rs;
			PreparedStatement q;
			q = konekzioa.prepareStatement(query2);
			rs = q.executeQuery();
			if (rs.next()) {
				lehenengoNIF = rs.getString("NIF");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("SELECT nombre FROM local where NIF = '" + lehenengoNIF + "'");
		String esperotakoa = null;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				esperotakoa = re.getString("nombre");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(esperotakoa, metodoakKonprobaketak.konprobatuLokalarenIzena(lehenengoNIF));

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void komprobatuLokala() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query2 = ("SELECT NIF FROM local LIMIT 1");
		String lehenengoNIF = null;
		try {
			ResultSet rs;
			PreparedStatement q;
			q = konekzioa.prepareStatement(query2);
			rs = q.executeQuery();
			if (rs.next()) {
				lehenengoNIF = rs.getString("NIF");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("SELECT Tipo from local where NIF = (SELECT NIF from usuario where DNI ='" + lehenengoNIF
				+ "');");
		String esperotakoa = null;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				esperotakoa = re.getString("Tipo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________ç

		assertEquals(esperotakoa, metodoakKonprobaketak.konprobatuLokala(lehenengoNIF));
	}

}
