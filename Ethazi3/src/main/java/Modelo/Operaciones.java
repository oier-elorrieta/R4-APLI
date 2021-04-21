package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public abstract class Operaciones {

	protected int transferentziaZenbakia;
	protected double totala;
	protected String produktua; 
	protected String NIF; 

	public Operaciones(int transferentziaZenbakia, double totala, String produktua, String nIF) {
		this.transferentziaZenbakia = transferentziaZenbakia;
		this.totala = totala;
		this.produktua = produktua; 
		NIF = nIF;
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

	public String getProduktua() {
		return produktua;
	}

	public void setProduktua(String produktua) {
		this.produktua = produktua;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public void sartuOperaciones() {
		Connection konekzioa = BBDDKonexioa.getConexion(); 
		String query1 = (Kontsultak.insertOperaciones + "('" + this.transferentziaZenbakia + "' ,'" + this.totala + "','" + this.NIF + "', '" + this.produktua + "')");
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
