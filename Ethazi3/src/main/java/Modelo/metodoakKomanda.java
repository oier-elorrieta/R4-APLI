package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class metodoakKomanda {

	public static void hasieratuOperaciones() throws ClassNotFoundException, SQLException {
		Connection konekzioa = BBDDKonexioa.getConexion();
		int numTrans = metodoak.jasoTransakzioZbk();
		String query1 = (Kontsultak.insertNumTransOperaciones + "" + numTrans + ")");
		String query2 = (Kontsultak.insertKomanda + "('" + numTrans + "')");
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

	public static void sartuKomanda(double prezioa, String nif, int anyo, int mes, int dia)
			throws ClassNotFoundException, SQLException {
		Connection konekzioa = BBDDKonexioa.getConexion();
		char operazioMota = 'C';
		String query1 = (Kontsultak.updateOperaciones + "'" + anyo + "/" + (mes + 1) + "/" + dia
				+ "' , Total_Operaciones = " + prezioa + " , TipoOperacion = '" + operazioMota + "', NIF = '" + nif
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

	public static void ezabatuKomanda() throws ClassNotFoundException, SQLException {
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
