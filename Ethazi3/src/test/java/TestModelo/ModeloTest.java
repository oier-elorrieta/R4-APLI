package TestModelo;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import org.junit.Test;
import Modelo.Karritoa;
import Modelo.Produktua;
import Modelo.metodoaProbabilitatea;
import Modelo.metodoak;
import Modelo.metodoakPlaterrakEtaProduktuak;

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
	public void testpantailatuIzena() {

		Karritoa sidra = new Karritoa("Sidra", 1, 3);

		ArrayList<Karritoa> aukera = new ArrayList<Karritoa>(10);

		aukera.add(sidra);

		String esperotakoa = "Sidra";

		assertNotEquals(esperotakoa, metodoak.pantailatuProduktuaIzena(aukera));

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testpantailatuKopurua() {

		Karritoa sidra = new Karritoa("Sidra", 1, 3);

		ArrayList<Karritoa> aukera = new ArrayList<Karritoa>(10);

		aukera.add(sidra);

		int esperotakoa = 1;

		assertNotEquals(esperotakoa, metodoak.pantailatuProduktuaKopurua(aukera));

	}

	// *****************************************************************************************************************************************************************************************************

	@Test
	public void testpantailatuPrezioa() {

		Karritoa sidra = new Karritoa("Sidra", 1, 3);

		ArrayList<Karritoa> aukera = new ArrayList<Karritoa>(10);

		aukera.add(sidra);

		int esperotakoa = 3;

		assertNotEquals(esperotakoa, metodoak.pantailatuProduktuaPrezioa(aukera));

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
	public void testJasoProduktuenPrezioa() {

		double esperotakoa = 0.7 * 2; // Ardoa kostatzen du 0.7.

		assertEquals(esperotakoa, metodoak.jasoProduktuenPrezioa("Ardoa", 2), 0);
	}
	
	// *****************************************************************************************************************************************************************************************************

		@Test
		public void testtablaposisioa() throws ClassNotFoundException, SQLException {

			int[] insertrako = new int[23];

			insertrako[0]=0;
			insertrako[1]=0;
			insertrako[2]=0;
			insertrako[3]=0;
			insertrako[4]=0;
			insertrako[5]=0;
			insertrako[6]=0;
			insertrako[7]=0;
			insertrako[8]=0;
			insertrako[9]=0;
			insertrako[10]=0;
			insertrako[11]=0;
			insertrako[12]=0;
			insertrako[13]=0;
			insertrako[14]=0;
			insertrako[15]=0;
			insertrako[16]=0;
			insertrako[17]=0;
			insertrako[18]=0;
			insertrako[19]=0;
			insertrako[20]=0;
			insertrako[21]=0;
			insertrako[22]=0;
			
			int[] esperotakoa=metodoaProbabilitatea.tablaposisioa();

			assertEquals(esperotakoa, insertrako);

		}
}