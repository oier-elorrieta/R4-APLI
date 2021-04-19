package Controlador;

import Modelo.Modelo;
import Vista.PanelMenuTaberna;
import Vista.Vista;

public class ControladorPanelMenuTaberna {

	private Vista vista;
	private Controlador controlador;
	private PanelMenuTaberna panelMenuTaberna;
	private Modelo modelo;

	public ControladorPanelMenuTaberna(Vista vista, Controlador controlador, Modelo modelo) {
		this.vista = vista;
		this.controlador = controlador;	
		this.modelo = modelo;
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

	public String[] top5produktuak() {
		return this.modelo.top5produktuak();
	}

	public double egunerokoIrabazia() {
		return this.modelo.egunerokoIrabazia();
	}

	public double asterokoIrabazia() {
		return this.modelo.asterokoIrabazia();
	}
}