package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import Modelo.Karritoa;
import Modelo.Modelo;
import Vista.PanelEskaera;
import Vista.Vista;

public class ControladorPanelEskaera implements ControladorNagusia{

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelEskaera panelPedidos;

	public ControladorPanelEskaera(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;
	}

	public void ikusiPanelPedidos() {
		this.panelPedidos = new PanelEskaera(this);
		this.vista.ikusiPanela(this.panelPedidos);
	}
	
	public void sakatuAtzeraBotoia() {
		ControladorNagusia.sakatuAtzeraBotoia(controlador, modelo);
	}

	public String[] ComboBoxaSakatu() {
		return ControladorNagusia.ComboBoxaSakatu(modelo);
	}

	public ArrayList<Karritoa> sartu(String elikagaia,int kopuru) {
		return ControladorNagusia.sartu(elikagaia, kopuru, modelo);
	}  

	public ImageIcon argazkiaAukeratu(String aukera) {
		return ControladorNagusia.argazkiaAukeratu(aukera, modelo);
	}

	public void gordeEskaera(String helbidea) throws ClassNotFoundException, SQLException {
		this.modelo.sartuEskaera(helbidea);
	}
	
	public int jasoTransakzioZbk() throws ClassNotFoundException, SQLException {
		return ControladorNagusia.jasoTransakzioZbk(modelo);
	}

	public void sakatuPanelTabernaBotoia() {
		ControladorNagusia.sakatuPanelTabernaBotoia(controlador, modelo);
	}

	public void sakatuPanelKafetegiaBotoia() {
		ControladorNagusia.sakatuPanelKafetegiaBotoia(controlador, modelo);
	}

	public void sakatuPanelJatetxeBotoia() {
		ControladorNagusia.sakatuPanelJatetxeBotoia(controlador, modelo);
	}

	public String konprobatuLokala() {
		return ControladorNagusia.konprobatuLokala(modelo);
	}
	
	public String konprobatuLokalarenIzena() {
		return ControladorNagusia.konprobatuLokalarenIzena(modelo);
	}
	
	public String konprobatuNIF() {
		return ControladorNagusia.konprobatuNIF(modelo);
	} 

	public int begiratuStock(String produktua, String nif) {
		return ControladorNagusia.begiratuStock(produktua, nif, modelo);
	}
	
	public void sartuTiene() {
		ControladorNagusia.sartuTiene(modelo);
	}
}