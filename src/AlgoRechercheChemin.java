import java.awt.Color;
import java.util.ArrayList;
import java.util.Map.Entry;




	public class AlgoRechercheChemin {

		Station depart;
		
		public AlgoRechercheChemin(Station depart) {
			this.depart = depart;
		}


		public void Tous_Les_Chemins(ArrayList<Station> c,ArrayList<ArrayList<Station>> s,Station CoordonneeCou,Station fin){
			Coordonnee d = depart.getCoordonnee_station();
			Coordonnee nouvelle = CoordonneeCou.getCoordonnee_station();
			Station nouv = CoordonneeCou;
			Coordonnee finale = fin.getCoordonnee_station();
			int x=nouvelle.getX();
			int y=nouvelle.getY();
			
			if((d!=nouvelle)&&(nouvelle==finale)){
					ArrayList<Station> c2=(ArrayList<Station>) c.clone();
					s.add(c2);
			} else {				
				for(Entry<Station,Integer> e : nouv.getTemps_vers_station_voisine().entrySet()){
					Station courante=e.getKey();
							if(!c.contains(courante)){
								nouv=courante;
								c.add(courante);
								Tous_Les_Chemins(c,s,courante,fin);
								c.remove(c.size()-1);
							}					
				}						
			}
		}
		
		public ArrayList<Station> cheminPlusRapide(ArrayList<ArrayList<Station>> stations){
			ArrayList<Station> res = new ArrayList<Station>();
			int tempstotal=10000;
			int temp;
			for (ArrayList<Station> a : stations) {
				temp=tempsChemin(a);
				if(temp<tempstotal){
					tempstotal=temp;
					res=a;
				}
			}
			return res;
		}
		
		public int tempsChemin(ArrayList<Station> chemin){
			int tempstotal=0;
			for (Station station : chemin) {
				tempstotal += station.getTempsarret();
			}
			return tempstotal;
		}
}
			
			
	












