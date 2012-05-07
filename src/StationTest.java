import java.util.HashMap;

import org.junit.Test;
import static org.junit.Assert.*;

public class StationTest {
	
	@Test
	public void testMettreVoieEnPanne() {
		Station s1 = new Station(20,"Rome",null,new Coordonnee(150,450),1);
		Station s2 = new Station(20,"Courcelles",null,new Coordonnee(250,370),1);
		Station s3 = new Station(20,"Neuilly",null,new Coordonnee(325,450),1);
		HashMap<Station, Integer> voisin0 = new HashMap<Station, Integer>();
		voisin0.put(s2,100);
		voisin0.put(s3,10);
		s1.setTemps_vers_station_voisine(voisin0);
		
		s1.mettreVoieEnPanne(s2);
		
		HashMap<Station, Integer> voisin2 = new HashMap<Station, Integer>();
		voisin2.put(s2,-1);
		voisin2.put(s3,10);
		
		assertEquals(voisin2, voisin0);
	}

}
