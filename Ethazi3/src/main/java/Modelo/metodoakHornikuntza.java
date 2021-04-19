package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane; 

public class metodoakHornikuntza {

	public static String jasoHornikuntzarakoFabrikantea(String produktua) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String izenaFabrikantea = null;
		String query1 = (Kontsultak.selectFabrikantea + "'" + produktua + "')");
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				izenaFabrikantea = re.getString("Nombre");
			}
		} catch (SQLException e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du ikusi produktu fabrikantea", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return izenaFabrikantea;
	}

	public static void sartuHornikuntza(String produktua, int anyo, int mes, int dia, String nif, int kantitatea) throws ClassNotFoundException, SQLException {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String izenaFabrikantea = jasoHornikuntzarakoFabrikantea(produktua);
		int numTrans = metodoak.jasoTransakzioZbk();
		double dirua = metodoak.jasoProduktuenPrezioa(produktua, kantitatea);
		char operazioMota = 'A';
		String query2 = (Kontsultak.insertOperaciones + "('" + numTrans + "', '" + anyo + "/" + (mes + 1) + "/" + dia  
				+ "','" + dirua + "','" + nif + "', '" + operazioMota + "')");
		String query3 = (Kontsultak.insertHornikuntza + "(" + numTrans + ",'" + izenaFabrikantea + "')");
		String query4 = (Kontsultak.insertTiene+"('" + produktua + "'," + numTrans + "," + kantitatea + "," + dirua+ ", '" + operazioMota + "')");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query2);
			Statement s1;
			s1 = konekzioa.createStatement();
			s1.executeUpdate(query3);
			Statement s2;
			s2 = konekzioa.createStatement();
			s2.executeUpdate(query4);
		} catch (SQLException e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du hornikuntza egin", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
