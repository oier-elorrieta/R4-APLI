package Controlador;

import java.sql.SQLException;
import Modelo.Modelo;
import Vista.PanelErregistratu; 
import Vista.Vista;

public class ControladorPanelErregistratu {
	
	private Vista vista;
	private Controlador controlador;
	private Modelo modelo;
	private PanelErregistratu panelErregistratu;

	public ControladorPanelErregistratu(Vista vista, Controlador controlador, Modelo modelo) {
		this.vista = vista;
		this.controlador = controlador;    
		this.modelo = modelo;
	}

	public void ikusiPanelErregistratu() {
		this.panelErregistratu = new PanelErregistratu(this);
		this.vista.ikusiPanela(this.panelErregistratu);
	}
	
	public void sakatuErregistratuBotoia(String izena, String abizena, String pasahitza, String nan, String nif) throws SQLException, ClassNotFoundException {
		this.controlador.nabegatzenPanelLogin();
		this.modelo.sartuDatuak(izena,abizena,pasahitza, nan, nif);
	}
	
	public void sakatuErregistratuBotoia() {
		this.controlador.nabegatzenPanelLogin();
	}
	
	public void sakatuAtzeraBotoia() {
		this.controlador.nabegatzenPanelLogin();
	}
	
	public void sakatuSarratuBotoia() {
		this.controlador.itxi();
	} 
	
	public boolean begiratuNAN(String nan) {
		return this.modelo.begiratuNAN(nan);
	}
	
	public boolean begiratuNIF(String nif) {
		return this.modelo.begiratuNIF(nif);
	}
	
	public boolean konprobatuErabiltzaileAtributuenLuzeera(String nan, String izena, String abizena, String pasahitza, String nif) {
		return this.modelo.konprobatuErabiltzaileAtributuenLuzeera(nan, izena, abizena, pasahitza, nif);
	}
}


