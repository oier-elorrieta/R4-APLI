package Controlador;

import Modelo.Modelo;
import Vista.PanelMenuTaberna;
import Vista.Vista;

public class ControladorPanelMenuTaberna extends ControladorNagusia{

	private Vista vista;

	@SuppressWarnings("unused")
	private Controlador controlador;
	@SuppressWarnings("unused")
	private Modelo modelo;
	private PanelMenuTaberna panelMenuTaberna;

	public ControladorPanelMenuTaberna(Controlador controlador, Modelo modelo, Vista vista) {
		super(controlador, modelo, vista);
		this.vista = vista;
		this.controlador = controlador;
		this.vista = vista;
	}

	public void ikusipanelMenuTaberna() {
		this.panelMenuTaberna = new PanelMenuTaberna(this);
		this.vista.ikusiPanela(this.panelMenuTaberna);
	}
}