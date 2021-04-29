package Controlador;

import Vista.PanelMenuJatetxea;
import Vista.Vista;

public class ControladorPanelMenuJatetxea implements ControladorNagusia{

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

	public void sakatuKomandaPanelaIkustekoBotoia() {
		ControladorNagusia.sakatuKomandaPanelaIkustekoBotoia(controlador);
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