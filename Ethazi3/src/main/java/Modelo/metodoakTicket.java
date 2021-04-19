package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class metodoakTicket {

	public static void sartuTicket(String NIF, double diruTotala, int TransferentziaZbk, int anyo, int mes, int dia) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		char operazioMota = 'T';
		String query1 = (Kontsultak.insertOperaciones + "('" + TransferentziaZbk + "', '" + anyo + "/" + (mes + 1) + "/"
				+ dia + "','" + diruTotala + "','" + NIF + "', '" + operazioMota + "')");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du sartu ticketa", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

}
