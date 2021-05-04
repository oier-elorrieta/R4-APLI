package Modelo; 

public class Faktura extends Operaciones{

	private String izena_hartzaile;
	private String abizena_hartzaile;

	public Faktura(int transferentziaZenbakia, double totala, String nIF, String izena_hartzaile, String abizena_hartzaile) {
		super(transferentziaZenbakia, totala, nIF, 'F');
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
}