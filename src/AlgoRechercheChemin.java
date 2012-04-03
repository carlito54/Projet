import java.util.ArrayList;
import java.util.Map.Entry;




	public class AlgoRechercheChemin {
		
		ArrayList<Station> chemin;
		ArrayList<ArrayList<Station>> solutions;
		Station caseCourante;
		int taille;
		Station depart;
		
		public AlgoRechercheChemin(ArrayList<Station> chemin,
				ArrayList<ArrayList<Station>> solutions, Station stationCourante,
				int taille, Station depart) {
			super();
			this.chemin = chemin;
			this.solutions = solutions;
			this.caseCourante = stationCourante;
			this.taille = taille;
			this.depart = depart;
		}


		

		
		public void Tous_Les_Chemins(ArrayList<Station> c,ArrayList<ArrayList<Station>> s,Station CoordonneeCou,int t,Station precedente,Station fin){
			Station d = depart;
			Station nouvelle = CoordonneeCou;
			Station ancienne = precedente;
			//System.out.println(nouvelle.getNom());
			//System.out.println(ancienne.getNom());
			if(d!=nouvelle && nouvelle==fin){
				s.add(c);
			}else{
				for(Entry<Station,Integer> e : nouvelle.getTemps_vers_station_voisine().entrySet()){
					ancienne = nouvelle;
					nouvelle = e.getKey();
					c.add(nouvelle);
					Tous_Les_Chemins(c,s,nouvelle,t,ancienne,fin);
					//c.remove(nouvelle);
				}	
				}
			}
}











