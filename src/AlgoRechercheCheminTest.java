import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;


public class AlgoRechercheCheminTest {

	@Test
	public void testAlgoRechercheChemin() {
	}

	@Test
	public void testTous_Les_Chemins() {
	}

	@Test
	public void testCheminPlusRapide() {
	}

	@Test
	public void testTempsChemin() {
	}

	@Test
	public void testTempsEntreStation() {
		AlgoRechercheChemin a = new AlgoRechercheChemin(null);
		Station debut = new Station(30,"La Défense",null,new Coordonnee(50,450),1);
		Station fin = new Station(40,"Rome",null,new Coordonnee(150,450),4);
		HashMap<Station, Integer> voisin0 = new HashMap<Station, Integer>();
		voisin0.put(fin,100);
		System.out.println("yop");
		debut.setTemps_vers_station_voisine(voisin0);
		assertEquals(100, a.tempsEntreStation(debut, fin));
	}

}
