package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import ModeloBBDD.BBDDKonexioa;

public class metodoaProbabilitatea {

	public static void sartuDatuak(String erabiltzaile, String nomProduktua) throws ClassNotFoundException, SQLException {
		Connection konekzioa = BBDDKonexioa.getConexion();
		int numTrans = metodoak.jasoTransakzioZbk();  
		String niflocal = metodoakKonprobaketak.konprobatuNIF(erabiltzaile);
		String query1 = "INSERT INTO Probabilidad VALUES ('"+nomProduktua+"')";
		String query2 = "INSERT INTO Hacen VALUES ("+(numTrans-1)+", '"+niflocal+"', '"+nomProduktua+"')";
		try {
			Statement s;
			s = konekzioa.createStatement();
			s.executeUpdate(query1);
			Statement s1;
			s1 = konekzioa.createStatement();
			s1.executeUpdate(query2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}