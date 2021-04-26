package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import ModeloBBDD.BBDDKonexioa;
import ModeloBBDD.Kontsultak;

public class Komanda extends Operaciones{


	public Komanda(int transferentziaZenbakia, double totala, String nIF) {
		super(transferentziaZenbakia, totala, nIF, 'C'); 
	}

	public void hasieratuOperaciones() throws ClassNotFoundException, SQLException {
		Connection konekzioa = BBDDKonexioa.getConexion();
		int numTrans = metodoak.jasoTransakzioZbk();
		String query1 = (Kontsultak.insertNumTransOperaciones + "(" + numTrans + ", 'C')");
		String query2 = (Kontsultak.insertKomanda + "(" + numTrans + ")");
		try {
			Statement s1;
			s1 = konekzioa.createStatement();
			s1.executeUpdate(query1);
			Statement s2;
			s2 = konekzioa.createStatement();
			s2.executeUpdate(query2);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du hasieratu operazioa", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void sartuKomanda() throws ClassNotFoundException, SQLException {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.updateOperaciones + this.totala + " , NIF = '" + this.NIF
				+ "' where Numtrans = (" + Kontsultak.selectMaxNumTransKomanda + ")");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1); 
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du sartu komanda", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void ezabatuKomanda() throws ClassNotFoundException, SQLException {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.delete);
		try {
			Statement s1;
			s1 = konekzioa.createStatement();
			s1.executeUpdate(query1);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du ezabatu komanda", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
