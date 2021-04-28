package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ModeloBBDD.BBDDKonexioa;
import ModeloBBDD.Kontsultak;

public class Hornikuntza extends Operaciones{

	private int produktu_kantitatea;
	private String produktua;

	public Hornikuntza(int transferentziaZenbakia, double totala, String produktua, String nIF, int produktu_kantitatea) {
		super(transferentziaZenbakia, totala, nIF, 'A');
		this.produktua = produktua;
		this.produktu_kantitatea = produktu_kantitatea;
	}

	public int getProduktu_kantitatea() {
		return produktu_kantitatea;
	}

	public void setProduktu_kantitatea(int produktu_kantitatea) {
		this.produktu_kantitatea = produktu_kantitatea;
	}

	public void sartuOperaciones() {
		super.sartuOperaciones();
	}

	public String jasoHornikuntzarakoFabrikantea() {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String izenaFabrikantea = null;
		String query1 = (Kontsultak.selectFabrikantea + "'" + this.produktua + "')");
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

	public void sartuHornikuntza() throws ClassNotFoundException, SQLException {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String izenaFabrikantea = jasoHornikuntzarakoFabrikantea();
		String query1 = (Kontsultak.insertHornikuntza + "(" + this.transferentziaZenbakia + ",'" + izenaFabrikantea + "')");
		String query2 = (Kontsultak.insertTiene+"('" + this.produktua + "'," + this.transferentziaZenbakia + "," + this.produktu_kantitatea + "," + this.totala + ", '"+this.operazioMota+"')");
		try { 
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
			Statement s1;
			s1 = konekzioa.createStatement();
			s1.executeUpdate(query2);
		} catch (SQLException e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du hornikuntza egin", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void stockGehitu() {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.updateStock + "Stock + "+this.produktu_kantitatea+" where NIFLocal = '"+this.NIF+"' and NomProducto = '"+this.produktua+"'");
		try { 
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1); 
		} catch (SQLException e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du stocka gehitu", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
