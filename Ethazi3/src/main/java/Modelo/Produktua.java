package Modelo;

import java.sql.Date;

public class Produktua {

	private String izena;
	private String mota;
	private Date data; 
	private double erosPrezioa;
	private double saltzekoPrezioa;
	private String fabrikantea;


	public Produktua(String izena, Date data, String mota, double saltzekoPrezioa, double erosPrezioa, String fabrikantea) {
		this.izena = izena;
		this.data = data;
		this.mota = mota;
		this.erosPrezioa = erosPrezioa;
		this.saltzekoPrezioa = saltzekoPrezioa;
		this.fabrikantea = fabrikantea;
	}


	public String getIzena() {
		return izena;
	}


	public void setIzena(String izena) {
		this.izena = izena;
	}


	public String getMota() {
		return mota;
	}


	public void setMota(String mota) {
		this.mota = mota;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public double getErosPrezioa() {
		return erosPrezioa;
	}


	public void setErosPrezioa(double erosPrezioa) {
		this.erosPrezioa = erosPrezioa;
	}


	public double getSaltzekoPrezioa() {
		return saltzekoPrezioa;
	}


	public void setSaltzekoPrezioa(double saltzekoPrezioa) {
		this.saltzekoPrezioa = saltzekoPrezioa;
	}


	public String getFabrikantea() {
		return fabrikantea;
	}


	public void setFabrikantea(String fabrikantea) {
		this.fabrikantea = fabrikantea;
	}


	@Override
	public String toString() {
		return "Produktua [izena=" + izena + ", mota=" + mota + ", data=" + data + ", erosPrezioa=" + erosPrezioa
				+ ", saltzekoPrezioa=" + saltzekoPrezioa + ", fabrikantea=" + fabrikantea + "]";
	}
	
	

}
