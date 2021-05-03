package Controlador;

import Modelo.Modelo;
import Vista.PanelHasiera;
import Vista.Vista;

public class ControladorPanelHasiera extends ControladorNagusia{

	private Vista vista;
	@SuppressWarnings("unused")
	private Controlador controlador;
	@SuppressWarnings("unused")
	private Modelo modelo;
	private PanelHasiera panelHasiera;

	public ControladorPanelHasiera(Controlador controlador, Modelo modelo, Vista vista) {
		super(controlador, modelo, vista);
		this.vista = vista;
		this.controlador = controlador;
		this.modelo = modelo;
	}

	public void ikusiPanelHasiera() {
		this.panelHasiera = new PanelHasiera(this);
		this.vista.ikusiPanela(this.panelHasiera);
	}  
}
