package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class metodoakEskaera {

	public static void sartuEskaera(String NIF, double diruTotala, String helbidea, int TransferentziaZbk, int anyo,
			int mes, int dia) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		char operazioMota = 'P';
		String query1 = (Kontsultak.insertOperaciones + "('" + TransferentziaZbk + "', '" + anyo + "/" + (mes + 1) + "/"
				+ dia + "','" + diruTotala + "','" + NIF + "', '" + operazioMota + "')");
		String query2 = (Kontsultak.insertEskaera + "('" + TransferentziaZbk + "', '" + helbidea + "')");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
			Statement st;
			st = konekzioa.createStatement();
			st.executeUpdate(query2);
		} catch (SQLException e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du sartu eskaera", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
