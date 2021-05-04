package Controlador;

import Modelo.Modelo;
import Vista.PanelMenuKafetegia;
import Vista.Vista;

public class ControladorPanelMenuKafetegia extends ControladorNagusia{

	private Vista vista; 
	@SuppressWarnings("unused")
	private Controlador controlador;
	@SuppressWarnings("unused")
	private Modelo modelo;
	private PanelMenuKafetegia panelMenuKafetegia; 

	public ControladorPanelMenuKafetegia(Controlador controlador, Modelo modelo, Vista vista) {
		super(controlador, modelo, vista);
		this.vista = vista;
		this.controlador = controlador;
		this.vista = vista;
	}

	public void ikusipanelMenuKafetegia() {
		this.panelMenuKafetegia = new PanelMenuKafetegia(this);
		this.vista.ikusiPanela(this.panelMenuKafetegia);
	}
}