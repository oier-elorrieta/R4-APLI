package Controlador;

import java.sql.SQLException; 

import Modelo.Modelo;
import Vista.PanelErregistratu; 
import Vista.Vista;

public class ControladorPanelErregistratu extends ControladorNagusia{

	private Vista vista;
	private Controlador controlador;
	private Modelo modelo;
	private PanelErregistratu panelErregistratu;

	public ControladorPanelErregistratu(Controlador controlador, Modelo modelo, Vista vista) {
		super(controlador, modelo, vista);
		this.vista = vista;
		this.controlador = controlador;    
		this.modelo = modelo;
	}

	public void ikusiPanelErregistratu() {
		this.panelErregistratu = new PanelErregistratu(this);
		this.vista.ikusiPanela(this.panelErregistratu);
	}

	public void sakatuErregistratuBotoia(String izena, String abizena, String pasahitza, String nan, String nif) throws SQLException, ClassNotFoundException {
		this.controlador.nabegatzenPanelLogin();
		this.modelo.sartuDatuak(izena,abizena,pasahitza, nan, nif);
	}

	public boolean begiratuNAN(String nan) throws SQLException {
		return this.modelo.begiratuNAN(nan);
	}

	public boolean begiratuNIF(String nif) throws SQLException {
		return this.modelo.begiratuNIF(nif);
	}

	public boolean konprobatuErabiltzaileAtributuenLuzeera(String nan, String izena, String abizena, String pasahitza, String nif) {
		return this.modelo.konprobatuErabiltzaileAtributuenLuzeera(nan, izena, abizena, pasahitza, nif);
	}
}