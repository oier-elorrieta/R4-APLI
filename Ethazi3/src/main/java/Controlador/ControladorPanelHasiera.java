package Controlador;

import java.io.IOException;
import java.sql.SQLException; 
import Modelo.Modelo;
import Vista.PanelHasiera;
import Vista.Vista;

public class ControladorPanelHasiera extends ControladorNagusia{

	private Vista vista;
	@SuppressWarnings("unused")
	private Controlador controlador; 
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

	public void sartuDatuakFitxategian(int zenbaki) throws ClassNotFoundException, IOException, SQLException {
		this.modelo.sartuDatuakFitxategian(zenbaki);
	}
}