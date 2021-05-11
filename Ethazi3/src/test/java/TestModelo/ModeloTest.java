package TestModelo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import org.junit.Test;

import Modelo.Karritoa;
import Modelo.Produktua;
import Modelo.metodoak;
import Modelo.metodoakProbabilitatea;
import ModeloBBDD.metodoakPlaterrakEtaProduktuak;

public class ModeloTest {

	Produktua[] elikagaiak = metodoakPlaterrakEtaProduktuak.elikagaiak();

	Produktua[] platerrak = metodoakPlaterrakEtaProduktuak.platerrak();

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testSartuSalgaiak() {
		String aukera = elikagaiak[0].getIzena();

		String esperotakoa = "Ardoa";

		metodoak.sartuSalgaiak();

		assertEquals(esperotakoa, aukera);
	}

	@Test
	public void testSartuSalgaiak1() {
		String aukera = elikagaiak[2].getIzena();

		String esperotakoa = "Garagardoa";

		metodoak.sartuSalgaiak();

		assertEquals(esperotakoa, aukera);
	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testSartuPlaterrak() {
		String aukera = platerrak[0].getIzena();

		String esperotakoa = "Arroz con leche";

		metodoak.sartuPlaterrak();

		assertEquals(esperotakoa, aukera);
	}

	@Test
	public void testSartuPlaterrak1() {
		String aukera = platerrak[2].getIzena();

		String esperotakoa = "Carbonara Vegana";

		metodoak.sartuPlaterrak();

		assertEquals(esperotakoa, aukera);
	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testezabatu() {

		Karritoa sidra = new Karritoa("Sidra", 0, 3);

		ArrayList<Karritoa> aukera = new ArrayList<Karritoa>(10);

		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);
		aukera.add(sidra);

		ArrayList<Karritoa> esperotakoa = new ArrayList<Karritoa>(10);

		assertEquals(esperotakoa, metodoak.ezabatuArraya(aukera));

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testSartuProduktuaArrayan() {

		Karritoa sidra = new Karritoa("Sidra", 1, 2);

		ArrayList<Karritoa> esperotakoa1 = new ArrayList<Karritoa>(10);

		esperotakoa1.add(sidra);

		ArrayList<Karritoa> aukera1 = new ArrayList<Karritoa>(10);

		aukera1 = metodoak.sartuProduktuaArrayan("Sidra", 1, aukera1);

		Karritoa esperotakoa = esperotakoa1.get(0);

		Karritoa aukera = aukera1.get(0);

		assertEquals(aukera.getBalioa(), esperotakoa.getBalioa(), 0);
		assertEquals(aukera.getElikagaia(), esperotakoa.getElikagaia());
		assertEquals(aukera.getKopuru(), esperotakoa.getKopuru());

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testsartuDirua() {

		int esperotakoa = 6;

		assertEquals(esperotakoa, metodoak.sartuDirua("Sidra", 3), 0);

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testArgazkiaAukeratu() {

		ImageIcon esperotakoa = new ImageIcon("argazkiak/Zukua.jpg");

		assertEquals(esperotakoa.getImage(), metodoak.argazkiaAukeratu("Zukua").getImage());

	}
	
	// *****************************************************************************************************************************************************************************************************

	@Test
	public void probabilitategehiena() {

		float taula[][] = new float[2][3];
		
		taula[0][0] = (float) 8.3;
		taula[0][1] = (float) 9;
		taula[0][2] = (float) 4;
		taula[1][0] = (float) 1.3;
		taula[1][1] = (float) 3.3;
		taula[1][2] = (float) 2.3;
				
		ArrayList<Float> esperotakoa = new ArrayList<Float>();
		
		esperotakoa.add((float) 1.3);
		esperotakoa.add((float) 2.3);
		esperotakoa.add((float) 3.3);
		esperotakoa.add((float) 4);
		esperotakoa.add((float) 8.3);
		esperotakoa.add((float) 9);

		assertEquals(esperotakoa, metodoakProbabilitatea.probabilitategehiena(taula));

	}
	
	
	// *****************************************************************************************************************************************************************************************************

	@Test
	public void Probabilitatea() throws ClassNotFoundException, SQLException, IOException {
			
		ArrayList<String> esperotakoa = new ArrayList<String>();
		
		assertEquals(esperotakoa, metodoakProbabilitatea.Probabilitatea(1, elikagaiak));
		
	}
	
	// *****************************************************************************************************************************************************************************************************

	@Test
	public void ProbabilitateaLokala() throws ClassNotFoundException, SQLException, IOException {
				
		ArrayList<String> esperotakoa = new ArrayList<String>();
			
		assertEquals(esperotakoa, metodoakProbabilitatea.ProbabilitateaLokala(1, elikagaiak, "12345678R"));
			
	}
}