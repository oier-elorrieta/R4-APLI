package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class metodoakFaktura {

	public static boolean begiratuFakturanNIF(String nif) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectNifFaktura+"'" + nif + "'");
		boolean nifDago = false;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			while (re.next()) {
				nif = re.getString("NIF");
				nifDago = true;
				break;
			}
		} catch (SQLException e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du ikusi fakturaren NIF", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return nifDago;
	}

	public static void insertNifFaktura(String NIF, String izena, String abizena) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query2 = (Kontsultak.insertNifFaktura + "('" + NIF + "', '" + izena + "', '" + abizena + "')");
		try {
			Statement st;
			st = konekzioa.createStatement();
			st.executeUpdate(query2);
		} catch (SQLException e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du sartu NIF faktura", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void sartuFaktura(String NIF, String izena, String abizena, double diruTotala, int TransferentziaZbk,
			int anyo, int mes, int dia) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		char operazioMota = 'F';
		String query1 = (Kontsultak.insertOperaciones + "('" + TransferentziaZbk + "', '" + anyo + "/" + (mes + 1) + "/"
				+ dia + "' ,'" + diruTotala + "','" + NIF + "', '" + operazioMota + "')");
		boolean nifDago = begiratuFakturanNIF(NIF);
		if (nifDago == false) {
			insertNifFaktura(NIF, izena, abizena);
		}
		String query3 = (Kontsultak.insertFactura + "('" + TransferentziaZbk + "','" + NIF + "');");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
			Statement smt;
			smt = konekzioa.createStatement();
			smt.executeUpdate(query3);
		} catch (SQLException e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du sartu faktura", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
