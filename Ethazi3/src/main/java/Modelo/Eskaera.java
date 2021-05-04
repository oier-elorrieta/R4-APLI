package Modelo; 

public class Eskaera extends Operaciones{

	private String helbidea;

	public Eskaera(int transferentziaZenbakia, double totala, String nIF, String helbidea) {
		super(transferentziaZenbakia, totala, nIF, 'P');
		this.helbidea = helbidea;
	}

	public String getHelbidea() {
		return helbidea;
	}

	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}
}