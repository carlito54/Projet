import java.util.ArrayList;
import java.util.Map.Entry;




	public class AlgoRechercheChemin {
		
		ArrayList<Station> chemin;
		ArrayList<ArrayList<Station>> solutions;
		Station caseCourante;
		int taille;
		Station depart;
		ArrayList<Station> dejapassé;
		
		public AlgoRechercheChemin(ArrayList<Station> chemin,
				ArrayList<ArrayList<Station>> solutions, Station stationCourante,
				int taille, Station depart) {
			super();
			this.chemin = chemin;
			this.solutions = solutions;
			this.caseCourante = stationCourante;
			this.taille = taille;
			this.depart = depart;
			dejapassé = new ArrayList<Station>();
		}


		

		
		public void Tous_Les_Chemins(ArrayList<Station> c,ArrayList<ArrayList<Station>> s,Station CoordonneeCou,int t,Station precedente,Station fin){
			Station d = depart;
			Station nouvelle = CoordonneeCou;
			Station ancienne = precedente;
			dejapassé.add(nouvelle);
			//System.out.println(nouvelle.getNom());
			//System.out.println(fin.getNom());
			if(d!=nouvelle && nouvelle==fin){
				System.out.println("fin");
				s.add(c);
				dejapassé.clear();
			}else{
				for(Entry<Station,Integer> e : nouvelle.getTemps_vers_station_voisine().entrySet()){
					//System.out.println(e.getKey().getNom());
					ancienne = nouvelle;
					nouvelle = e.getKey();
					System.out.println(nouvelle.getNom());
					c.add(nouvelle);
					//if(!dejapassé.contains(nouvelle))
					Tous_Les_Chemins(c,s,nouvelle,t,ancienne,fin);
					c.remove(nouvelle);
					
				}	
				}
			}
}











