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
		this.controlador.nabegatzenPanelFaktura();
	}

	public void sakatuTicketPanelaIkustekoBotoia() {
		this.controlador.nabegatzenPanelTicket();
	}

	public void sakatuHasieraBotoia() {
		this.controlador.nabegatzenPanelLogin();
	}

	public void sakatuHornikuntzaBotoia() {
		this.controlador.nabegatzenPanelHornikuntza();
	}

	public void sakatuAtzeraBotoia() {
		this.controlador.itxi();
	}
}