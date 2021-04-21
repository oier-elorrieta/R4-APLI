package Controlador;

import Vista.PanelMenuKafetegia;
import Vista.Vista;

public class ControladorPanelMenuKafetegia {

	private Vista vista;
	private Controlador controlador;
	private PanelMenuKafetegia panelMenuKafetegia; 

	public ControladorPanelMenuKafetegia(Vista vista, Controlador controlador) {
		this.vista = vista;
		this.controlador = controlador;	 
	}

	public void ikusipanelMenuKafetegia() {
		this.panelMenuKafetegia = new PanelMenuKafetegia(this);
		this.vista.ikusiPanela(this.panelMenuKafetegia);
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
}