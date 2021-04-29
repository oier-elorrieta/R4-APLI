package Modelo;

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

	public String getProduktua() {
		return produktua;
	}

	public void setProduktua(String produktua) {
		this.produktua = produktua;
	}
}