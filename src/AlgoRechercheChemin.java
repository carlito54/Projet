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


		

		
		public void Tous_Les_Chemins(ArrayList<Station> c,ArrayList<ArrayList<Station>> s,Station CoordonneeCou,Station fin){
			Coordonnee d = depart.getCoordonnee_station();
			Coordonnee nouvelle = CoordonneeCou.getCoordonnee_station();
			Station nouv = CoordonneeCou;
			Coordonnee finale = fin.getCoordonnee_station();
			boolean res = false;
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
	}
			
			
			/*Station d = depart;
			Station nouvelle = CoordonneeCou;
			Station ancienne = precedente;
			dejapassé.add(nouvelle);
			System.out.println("Ancienne "+ancienne.getNom());

			System.out.println("Nouvelle "+nouvelle.getNom());
			//System.out.println(fin.getNom());
			if(d!=nouvelle && nouvelle==fin &&!c.contains(nouvelle)){
				System.out.println("fin");
				s.add(c);
				dejapassé.clear();
			}else{
				for(Entry<Station,Integer> e : nouvelle.getTemps_vers_station_voisine().entrySet()){
					//System.out.println(e.getKey().getNom());
					ancienne = nouvelle;
					nouvelle = e.getKey();
					//nouvelle = new Station(e.getKey().getTempsarret(),e.getKey().getNom(),e.getKey().getTemps_vers_station_voisine(), e.getKey().getCoordonnee_station(),e.getKey().getLigne());
					//System.out.println(nouvelle.getNom());
					c.add(nouvelle);
					//if(!dejapassé.contains(nouvelle))
					Tous_Les_Chemins(c,s,nouvelle,t,ancienne,fin);
					c.remove(nouvelle);
					
				}	
				}
			}*/












