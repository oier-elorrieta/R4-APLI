package Controlador;

import Vista.PanelHasiera;
import Vista.Vista;

public class ControladorPanelHasiera {

	private Vista vista;
	private Controlador controlador;
	private PanelHasiera panelHasiera;

	public ControladorPanelHasiera(Vista vista, Controlador controlador) {
		this.vista = vista;
		this.controlador = controlador;
	}

	public void ikusiPanelHasiera() {
		this.panelHasiera = new PanelHasiera(this);
		this.vista.ikusiPanela(this.panelHasiera);
	}

	public void sakatuPanelLogin() {
		this.controlador.nabegatzenPanelLogin();
	}

	public void itxi() {
		this.controlador.itxi();
	}
}
