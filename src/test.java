import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;



public class test{


	public static void main(String[] args) {
		
	
		
			final Station[] lestation = new Station[15];
		
		/** Cr�ation des stations et des lignes voisines de chque station **/
		lestation[0] = new Station(30,"La D�fense",null,new Coordonnee(50,450),1);
		lestation[1] = new Station(40,"Rome",null,new Coordonnee(150,450),4);
		lestation[2] = new Station(25,"Neuilly",null,new Coordonnee(325,450),1);
		lestation[3] = new Station(15,"Sablons",null,new Coordonnee(575,450),1);
		lestation[4] = new Station(45,"Maillot",null,new Coordonnee(690,450),1);
		lestation[5] = new Station(20,"Argentine",null,new Coordonnee(777,450),6);
		lestation[6] = new Station(10,"Termes",null,new Coordonnee(50,560),2);
		lestation[7] = new Station(60,"Courcelles",null,new Coordonnee(250,370),2);
		lestation[8] = new Station(35,"Monceau",null,new Coordonnee(490,280),5);
		lestation[9] = new Station(50,"Villiers",null,new Coordonnee(620,160),2);
		lestation[10] = new Station(15,"Blanche",null,new Coordonnee(730,90),2);
		lestation[11] = new Station(55,"Pigalle",null,new Coordonnee(50,80),3);
		lestation[12] = new Station(30,"Anvers",null,new Coordonnee(170,150),3);
		lestation[13] = new Station(25,"Stalingrad",null,new Coordonnee(350,220),3);
		lestation[14] = new Station(45,"Gare",null,new Coordonnee(650,370),3);
		
		HashMap<Station, Integer> voisin0 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin1 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin2 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin3 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin4 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin5 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin6 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin7 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin8 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin9 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin10 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin11 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin12 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin13 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin14 = new HashMap<Station, Integer>();
		
		voisin0.put(lestation[1],100);
		lestation[0].setTemps_vers_station_voisine(voisin0);
		
		voisin1.put(lestation[2], 130);
		voisin1.put(lestation[0], 130);
		voisin1.put(lestation[6], 220);
		voisin1.put(lestation[7], 125);
		lestation[1].setTemps_vers_station_voisine(voisin1);

		voisin2.put(lestation[3], 300);
		voisin2.put(lestation[1], 287);
		lestation[2].setTemps_vers_station_voisine(voisin2);
		
		voisin3.put(lestation[2], 222);
		voisin3.put(lestation[4], 111);
		lestation[3].setTemps_vers_station_voisine(voisin3);
		
		voisin4.put(lestation[3], 90);
		voisin4.put(lestation[5], 199);
		lestation[4].setTemps_vers_station_voisine(voisin4);
		
		voisin5.put(lestation[4], 210);
		voisin5.put(lestation[14], 105);
		lestation[5].setTemps_vers_station_voisine(voisin5);
		
		voisin6.put(lestation[1], 80);
		lestation[6].setTemps_vers_station_voisine(voisin6);
		
		voisin7.put(lestation[1], 95);
		voisin7.put(lestation[8], 155);
		lestation[7].setTemps_vers_station_voisine(voisin7);
		
		voisin8.put(lestation[7], 275);
		voisin8.put(lestation[9], 305);
		voisin8.put(lestation[13], 75);
		voisin8.put(lestation[14], 110);
		lestation[8].setTemps_vers_station_voisine(voisin8);
		
		voisin9.put(lestation[8], 150);
		voisin9.put(lestation[10], 225);
		lestation[9].setTemps_vers_station_voisine(voisin9);
		
		voisin10.put(lestation[9], 135);
		lestation[10].setTemps_vers_station_voisine(voisin10);
		
		voisin11.put(lestation[12], 80);
		lestation[11].setTemps_vers_station_voisine(voisin11);
		
		voisin12.put(lestation[11], 140);
		voisin12.put(lestation[13], 220);
		lestation[12].setTemps_vers_station_voisine(voisin12);
		
		voisin13.put(lestation[12], 160);
		voisin13.put(lestation[8], 360);
		lestation[13].setTemps_vers_station_voisine(voisin13);
		
		voisin14.put(lestation[5], 230);
		voisin14.put(lestation[8], 310);
		lestation[14].setTemps_vers_station_voisine(voisin14);

		
	
		

		ArrayList<Station> chemin = new ArrayList<Station>();
		ArrayList<ArrayList<Station>> solutions = new ArrayList<ArrayList<Station>>();
		final AlgoRechercheChemin algo= new AlgoRechercheChemin(lestation[12]);
		algo.Tous_Les_Chemins(chemin,solutions,lestation[12],lestation[11]);
		chemin.add(lestation[12]);
		chemin.add(lestation[11]);

		System.out.println("changement "+algo.nbLignes(chemin));
		for (ArrayList<Station> a : solutions) {
			System.out.println("SOLUTION : ");
			for (Station s : a) {
				System.out.println(s.getNom());
			}	
		}
		
		
		
	}
	
}