package Modelo;

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
}