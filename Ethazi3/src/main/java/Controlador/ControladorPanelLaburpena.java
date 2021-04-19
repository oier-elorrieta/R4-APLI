package Controlador;

import java.sql.SQLException;
import Modelo.Modelo;
import Vista.PanelLaburpena;
import Vista.Vista;

public class ControladorPanelLaburpena {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelLaburpena panelLaburpena; 

	public ControladorPanelLaburpena(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void ikusiPanelLaburpena() throws ClassNotFoundException, SQLException {
		this.panelLaburpena = new PanelLaburpena(this);
		this.vista.ikusiPanela(this.panelLaburpena);
	}

	public String pantailaratuIzena() {
		return this.modelo.pantailaratuIzena();
	}
	
	public String pantailaratuKopurua() {
		return this.modelo.pantailaratuKopurua();
	}
	
	public String pantailaratuPrezioa() {
		return this.modelo.pantailaratuPrezioa();
	}

	public double diruTotala() {
		return this.modelo.diruTotala();
	}

	public void sakatuPanelTabernaBotoia() {
		this.controlador.nabegatzenPanelTaberna();
		this.modelo.ezabatuProduktuenArraya();
	}

	public void sakatuPanelKafetegiaBotoia() {
		this.controlador.nabegatzenPanelKafetegia();
		this.modelo.ezabatuProduktuenArraya();
	}

	public void sakatuPanelJatetxeBotoia() {
		this.controlador.nabegatzenPanelJatetxea();
		this.modelo.ezabatuProduktuenArraya();
	}

	public String konprobatuLokala() {
		return this.modelo.konprobatuLokala();
	}

	public String konprobatuLokalarenIzena() {
		return this.modelo.konprobatuLokalarenIzena();
	}

	public void sartuTiene(int anyo, int mes, int dia) throws ClassNotFoundException, SQLException {
		this.modelo.sartuTiene(anyo, mes, dia);
	}
}
