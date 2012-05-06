import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;


public class AlgoRechercheCheminTest {

	@Test
	public void testTous_Les_Chemins() {
		Station[] lestation = new Station[3];		
		lestation[0] = new Station(20,"Rome",null,new Coordonnee(150,450),1);
		lestation[1] = new Station(20,"Courcelles",null,new Coordonnee(250,370),1);
		lestation[2] = new Station(20,"Neuilly",null,new Coordonnee(325,450),1);
		
		HashMap<Station, Integer> voisin0 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin1 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin2 = new HashMap<Station, Integer>();
		
		voisin0.put(lestation[1],100);
		voisin0.put(lestation[2],10);
		lestation[0].setTemps_vers_station_voisine(voisin0);
		
		voisin1.put(lestation[2], 100);
		voisin1.put(lestation[0], 100);
		lestation[1].setTemps_vers_station_voisine(voisin1);

		voisin2.put(lestation[0], 100);
		voisin2.put(lestation[1], 100);
		lestation[2].setTemps_vers_station_voisine(voisin2);
		
		ArrayList<Station> chemin = new ArrayList<Station>();
		ArrayList<ArrayList<Station>> solutions = new ArrayList<ArrayList<Station>>();
		AlgoRechercheChemin algo= new AlgoRechercheChemin(lestation[0]);
		algo.Tous_Les_Chemins(chemin, solutions,lestation[0],lestation[2]);
		ArrayList<ArrayList<Station>> test = new ArrayList<ArrayList<Station>>();
		ArrayList<Station> chemin1 = new ArrayList<Station>();
		chemin1.add(lestation[0]);
		chemin1.add(lestation[1]);
		chemin1.add(lestation[2]);
		ArrayList<Station> chemin2 = new ArrayList<Station>();
		chemin2.add(lestation[0]);
		chemin2.add(lestation[2]);
		test.add(chemin2);
		test.add(chemin1);		
		assertEquals(test, solutions);		
	}

	@Test
	public void testCheminPlusRapide() {

		Station[] lestation = new Station[3];		
		lestation[0] = new Station(20,"Rome",null,new Coordonnee(150,450),1);
		lestation[1] = new Station(20,"Courcelles",null,new Coordonnee(250,370),1);
		lestation[2] = new Station(20,"Neuilly",null,new Coordonnee(325,450),1);
		
		HashMap<Station, Integer> voisin0 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin1 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin2 = new HashMap<Station, Integer>();
		
		voisin0.put(lestation[1],100);
		voisin0.put(lestation[2],10);
		lestation[0].setTemps_vers_station_voisine(voisin0);
		
		voisin1.put(lestation[2], 100);
		voisin1.put(lestation[0], 100);
		lestation[1].setTemps_vers_station_voisine(voisin1);

		voisin2.put(lestation[0], 100);
		voisin2.put(lestation[1], 100);
		lestation[2].setTemps_vers_station_voisine(voisin2);
		
		ArrayList<Station> chemin = new ArrayList<Station>();
		ArrayList<ArrayList<Station>> solutions = new ArrayList<ArrayList<Station>>();
		AlgoRechercheChemin algo= new AlgoRechercheChemin(lestation[0]);
		algo.Tous_Les_Chemins(chemin, solutions,lestation[0],lestation[2]);
		ArrayList<Station> chemin2 = new ArrayList<Station>();
		chemin2.add(lestation[0]);
		chemin2.add(lestation[2]);	
		assertEquals(chemin2, algo.cheminPlusRapide(solutions));	
	}

	@Test
	public void testTempsChemin() {

		Station[] lestation = new Station[3];		
		lestation[0] = new Station(30,"Rome",null,new Coordonnee(150,450),1);
		lestation[1] = new Station(40,"Courcelles",null,new Coordonnee(250,370),1);
		lestation[2] = new Station(50,"Neuilly",null,new Coordonnee(325,450),1);
		
		HashMap<Station, Integer> voisin0 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin1 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin2 = new HashMap<Station, Integer>();
		
		voisin0.put(lestation[1],120);
		lestation[0].setTemps_vers_station_voisine(voisin0);
		
		voisin1.put(lestation[2], 100);
		lestation[1].setTemps_vers_station_voisine(voisin1);
		
		ArrayList<Station> chemin = new ArrayList<Station>();
		chemin.add(lestation[0]);
		chemin.add(lestation[1]);
		chemin.add(lestation[2]);	
		AlgoRechercheChemin algo= new AlgoRechercheChemin(null);
		assertEquals(290, algo.tempsChemin(chemin));
	}

	@Test
	public void testTempsEntreStation() {
		AlgoRechercheChemin a = new AlgoRechercheChemin(null);
		Station debut = new Station(30,"La Défense",null,new Coordonnee(50,450),1);
		Station fin = new Station(40,"Rome",null,new Coordonnee(150,450),4);
		HashMap<Station, Integer> voisin0 = new HashMap<Station, Integer>();
		voisin0.put(fin,100);
		debut.setTemps_vers_station_voisine(voisin0);
		assertEquals(100, a.tempsEntreStation(debut, fin));
	}
	
	@Test
	public void aVoieEnPanne(){
		
		Station[] lestation = new Station[3];		
		lestation[0] = new Station(30,"Rome",null,new Coordonnee(150,450),1);
		lestation[1] = new Station(40,"Courcelles",null,new Coordonnee(250,370),1);
		lestation[2] = new Station(50,"Neuilly",null,new Coordonnee(325,450),1);
		
		HashMap<Station, Integer> voisin0 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin1 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin2 = new HashMap<Station, Integer>();
		
		voisin0.put(lestation[1],120);
		lestation[0].setTemps_vers_station_voisine(voisin0);
		
		voisin1.put(lestation[2], -1);
		lestation[1].setTemps_vers_station_voisine(voisin1);
		
		ArrayList<Station> chemin = new ArrayList<Station>();
		chemin.add(lestation[0]);
		chemin.add(lestation[1]);
		chemin.add(lestation[2]);	
		AlgoRechercheChemin a = new AlgoRechercheChemin(null);
		assertEquals(true, a.aVoieEnPanne(chemin));
	}

}
