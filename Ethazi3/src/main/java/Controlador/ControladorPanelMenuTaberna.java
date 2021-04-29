package Controlador;

import Vista.PanelMenuTaberna;
import Vista.Vista;

public class ControladorPanelMenuTaberna {

	private Vista vista;
	private Controlador controlador;
	private PanelMenuTaberna panelMenuTaberna;

	public ControladorPanelMenuTaberna(Vista vista, Controlador controlador) {
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void ikusipanelMenuTaberna() {
		this.panelMenuTaberna = new PanelMenuTaberna(this);
		this.vista.ikusiPanela(this.panelMenuTaberna);
	}

	public void sakatuFakturaPanelaIkustekoBotoia() {
		ControladorNagusia.sakatuFakturaPanelaIkustekoBotoia(controlador);
	}

	public void sakatuTicketPanelaIkustekoBotoia() {
		ControladorNagusia.sakatuTicketPanelaIkustekoBotoia(controlador);
	} 

	public void sakatuHasieraBotoia() {
		ControladorNagusia.sakatuHasieraBotoia(controlador);
	}

	public void sakatuHornikuntzaBotoia() {
		ControladorNagusia.sakatuHornikuntzaBotoia(controlador);
	}

	public void sakatuAtzeraBotoia() {
		ControladorNagusia.sakatuAtzeraBotoia(controlador);
	} 
}