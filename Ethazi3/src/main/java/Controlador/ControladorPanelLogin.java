package Controlador;

import Modelo.Erabiltzaile;
import Modelo.Modelo;
import Vista.PanelLogin; 
import Vista.Vista;

public class ControladorPanelLogin extends ControladorNagusia{

	private Vista vista;
	private Controlador controlador;
	private PanelLogin panelLogin;
	private Modelo modelo;

	public ControladorPanelLogin(Controlador controlador, Modelo modelo, Vista vista) {
		super(controlador, modelo, vista);
		this.vista = vista;
		this.controlador = controlador; 
		this.modelo = modelo;
	}

	public void ikusiPanelLogin() {
		this.panelLogin = new PanelLogin(this);
		this.vista.ikusiPanela(this.panelLogin);
	}

	public void sakatuPanelErregistratuBotoia() {
		this.controlador.nabegatzenPanelErregistratu();
	}
	
	public String konprobatuErabiltzailea(String erabiltzailea, String pasahitza) {
		return this.modelo.konprobatuErabiltzailea(erabiltzailea, pasahitza);
	} 
	
	public Erabiltzaile sartuErabiltzaile(String erabiltzailea, String pasahitza) {
		return this.modelo.sartuErabiltzailea(erabiltzailea, pasahitza);
	}
}