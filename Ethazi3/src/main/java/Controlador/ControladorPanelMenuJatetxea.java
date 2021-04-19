package Controlador;

import Modelo.Modelo;
import Vista.PanelMenuJatetxea;
import Vista.Vista;

public class ControladorPanelMenuJatetxea {

	private Vista vista;
	private Controlador controlador;
	private PanelMenuJatetxea panelMenuJatetxea;
	private Modelo modelo;

	public ControladorPanelMenuJatetxea(Vista vista, Controlador controlador, Modelo modelo) {
		this.vista = vista;
		this.controlador = controlador;	
		this.modelo = modelo;
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