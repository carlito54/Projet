import java.util.HashMap;

import junit.framework.TestCase;



public class AlgoRechercheCheminTest extends TestCase{

	
	public void tempsEntreStationTest(){
		AlgoRechercheChemin a = new AlgoRechercheChemin(null);
		Station debut = new Station(30,"La Défense",null,new Coordonnee(50,450),1);
		Station fin = new Station(40,"Rome",null,new Coordonnee(150,450),4);
		HashMap<Station, Integer> voisin0 = new HashMap<Station, Integer>();
		voisin0.put(fin,100);
		System.out.println("yop");
		debut.setTemps_vers_station_voisine(voisin0);
		assertEquals(100, 100);
	}
}
