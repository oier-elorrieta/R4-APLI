package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ModeloBBDD.BBDDKonexioa;
import ModeloBBDD.Kontsultak;

public abstract class Operaciones {

	protected int transferentziaZenbakia;
	protected double totala;
	protected String NIF; 
	protected char operazioMota;

	public Operaciones(int transferentziaZenbakia, double totala, String nIF, char operazioMota) {
		this.transferentziaZenbakia = transferentziaZenbakia;
		this.totala = totala;
		this.NIF = nIF;
		this.operazioMota = operazioMota;
	}

	public int getTransferentziaZenbakia() {
		return transferentziaZenbakia;
	}

	public void setTransferentziaZenbakia(int transferentziaZenbakia) {
		this.transferentziaZenbakia = transferentziaZenbakia;
	}

	public double getTotala() {
		return totala;
	}

	public void setTotala(double totala) {
		this.totala = totala;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public char getOperazioMota() {
		return operazioMota;
	}

	public void setOperazioMota(char operazioMota) {
		this.operazioMota = operazioMota;
	}

	public void sartuOperaciones() {
		Connection konekzioa = BBDDKonexioa.getConexion(); 
		String query1 = (Kontsultak.insertOperaciones + "('" + this.transferentziaZenbakia + "' ,'" + this.totala + "','" + this.NIF + "', '"+ this.operazioMota +"')");
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datu baseak ezin du sartu ticketa", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	};
}
