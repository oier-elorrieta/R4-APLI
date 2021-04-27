package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import ModeloBBDD.BBDDKonexioa;

public class metodoaProbabilitatea {

	public static void sartuDatuak(String erabiltzaile) throws ClassNotFoundException, SQLException {
		int[] insertrako = new int[23];
		Connection konekzioa = BBDDKonexioa.getConexion();
		int numTrans = metodoak.jasoTransakzioZbk();

		String niflocal = metodoakKonprobaketak.konprobatuNIF(erabiltzaile);
		insertrako = tablaposisioa();
		
		String query1 = "INSERT INTO Probabilidad VALUES ('" + (numTrans - 1) + "','" + niflocal + "','" + insertrako[0]
				+ "','" + insertrako[1] + "','" + insertrako[2] + "'" + ",'" + insertrako[3] + "','" + insertrako[4]
				+ "','" + insertrako[5] + "','" + insertrako[6] + "','" + insertrako[7] + "','" + insertrako[8] + "','"
				+ insertrako[9] + "'" + ",'" + insertrako[10] + "','" + insertrako[11] + "','" + insertrako[12] + "','"
				+ insertrako[13] + "','" + insertrako[14] + "','" + insertrako[15] + "','" + insertrako[16] + "'" + ",'"
				+ insertrako[17] + "','" + insertrako[18] + "','" + insertrako[19] + "','" + insertrako[20] + "','"
				+ insertrako[21] + "','" + insertrako[22] + "')";
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static int[] tablaposisioa() throws ClassNotFoundException, SQLException {
		@SuppressWarnings("unused")
		String prod = "";
		@SuppressWarnings("rawtypes")
		ArrayList produktuak = new ArrayList();
		int[] insertrako = new int[23];
		@SuppressWarnings("rawtypes")
		Hashtable a = new Hashtable();
		a.put("Arroz con leche", 0);
		a.put("Bollo suizo vegano", 1);
		a.put("Entrecot", 2);
		a.put("Nuggets con patata", 3);
		a.put("Lentejas", 4);
		a.put("Garbanzos", 5);
		a.put("Pure de verduras", 6);
		a.put("Croqueta de espinaca", 7);
		a.put("Carbonara vegana", 8);
		a.put("Sopa de cebolla Francesa", 9);
		a.put("Curry de anacardos", 10);
		a.put("Falafel", 11);
		a.put("Flan de caqui", 12);
		a.put("Ardoa", 13);
		a.put("Colacao", 14);
		a.put("Garagardoa", 15);
		a.put("Gilda", 16);
		a.put("Kafea", 17);
		a.put("Patata tortilla", 18);
		a.put("Sidra", 19);
		a.put("Txakoli", 20);
		a.put("Ura", 21);
		a.put("Zukua", 22);
		Connection konekzioa = BBDDKonexioa.getConexion();
		int numTrans = metodoak.jasoTransakzioZbk();
		String query1 = "SELECT NomProducto FROM tiene WHERE NumTrans= '" + (numTrans - 1) + "'";
		try {
			PreparedStatement pre;
			ResultSet resul;

			pre = konekzioa.prepareStatement(query1);
			resul = pre.executeQuery();
			while (resul.next()) {
				String nombre = resul.getString("NomProducto");
				produktuak.add(nombre);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

		System.out.println("produktuaren okurrentziak " + produktuak.size());
		for (int i = 0; i < produktuak.size(); i++) {
			a.get(produktuak.get(i));
			insertrako[(int) a.get(produktuak.get(i))] = 1;
		}
		return insertrako;
	}
}
