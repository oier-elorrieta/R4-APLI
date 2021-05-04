package TestModelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import ModeloBBDD.BBDDKonexioa;
import ModeloBBDD.metodoakKonprobaketak;

public class ModeloTestKonprobaketak {
	
	@Test
	public void begiratuDNI() {

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

		assertTrue(metodoakKonprobaketak.begiratuNAN(lehenengoDNI));
	}

	@Test
	public void begiratuStock() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("SELECT NomProducto FROM vende LIMIT 1");
		String lehenengoProduktua = null;
		try {
			ResultSet rs;
			PreparedStatement q;
			q = konekzioa.prepareStatement(query1);
			rs = q.executeQuery();
			if (rs.next()) {
				lehenengoProduktua = rs.getString("NomProducto");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

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

		String query4 = ("SELECT Stock FROM vende where NIFLocal = '" + lehenengoNIF + "' and NomProducto = '"
				+ lehenengoProduktua + "' ");

		int esperotakoa = 0;

		try {
			ResultSet rs;
			PreparedStatement q;
			q = konekzioa.prepareStatement(query4);
			rs = q.executeQuery();
			if (rs.next()) {
				esperotakoa = rs.getInt("Stock");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(esperotakoa, metodoakKonprobaketak.begiratuStock(lehenengoProduktua, lehenengoNIF));
	}

	@Test
	public void konprobatuErabiltzailea() {

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

		String query3 = ("SELECT Contrasenya FROM usuario LIMIT 1");
		String lehenengoPasahitza = null;
		try {
			ResultSet rs;
			PreparedStatement q;
			q = konekzioa.prepareStatement(query3);
			rs = q.executeQuery();
			if (rs.next()) {
				lehenengoPasahitza = rs.getString("Contrasenya");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("SELECT DNI,Contrasenya FROM usuario where dni = '" + lehenengoDNI + "'");
		String esperotakoa = null;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				if (re.getString("DNI").equalsIgnoreCase(lehenengoDNI)
						&& re.getString("Contrasenya").equalsIgnoreCase(lehenengoPasahitza)) {
					esperotakoa = "EZ";
				} else if (re.getString("DNI").equalsIgnoreCase(lehenengoDNI)
						&& !re.getString("Contrasenya").equalsIgnoreCase(lehenengoPasahitza)) {
					esperotakoa = "Bai, pasahitza txarto";
				}
			} else {
				esperotakoa = "Bai, erabiltzailea txarto";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(esperotakoa, metodoakKonprobaketak.konprobatuErabiltzailea(lehenengoDNI, lehenengoPasahitza));
	}
}