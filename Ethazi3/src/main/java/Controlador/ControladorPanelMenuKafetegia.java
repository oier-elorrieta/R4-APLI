package Controlador;

import Vista.PanelMenuKafetegia;
import Vista.Vista;

public class ControladorPanelMenuKafetegia implements ControladorNagusia{

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
		ControladorNagusia.sakatuFakturaPanelaIkustekoBotoia(controlador);
	}

	public void sakatuTicketPanelaIkustekoBotoia() {
		ControladorNagusia.sakatuTicketPanelaIkustekoBotoia(controlador);
	}

	public void sakatuEskaeraPanelaIkustekoBotoia() {
		ControladorNagusia.sakatuEskaeraPanelaIkustekoBotoia(controlador);
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