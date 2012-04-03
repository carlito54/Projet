import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class TerminalMobile {


	public static void main(String[] args) {
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		jf.add(jp);
		jf.setSize(new Dimension(900,600));
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setLocation(200,100);
		//jf.setVisible(true);
		
		Station[] lestation = new Station[14];
		
		lestation[0] = new Station(30,"La Défense",null,new Coordonnee(50,450),1);
		lestation[1] = new Station(45,"Esplanade de la Défense",null,new Coordonnee(150,450),4);
		lestation[2] = new Station(22,"Pont de Neuilly",null,new Coordonnee(325,450),1);
		lestation[3] = new Station(12,"Les Sablons",null,new Coordonnee(575,450),1);
		lestation[4] = new Station(43,"Porte Maillot",null,new Coordonnee(690,450),1);
		lestation[5] = new Station(99,"Argentine",null,new Coordonnee(777,450),6);
		
		HashMap<Station, Integer> voisin = new HashMap<Station, Integer>();
		voisin.put(lestation[1], 35);
		lestation[0].setTemps_vers_station_voisine(voisin);
		
		HashMap<Station, Integer> voisin1 = new HashMap<Station, Integer>();
		voisin1.put(lestation[2], 35);
		lestation[1].setTemps_vers_station_voisine(voisin1);
		
		HashMap<Station, Integer> voisin2 = new HashMap<Station, Integer>();
		voisin2.put(lestation[3], 35);
		lestation[2].setTemps_vers_station_voisine(voisin2);
		
		for (int i = 0; i < 6; i++) {
			JButton jb = new JButton(lestation[i].getNom());
			jp.setLayout(null);
			jb.setBounds(lestation[i].getCoordonnee_station().getX(),lestation[i].getCoordonnee_station().getY(),30,30);
			jp.add(jb);
		
		}
		ArrayList<Station> chemin = new ArrayList<Station>();
		ArrayList<ArrayList<Station>> solutions = new ArrayList<ArrayList<Station>>();
		AlgoRechercheChemin algo= new AlgoRechercheChemin(chemin, solutions, lestation[0], 1, lestation[0]);
		algo.Tous_Les_Chemins(chemin, solutions, lestation[0], 1, lestation[0],lestation[2]);
		
		for (ArrayList<Station> a : solutions) {
			for (Station station : a) {
				System.out.println(station.getNom());
			}
		}
		
	}

}
