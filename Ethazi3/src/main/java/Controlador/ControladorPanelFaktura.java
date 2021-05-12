package Controlador;

import java.sql.SQLException; 
import Modelo.Modelo;
import Vista.PanelFaktura; 
import Vista.Vista;

public class ControladorPanelFaktura extends ControladorNagusia {

	private Modelo modelo;
	private Vista vista;
	@SuppressWarnings("unused")
	private Controlador controlador;
	private PanelFaktura panelFaktura;

	public ControladorPanelFaktura(Controlador controlador, Modelo modelo, Vista vista) {
		super(controlador, modelo, vista);
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;
	}

	public void ikusiPanelFaktura() {
		try {
			this.panelFaktura = new PanelFaktura(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.vista.ikusiPanela(this.panelFaktura);
	}

	public void sartuFaktura(String izena, String abizena) throws ClassNotFoundException, SQLException {
		this.modelo.sartuFaktura(izena, abizena);
	} 
}