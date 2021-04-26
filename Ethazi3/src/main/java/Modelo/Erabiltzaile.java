package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ModeloBBDD.BBDDKonexioa;
import ModeloBBDD.Kontsultak;

public class Erabiltzaile {

	private String erabiltzailea;
	private String pasahitza;

	public Erabiltzaile(String erabiltzailea, String pasahitza) {
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
	}

	public String getErabiltzailea() {
		return erabiltzailea;
	}
	public void setErabiltzailea(String erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}
	public String getPasahitza() {
		return pasahitza;
	}
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	@Override
	public String toString() {
		return "Erabiltzaile [erabiltzailea=" + erabiltzailea + ", pasahitza=" + pasahitza + "]";
	}
	
	public Erabiltzaile sartuErabiltzailea(String erabiltzailea, String pasahitza, Erabiltzaile usuarioa) {
		usuarioa.setErabiltzailea(erabiltzailea);
		usuarioa.setPasahitza(pasahitza);
		return usuarioa;
	}		

	public void sartuDatuak(String izena, String abizena, String pasahitza, String nan, String nif) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.insertDatuak + "('" + izena + "', '" + abizena + "','" + pasahitza + "','" + nan
				+ "', '" + nif + "')");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
		} catch (SQLException e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du sartu erabiltzailea", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	
}
