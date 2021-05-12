package Controlador;

import java.sql.SQLException; 
import Modelo.Modelo;
import Vista.PanelEskaera;
import Vista.Vista;

public class ControladorPanelEskaera extends ControladorNagusia{

	private Modelo modelo;
	private Vista vista; 
	@SuppressWarnings("unused")
	private Controlador controlador;
	private PanelEskaera panelPedidos;

	public ControladorPanelEskaera(Controlador controlador,Modelo modelo, Vista vista) {
		super(controlador, modelo, vista);
		this.modelo = modelo;
		this.vista = vista; 
		this.controlador = controlador;
	}

	public void ikusiPanelPedidos() {
		try {
			this.panelPedidos = new PanelEskaera(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.vista.ikusiPanela(this.panelPedidos);
	}

	public void gordeEskaera(String helbidea) throws ClassNotFoundException, SQLException {
		this.modelo.sartuEskaera(helbidea);
	}
}