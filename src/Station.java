import java.util.HashMap;


public class Station {
	private int tempsarret;
	private String nom;
	private boolean incident;
	private HashMap<Station,Integer> temps_vers_station_voisine;//retourne -1 si il y a un incident sur la voie
	private Coordonnee coordonnee_station;
	private int ligne;
	//1 pour ligne1,2 pour ligne 2,3 pour ligne 3,4 pour ligne 1 et 2, 5 pour ligne 2 et 3, 6 pour ligne 1 et 3
	
	public Station(int t,String n,HashMap<Station,Integer> h,Coordonnee c,int l){
		tempsarret = t;
		nom = n;
		temps_vers_station_voisine=h;
		coordonnee_station = c;
		ligne=l;
		incident=false;
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public int getTempsarret() {
		return tempsarret;
	}

	public void setTempsarret(int tempsarret) {
		this.tempsarret = tempsarret;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isIncident() {
		return incident;
	}

	public void setIncident(boolean incident) {
		this.incident = incident;
	}

	public HashMap<Station, Integer> getTemps_vers_station_voisine() {
		return temps_vers_station_voisine;
	}

	public void setTemps_vers_station_voisine(
			HashMap<Station, Integer> tempsVersStationVoisine) {
		temps_vers_station_voisine = tempsVersStationVoisine;
	}

	public Coordonnee getCoordonnee_station() {
		return coordonnee_station;
	}

	public void setCoordonnee_station(Coordonnee coordonneeStation) {
		coordonnee_station = coordonneeStation;
	}
		
}
