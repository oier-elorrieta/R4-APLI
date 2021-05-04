package Modelo; 

public class Erabiltzaile {

	private String erabiltzailea;
	private String pasahitza;

	public Erabiltzaile(String erabiltzailea, String pasahitza) {
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
	}

	public String getErabiltzailea() {
		return erabiltzailea;
	}
	public void setErabiltzailea(String erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}
	public String getPasahitza() {
		return pasahitza;
	}
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}	
}