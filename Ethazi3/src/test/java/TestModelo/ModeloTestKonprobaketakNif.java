package TestModelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import ModeloBBDD.BBDDKonexioa;
import Modelo.metodoakKonprobaketak;

public class ModeloTestKonprobaketakNif {

	@Test
	public void begiratuNIF() {

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

		assertTrue(metodoakKonprobaketak.begiratuNIF(lehenengoNIF));
	}

	@Test
	public void komprobatuNIF() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query2 = ("SELECT DNI FROM usuario LIMIT 1");
		String lehenengoDNI = null;
		try {
			ResultSet rs;
			PreparedStatement q;
			q = konekzioa.prepareStatement(query2);
			rs = q.executeQuery();
			if (rs.next()) {
				lehenengoDNI = rs.getString("DNI");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("SELECT NIF FROM usuario where dni = '" + lehenengoDNI + "'");
		String esperotakoa = null;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				esperotakoa = re.getString("NIF");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(esperotakoa, metodoakKonprobaketak.konprobatuNIF(lehenengoDNI));
	}
}
