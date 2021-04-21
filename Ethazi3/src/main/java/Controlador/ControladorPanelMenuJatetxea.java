package Controlador;

import Vista.PanelMenuJatetxea;
import Vista.Vista;

public class ControladorPanelMenuJatetxea {

	private Vista vista;
	private Controlador controlador;
	private PanelMenuJatetxea panelMenuJatetxea;

	public ControladorPanelMenuJatetxea(Vista vista, Controlador controlador) {
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void ikusipanelMenuJatetxea() {
		this.panelMenuJatetxea = new PanelMenuJatetxea(this);
		this.vista.ikusiPanela(this.panelMenuJatetxea);
	}

	public void sakatuFakturaPanelaIkustekoBotoia() {
		this.controlador.nabegatzenPanelFaktura();
	}

	public void sakatuTicketPanelaIkustekoBotoia() {
		this.controlador.nabegatzenPanelTicket();
	}

	public void sakatuEskaeraPanelaIkustekoBotoia() {
		this.controlador.nabegatzenPanelPedidos();
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

	public void sakatuKomandaPanelaIkustekoBotoia() {
		this.controlador.nabegatzenPanelKomanda();
	}  
}