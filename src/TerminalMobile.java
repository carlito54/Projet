import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.text.TabExpander;


public class TerminalMobile {


	public static void main(String[] args) {
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		jf.add(jp);
		jf.setSize(new Dimension(900,700));
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setLocation(200,50);
		jf.setVisible(true);
		
		Station[] lestation = new Station[15];
		
		/** Création des stations et des lignes voisines de chque station **/
		lestation[0] = new Station((int)(Math.random()*60),"La Défense",null,new Coordonnee(50,450),1);
		lestation[1] = new Station((int)(Math.random()*60),"Rome",null,new Coordonnee(150,450),4);
		lestation[2] = new Station((int)(Math.random()*60),"Neuilly",null,new Coordonnee(325,450),1);
		lestation[3] = new Station((int)(Math.random()*60),"Sablons",null,new Coordonnee(575,450),1);
		lestation[4] = new Station((int)(Math.random()*60),"Maillot",null,new Coordonnee(690,450),1);
		lestation[5] = new Station((int)(Math.random()*60),"Argentine",null,new Coordonnee(777,450),6);
		lestation[6] = new Station((int)(Math.random()*60),"Termes",null,new Coordonnee(50,560),2);
		lestation[7] = new Station((int)(Math.random()*60),"Courcelles",null,new Coordonnee(250,370),2);
		lestation[8] = new Station((int)(Math.random()*60),"Monceau",null,new Coordonnee(490,280),5);
		lestation[9] = new Station((int)(Math.random()*60),"Villiers",null,new Coordonnee(620,160),2);
		lestation[10] = new Station((int)(Math.random()*60),"Blanche",null,new Coordonnee(730,90),2);
		lestation[11] = new Station((int)(Math.random()*60),"Pigalle",null,new Coordonnee(50,80),3);
		lestation[12] = new Station((int)(Math.random()*60),"Anvers",null,new Coordonnee(170,150),3);
		lestation[13] = new Station((int)(Math.random()*60),"Stalingrad",null,new Coordonnee(350,220),3);
		lestation[14] = new Station((int)(Math.random()*60),"Gare",null,new Coordonnee(650,370),3);
		
		HashMap<Station, Integer> voisin0 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin1 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin2 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin3 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin4 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin5 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin6 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin7 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin8 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin9 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin10 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin11 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin12 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin13 = new HashMap<Station, Integer>();
		HashMap<Station, Integer> voisin14 = new HashMap<Station, Integer>();
		
		voisin0.put(lestation[1], 35);
		lestation[0].setTemps_vers_station_voisine(voisin0);
		
		voisin1.put(lestation[2], 35);
		voisin1.put(lestation[0], 35);
		voisin1.put(lestation[6], 35);
		voisin1.put(lestation[7], 35);
		lestation[1].setTemps_vers_station_voisine(voisin1);

		voisin2.put(lestation[3], 35);
		voisin2.put(lestation[1], 35);
		lestation[2].setTemps_vers_station_voisine(voisin2);
		
		voisin3.put(lestation[2], 35);
		voisin3.put(lestation[4], 35);
		lestation[3].setTemps_vers_station_voisine(voisin3);
		
		voisin4.put(lestation[3], 35);
		voisin4.put(lestation[5], 35);
		lestation[4].setTemps_vers_station_voisine(voisin4);
		
		voisin5.put(lestation[4], 35);
		voisin5.put(lestation[14], 35);
		lestation[5].setTemps_vers_station_voisine(voisin5);
		
		voisin6.put(lestation[1], 35);
		lestation[6].setTemps_vers_station_voisine(voisin6);
		
		voisin7.put(lestation[1], 35);
		voisin7.put(lestation[8], 35);
		lestation[7].setTemps_vers_station_voisine(voisin7);
		
		voisin8.put(lestation[7], 35);
		voisin8.put(lestation[9], 35);
		voisin8.put(lestation[13], 35);
		voisin8.put(lestation[14], 35);
		lestation[8].setTemps_vers_station_voisine(voisin8);
		
		voisin9.put(lestation[8], 35);
		voisin9.put(lestation[10], 35);
		lestation[9].setTemps_vers_station_voisine(voisin9);
		
		voisin10.put(lestation[9], 35);
		lestation[10].setTemps_vers_station_voisine(voisin10);
		
		voisin11.put(lestation[12], 35);
		lestation[11].setTemps_vers_station_voisine(voisin11);
		
		voisin12.put(lestation[11], 35);
		voisin12.put(lestation[13], 35);
		lestation[12].setTemps_vers_station_voisine(voisin12);
		
		voisin13.put(lestation[12], 35);
		voisin13.put(lestation[8], 35);
		lestation[13].setTemps_vers_station_voisine(voisin13);
		
		voisin14.put(lestation[5], 35);
		voisin14.put(lestation[8], 35);
		lestation[14].setTemps_vers_station_voisine(voisin14);
		
		JButton[] tableaubutton = new JButton[15];
		for (int i = 0; i < 15; i++) {
			JButton jb = new JButton(lestation[i].getNom());
			jp.setLayout(null);
			jb.setBounds(lestation[i].getCoordonnee_station().getX(),lestation[i].getCoordonnee_station().getY(),60,60);
			jp.add(jb);
			tableaubutton[i] = jb;
		}

		ArrayList<Station> chemin = new ArrayList<Station>();
		ArrayList<ArrayList<Station>> solutions = new ArrayList<ArrayList<Station>>();
		AlgoRechercheChemin algo= new AlgoRechercheChemin(lestation[0]);
		algo.Tous_Les_Chemins(chemin, solutions,lestation[0],lestation[10]);
		
		for (ArrayList<Station> a : solutions) {
			//System.out.println("Solution :");
			for (Station station : a) {
				//System.out.println("res"+station.getNom());
				for (int i = 0; i < tableaubutton.length; i++) {
					if(tableaubutton[i].getText().compareTo(station.getNom())==0){
						tableaubutton[i].setBackground(Color.blue);
					}
				}
			}
			Scanner sc = new Scanner(System.in);
			sc.next();
			for (int i = 0; i < tableaubutton.length; i++) {
					tableaubutton[i].setBackground(null);
			}
		}
		


	}

}
