package Controlador;

import Modelo.Modelo;

import Vista.PanelMenuJatetxea;
import Vista.Vista;

public class ControladorPanelMenuJatetxea extends ControladorNagusia{

	private Vista vista;
	@SuppressWarnings("unused")
	private Controlador controlador;
	@SuppressWarnings("unused")
	private Modelo modelo;
	private PanelMenuJatetxea panelMenuJatetxea;

	public ControladorPanelMenuJatetxea(Controlador controlador, Modelo modelo, Vista vista) {
		super(controlador, modelo,vista);
		this.vista = vista;
		this.controlador = controlador;
		this.vista = vista;
	}

	public void ikusipanelMenuJatetxea() {
		this.panelMenuJatetxea = new PanelMenuJatetxea(this);
		this.vista.ikusiPanela(this.panelMenuJatetxea);
	}
}