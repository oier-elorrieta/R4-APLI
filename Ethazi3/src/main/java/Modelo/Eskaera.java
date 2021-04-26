package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ModeloBBDD.BBDDKonexioa;
import ModeloBBDD.Kontsultak;

public class Eskaera extends Operaciones{

	private String helbidea;

	public Eskaera(int transferentziaZenbakia, double totala, String nIF, String helbidea) {
		super(transferentziaZenbakia, totala, nIF, 'P');
		this.helbidea = helbidea;
	}

	public String getHelbidea() {
		return helbidea;
	}

	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}

	public void sartuOperaciones() {
		super.sartuOperaciones();
	}

	public void sartuEskaera() {
		Connection konekzioa = BBDDKonexioa.getConexion(); 
		String query1 = (Kontsultak.insertEskaera + "('" + this.transferentziaZenbakia + "', '" + this.helbidea + "')");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1); 
		} catch (SQLException e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du sartu eskaera", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}