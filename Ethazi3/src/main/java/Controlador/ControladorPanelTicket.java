package Controlador;

import java.sql.SQLException;
import Modelo.Modelo;
import Vista.PanelTicket;
import Vista.Vista;

public class ControladorPanelTicket extends ControladorNagusia{

	private Modelo modelo;
	private Vista vista; 
	@SuppressWarnings("unused")
	private Controlador controlador;
	private PanelTicket panelTicket; 

	public ControladorPanelTicket(Controlador controlador, Modelo modelo, Vista vista) {
		super(controlador, modelo, vista);
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;
	}

	public void ikusiPanelTicket() {
		this.panelTicket = new PanelTicket(this);
		this.vista.ikusiPanela(panelTicket);
	}

	public void gordeTicket() throws ClassNotFoundException, SQLException {
		this.modelo.sartuTicket();
	}
}