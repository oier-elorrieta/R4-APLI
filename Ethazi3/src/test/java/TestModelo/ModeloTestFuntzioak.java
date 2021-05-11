package TestModelo;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.junit.Test;
import ModeloBBDD.BBDDKonexioa;
import ModeloBBDD.metodoakFuntzioakDeitu;

public class ModeloTestFuntzioak {

	@Test
	public void dirutotala() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		double diruTotala = 0;
		
		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("select importeTotal()");
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				diruTotala = re.getDouble("importeTotal()");
			}
		} catch (SQLException e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du ikusi plater motak", "ERROR", JOptionPane.ERROR_MESSAGE);
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(metodoakFuntzioakDeitu.dirutotala(), diruTotala, 0);
	}
	
	// *****************************************************************************************************************************************************************************************************
	
	@Test
	public void funtzioProbabilitateOrokorra() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		float emaitza = 0;
		
		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("select funtzioprobabilitateOrokorra('Ardoa','Colacao')");
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				emaitza = re.getFloat("funtzioprobabilitateOrokorra('Ardoa','Colacao')");
			}
		} catch (SQLException e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du probabilitate funtzioa ikusi", "ERROR", JOptionPane.ERROR_MESSAGE);
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(metodoakFuntzioakDeitu.funtzioProbabilitateOrokorra("Ardoa", "Colacao"), emaitza, 0);
	}
	
	// *****************************************************************************************************************************************************************************************************

	@Test
	public void funtzioProbabilitateLokala() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		float emaitza = 0;
		
		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("select funtzioprobabilitateLokala('Ardoa','Colacao','12345678R')");
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				emaitza = re.getFloat("funtzioprobabilitateLokala('Ardoa','Colacao','12345678R')");
			}
		} catch (SQLException e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du probabilitate funtzioa ikusi", "ERROR", JOptionPane.ERROR_MESSAGE);
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(metodoakFuntzioakDeitu.funtzioProbabilitateLokala("Ardoa", "Colacao", "12345678R"), emaitza, 0);
	}
}
