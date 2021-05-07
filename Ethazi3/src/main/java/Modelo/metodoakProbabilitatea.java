package Modelo;

import java.util.ArrayList;


public class metodoakProbabilitatea {

	static Produktua produktuak[]= metodoakPlaterrakEtaProduktuak.elikagaiak();

	public static float[][] Probabilitatea() {
		float taula[][]=new float[metodoakPlaterrakEtaProduktuak.produktuKantitatea()][metodoakPlaterrakEtaProduktuak.produktuKantitatea()];
		float emaitza=0;
		for(int i=0;i<produktuak.length;i++) {
			for(int j=0;j<produktuak.length;j++) {
				if(i!=j ) {

					emaitza=ModeloBBDD.metodoakFuntzioakDeitu.funtzioprob(produktuak[i].getIzena(), produktuak[j].getIzena());

					taula[i][j]=emaitza;
				}
			}
		}
		for(int i=0;i<taula.length;i++) {
			for(int j=0;j<taula.length;j++) {

				System.out.print(taula[i][j]);
				System.out.print("  ");

			}
			System.out.println(" ");
		}
		
		probabilitategehiena(taula);
		return taula;
	}


	public static ArrayList<Float> probabilitategehiena(float[][] taula) {
		ArrayList<Float> numbers1Dim = new ArrayList<Float>();
		ArrayList<String> bostlehenak = new ArrayList<String>();
		for (int i = 0; i < taula.length; i++)
		{
		    for (int x = 0; x < taula[i].length; x++)
		    {
		        numbers1Dim.add(taula[i][x]);
		    }
		}
		numbers1Dim.sort(null);
		System.out.println(numbers1Dim.toString());
		System.out.println(numbers1Dim.toString().substring(1,6));
		for(int i=0;i<5;i++) {
			bostlehenak.add((String) numbers1Dim.chartAt(numbers1Dim.size()+i));
		}
		System.out.println(bostlehenak.toString());
		return numbers1Dim;
	}


}


