import java.util.ArrayList;


public class Ligne {
	int numero;
	ArrayList<Station> lesstations;
	
	public Ligne(int n, ArrayList<Station> a){
		numero=n;
		lesstations=a;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public ArrayList<Station> getLesstations() {
		return lesstations;
	}

	public void setLesstations(ArrayList<Station> lesstations) {
		this.lesstations = lesstations;
	}
}
