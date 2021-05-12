package Controlador;

import java.sql.SQLException;
import Modelo.Modelo;
import Vista.PanelHornikuntza; 
import Vista.Vista;

public class ControladorPanelHornikuntza extends ControladorNagusia{
	
	private Modelo modelo;
	private Vista vista;
	@SuppressWarnings("unused")
	private Controlador controlador;
	private PanelHornikuntza PanelHornikuntza;

	public ControladorPanelHornikuntza(Controlador controlador, Vista vista, Modelo modelo) {
		super(controlador, modelo, vista);
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}

	public void ikusiPanelHornikuntza() {
		try {
			this.PanelHornikuntza = new PanelHornikuntza(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.vista.ikusiPanela(this.PanelHornikuntza);
	}
	
	public void sartuHornikuntza(String produktua,String nif, int kantitatea) throws ClassNotFoundException, SQLException {
		this.modelo.sartuHornikuntza(produktua, nif, kantitatea);
	}
}
