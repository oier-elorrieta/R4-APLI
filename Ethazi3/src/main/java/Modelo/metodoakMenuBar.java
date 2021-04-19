package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class metodoakMenuBar {

	public static String[] top5produktuak (String erabiltzailea) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectTop5 + " where NIF = '"+metodoakKonprobaketak.konprobatuNIF(erabiltzailea)+"'");
		String[] top5produktuak = new String[5];
		int i = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			while (re.next()) {
				top5produktuak[i] = re.getString("NomProducto");
				i++;
			}
		} catch (SQLException e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du ikusi top 5 produktuak", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return top5produktuak;
	}

	public static double egunerokoIrabazia(String erabiltzailea) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectEgunero + " where NIF = '"+metodoakKonprobaketak.konprobatuNIF(erabiltzailea)+"'");
		double irabazia = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				irabazia = re.getDouble(1);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du ikusi eguneroko irabazia", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return irabazia;
	}

	public static double asterokoIrabazia(String erabiltzailea) {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectAstero + " where NIF = '"+metodoakKonprobaketak.konprobatuNIF(erabiltzailea)+"'");
		double irabazia = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				irabazia = re.getDouble(1);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du ikusi asteroko irabazia", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return irabazia;
	}
}