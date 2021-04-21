package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Faktura extends Operaciones{

	private String izena_hartzaile;
	private String abizena_hartzaile;

	public Faktura(int transferentziaZenbakia, double totala, String produktua, String nIF, String izena_hartzaile, String abizena_hartzaile) {
		super(transferentziaZenbakia, totala, nIF);
		this.izena_hartzaile = izena_hartzaile;
		this.abizena_hartzaile = abizena_hartzaile;
	}

	public String getIzena_hartzaile() {
		return izena_hartzaile;
	}

	public void setIzena_hartzaile(String izena_hartzaile) {
		this.izena_hartzaile = izena_hartzaile;
	}

	public String getAbizena_hartzaile() {
		return abizena_hartzaile;
	}

	public void setAbizena_hartzaile(String abizena_hartzaile) {
		this.abizena_hartzaile = abizena_hartzaile;
	}

	public void sartuOperaciones() {
		super.sartuOperaciones();
	}
	
	public boolean begiratuFakturanNIF() {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query1 = (Kontsultak.selectNifFaktura+"'" + this.NIF + "'");
		boolean nifDago = false;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			while (re.next()) {
				this.NIF = re.getString("NIF");
				nifDago = true;
				break;
			}
		} catch (SQLException e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du ikusi fakturaren NIF", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return nifDago;
	}

	public void insertNifFaktura() {
		Connection konekzioa = BBDDKonexioa.getConexion();
		String query2 = (Kontsultak.insertNifFaktura + "('" + NIF + "', '" + this.izena_hartzaile + "', '" + this.abizena_hartzaile + "')");
		try {
			Statement st;
			st = konekzioa.createStatement();
			st.executeUpdate(query2);
		} catch (SQLException e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du sartu NIF faktura", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void sartuFaktura() {
		Connection konekzioa = BBDDKonexioa.getConexion();
		boolean nifDago = begiratuFakturanNIF();
		if (nifDago == false) {
			insertNifFaktura();
		}
		String query1 = (Kontsultak.insertFactura + "('" + this.transferentziaZenbakia + "','" + this.NIF + "');");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1); 
		} catch (SQLException e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du sartu faktura", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

}
