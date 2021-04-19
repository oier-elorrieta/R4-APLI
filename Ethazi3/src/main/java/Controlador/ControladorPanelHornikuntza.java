package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import Modelo.Karritoa;
import Modelo.Modelo;
import Vista.PanelHornikuntza; 
import Vista.Vista;

public class ControladorPanelHornikuntza {
	
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelHornikuntza PanelHornikuntza;

	public ControladorPanelHornikuntza( Vista vista, Controlador controlador, Modelo modelo) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void ikusiPanelHornikuntza() {
		this.PanelHornikuntza = new PanelHornikuntza(this);
		this.vista.ikusiPanela(this.PanelHornikuntza);
	}
	
	public String[] ComboBoxaSakatu() {
		return this.modelo.produktuakJaso();
	}
	
	public ArrayList<Karritoa> sartu(String elikagaia,int kopuru) {
		return this.modelo.sartu(elikagaia, kopuru); 
	} 
	
	public void sakatuPanelTabernaBotoia() {
		this.controlador.nabegatzenPanelTaberna();
	}

	public void sakatuPanelKafetegiaBotoia() {
		this.controlador.nabegatzenPanelKafetegia();
	}

	public void sakatuPanelJatetxeBotoia() {
		this.controlador.nabegatzenPanelJatetxea();
	}
	
	public String konprobatuLokala() {
		return this.modelo.konprobatuLokala();
	} 
	
	public String konprobatuNIF() {
		return this.modelo.konprobatuNIF();
	}
	
	public void sakatuAtzeraBotoia() {
		this.controlador.itxi();
	}
	
	public void sartuHornikuntza(String produktua,int anyo, int mes, int dia, String nif, int kantitatea) throws ClassNotFoundException, SQLException {
		this.modelo.sartuHornikuntza(produktua, anyo, mes, dia, nif, kantitatea);
	}
}
