package TestModelo;

import static org.junit.Assert.assertEquals;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;

import ModeloBBDD.BBDDKonexioa;
import ModeloBBDD.metodoakPlaterZerrendak;

public class ModeloTestPlaterZerrendak {

	@SuppressWarnings("deprecation")
	@Test
	public void platerMotak() {

		// _______________________________________________________________________________________________________________________________________________________________________________

		String esperotakoPlaterMotak[] = new String[3];

		esperotakoPlaterMotak[0] = "Vegetariano";
		esperotakoPlaterMotak[1] = "Vegano";
		esperotakoPlaterMotak[2] = "Normal";

		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(esperotakoPlaterMotak, metodoakPlaterZerrendak.platerMotak());

	}

	@SuppressWarnings("deprecation")
	@Test
	public void platerMotaArabera() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("SELECT nombre from plato where TipoDePlato = 'Vegetariano' LIMIT 1");
		String platerMotak[] = new String[10];
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				platerMotak[0] = re.getString("Nombre");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query2 = ("SELECT nombre from plato where TipoDePlato = 'Vegetariano' and nombre = '"+platerMotak[0]+"'");
		String platerMotak1[] = new String[10];
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query2);
			re = p.executeQuery();
			if (re.next()) {
				platerMotak1[0] = re.getString("Nombre");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(metodoakPlaterZerrendak.platerMotaArabera(platerMotak1[0]), metodoakPlaterZerrendak.platerMotaArabera(platerMotak[0]));
	}

	@Test
	public void jasoPlaterKodea() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String lehenengoPlaterra = null;
		String query1 = ("SELECT Nombre from plato LIMIT 1");
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				lehenengoPlaterra = re.getString("Nombre");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// _______________________________________________________________________________________________________________________________________________________________________________

		String esperotakoPlaterra = null;
		String query = ("SELECT Nombre from plato where Nombre = '" + lehenengoPlaterra + "'");
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query);
			re = p.executeQuery();
			if (re.next()) {
				esperotakoPlaterra = re.getString("Nombre");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(metodoakPlaterZerrendak.jasoPlaterKodea(esperotakoPlaterra), metodoakPlaterZerrendak.jasoPlaterKodea(lehenengoPlaterra));
	}

	@Test
	public void zenbatPlaterMotaBakoitzeko() {

		Connection konekzioa = BBDDKonexioa.getConexion();

		// _______________________________________________________________________________________________________________________________________________________________________________

		String query1 = ("SELECT count('TipoDePlato') from plato where TipoDePlato = 'Vegetariano';");
		int i = 0;
		try {
			ResultSet re;
			PreparedStatement p;
			p = konekzioa.prepareStatement(query1);
			re = p.executeQuery();
			if (re.next()) {
				i = re.getInt("count('TipoDePlato')");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// _______________________________________________________________________________________________________________________________________________________________________________

		assertEquals(metodoakPlaterZerrendak.zenbatPlaterMotaBakoitzeko("Vegetariano"), i);
	}
}