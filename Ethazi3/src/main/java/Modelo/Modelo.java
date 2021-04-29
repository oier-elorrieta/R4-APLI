package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import ModeloBBDD.metodoJasoTransakzioZbk;
import ModeloBBDD.metodoakFuntzioakDeitu;
import ModeloBBDD.metodoakIncluye;
import ModeloBBDD.metodoakKonprobaketak;
import ModeloBBDD.metodoakOfrece;
import ModeloBBDD.metodoakPlaterZerrendak; 

public class Modelo {

	private ArrayList<Karritoa> karroa = new ArrayList<Karritoa>();

	private Erabiltzaile usuarioa = new Erabiltzaile(null, null);													

	// *****************************************************************************************************************************************************************

	public boolean konprobatuErabiltzaileAtributuenLuzeera(String nan, String izena, String abizena, String pasahitza, String nif) {
		return ModeloBBDD.metodoakKonprobaketak.konprobatuErabiltzaileAtributuenLuzeera(nan, izena, abizena, pasahitza, nif);
	}

	public String[] produktuakJaso() {
		return metodoak.sartuSalgaiak();
	}

	public ArrayList<Karritoa> sartu(String elikagaia, int kopuru) {
		return metodoak.sartuProduktuaArrayan(elikagaia, kopuru, karroa);
	}

	public String pantailaratuIzena() {
		return metodoak.pantailatuProduktuaIzena(karroa);
	}

	public String pantailaratuKopurua() {
		return metodoak.pantailatuProduktuaKopurua(karroa);
	}

	public String pantailaratuPrezioa() {
		return metodoak.pantailatuProduktuaPrezioa(karroa);
	}

	public double diruTotala() {
		return metodoakFuntzioakDeitu.dirutotala();
	}

	public ArrayList<Karritoa> ezabatuProduktuenArraya() {
		return metodoak.ezabatuArraya(karroa);
	}

	public ImageIcon argazkiaAukeratu(String aukera) {
		return metodoak.argazkiaAukeratu(aukera);
	}

	// *****************************************************************************************************************************************************************

	public String konprobatuErabiltzailea(String erabiltzailea, String pasahitza) {
		return metodoakKonprobaketak.konprobatuErabiltzailea(erabiltzailea, pasahitza);
	}

	public String konprobatuNIF () {
		return metodoakKonprobaketak.konprobatuNIF(usuarioa.getErabiltzailea());
	}

	public String konprobatuLokala() {
		return metodoakKonprobaketak.konprobatuLokala(usuarioa.getErabiltzailea());
	}

	public String konprobatuLokalarenIzena() {
		return metodoakKonprobaketak.konprobatuLokalarenIzena(konprobatuNIF());
	}

	public boolean begiratuNAN(String nan) {
		return metodoakKonprobaketak.begiratuNAN(nan);
	}

	public boolean begiratuNIF(String nif) {
		return metodoakKonprobaketak.begiratuNIF(nif);
	}

	public int begiratuStock(String produktua,String nif) {
		return metodoakKonprobaketak.begiratuStock(produktua, nif);
	}

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

	public String[] platerrakJaso() {
		return metodoak.sartuPlaterrak();
	}

	public String[] platerMotak(){
		return metodoakPlaterZerrendak.platerMotak();
	}

	public String[] platerMota(String platerMota, String tipoa){
		return metodoakPlaterZerrendak.platerMota(platerMota, tipoa);
	}

	public int platerKodea(String platerra){
		return metodoakPlaterZerrendak.jasoPlaterKodea(platerra);
	}

	public String[] platerMotaArabera(String platerMota) {
		return metodoakPlaterZerrendak.platerMotaArabera(platerMota);
	}

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

	public int jasoTransakzioZbk() throws ClassNotFoundException, SQLException {
		return ModeloBBDD.metodoJasoTransakzioZbk.jasoTransakzioZbk();
	}

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

	public Erabiltzaile sartuErabiltzailea(String erabiltzailea, String pasahitza, Erabiltzaile usuarioa) {
		usuarioa.setErabiltzailea(erabiltzailea);
		usuarioa.setPasahitza(pasahitza);
		return usuarioa;
	}	
	
	public void sartuDatuak(String izena, String abizena, String pasahitza, String NAN, String nif) {
		ModeloBBDD.metodoakErabiltzaile.sartuDatuak(izena, abizena, pasahitza, NAN, nif);
	}

	public Erabiltzaile sartuErabiltzailea(String erabiltzailea, String pasahitza) {
		return sartuErabiltzailea(erabiltzailea, pasahitza,usuarioa);
	}

	public void sartuTicket() throws ClassNotFoundException, SQLException {
		Ticket t1 = new Ticket(metodoJasoTransakzioZbk.jasoTransakzioZbk(), 0,konprobatuNIF());
		ModeloBBDD.metodoakOperaciones.sartuOperaciones(t1.getTransferentziaZenbakia(), t1.getTotala(), t1.getNIF(), t1.getOperazioMota());
	}

	public void sartuEskaera(String helbidea) throws ClassNotFoundException, SQLException {
		Eskaera es1 = new Eskaera(ModeloBBDD.metodoJasoTransakzioZbk.jasoTransakzioZbk(), 0, konprobatuNIF(), helbidea);
		ModeloBBDD.metodoakOperaciones.sartuOperaciones(es1.getTransferentziaZenbakia(), es1.getTotala(), es1.getNIF(), es1.getOperazioMota());
		ModeloBBDD.metodoakEskaera.sartuEskaera(es1.getTransferentziaZenbakia(), es1.getHelbidea());
	}

	public void sartuFaktura(String izena, String abizena) throws ClassNotFoundException, SQLException {
		Faktura f1 = new Faktura(ModeloBBDD.metodoJasoTransakzioZbk.jasoTransakzioZbk(), 0, konprobatuNIF(), izena, abizena);
		ModeloBBDD.metodoakOperaciones.sartuOperaciones(f1.getTransferentziaZenbakia(), f1.getTotala(), f1.getNIF(), f1.getOperazioMota());
		ModeloBBDD.metodoakFaktura.sartuFaktura(f1.getTransferentziaZenbakia(), f1.getNIF(), f1.getIzena_hartzaile(), f1.getAbizena_hartzaile());
	} 

	public void sartuHornikuntza(String produktua, String nif, int kantitatea) throws ClassNotFoundException, SQLException { 
		Hornikuntza h1 = new Hornikuntza(ModeloBBDD.metodoJasoTransakzioZbk.jasoTransakzioZbk(), 0, produktua, nif, kantitatea);
		ModeloBBDD.metodoakOperaciones.sartuOperaciones(h1.getTransferentziaZenbakia(), h1.getTotala(), h1.getNIF(), h1.getOperazioMota());
		ModeloBBDD.metodoakHornikuntza.sartuHornikuntza(h1.getTransferentziaZenbakia(), h1.getProduktua(), h1.getProduktu_kantitatea(), h1.getTotala(), h1.getOperazioMota());
		ModeloBBDD.metodoakHornikuntza.stockGehitu(h1.getProduktua(), h1.getProduktu_kantitatea(), h1.getNIF());
	}

	public void sartuTiene()  {
		try {
			metodoakTiene.sartuTiene(karroa, jasoTransakzioZbk(), usuarioa.getErabiltzailea()); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void sartuKomanda() throws ClassNotFoundException, SQLException  {
		Komanda k1 = new Komanda(0, 0, null); 
		k1.setNIF(konprobatuNIF());
		k1.setTotala(diruTotala());
		ModeloBBDD.metodoakKomanda.sartuKomanda(k1.getNIF(), k1.getTotala());
	} 

	public void incluye(int platerKodea, int kantitatea) throws ClassNotFoundException, SQLException{
		metodoakIncluye.incluye(platerKodea, kantitatea, diruTotala(), konprobatuNIF());
	}

	public Komanda hasieratuOperaciones() throws ClassNotFoundException, SQLException {
		Komanda k1 = new Komanda(ModeloBBDD.metodoJasoTransakzioZbk.jasoTransakzioZbk(), 0, null);
		ModeloBBDD.metodoakKomanda.hasieratuOperaciones(k1.getTransferentziaZenbakia());
		return k1;
	}

	public void ofrece() {
		metodoakOfrece.localOfrece(konprobatuNIF());
	}

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

	public void ezabatuKomanda() throws ClassNotFoundException, SQLException {
		Komanda k1 = hasieratuOperaciones();
		ModeloBBDD.metodoakKomanda.ezabatuKomanda(k1.getTransferentziaZenbakia());
	}
}