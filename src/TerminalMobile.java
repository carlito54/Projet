import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
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
		jf.setResizable(false);
		jf.setVisible(true);
			Station[] lestation = new Station[15];
		
		/** Création des stations et des lignes voisines de chque station **/
		lestation[0] = new Station(30,"La Défense",null,new Coordonnee(50,450),1);
		lestation[1] = new Station(40,"Rome",null,new Coordonnee(150,450),4);
		lestation[2] = new Station(25,"Neuilly",null,new Coordonnee(325,450),1);
		lestation[3] = new Station(15,"Sablons",null,new Coordonnee(575,450),1);
		lestation[4] = new Station(45,"Maillot",null,new Coordonnee(690,450),1);
		lestation[5] = new Station(20,"Argentine",null,new Coordonnee(777,450),6);
		lestation[6] = new Station(10,"Termes",null,new Coordonnee(50,560),2);
		lestation[7] = new Station(60,"Courcelles",null,new Coordonnee(250,370),2);
		lestation[8] = new Station(35,"Monceau",null,new Coordonnee(490,280),5);
		lestation[9] = new Station(50,"Villiers",null,new Coordonnee(620,160),2);
		lestation[10] = new Station(15,"Blanche",null,new Coordonnee(730,90),2);
		lestation[11] = new Station(55,"Pigalle",null,new Coordonnee(50,80),3);
		lestation[12] = new Station(30,"Anvers",null,new Coordonnee(170,150),3);
		lestation[13] = new Station(25,"Stalingrad",null,new Coordonnee(350,220),3);
		lestation[14] = new Station(45,"Gare",null,new Coordonnee(650,370),3);
		
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
		
		voisin0.put(lestation[1],100);
		lestation[0].setTemps_vers_station_voisine(voisin0);
		
		voisin1.put(lestation[2], 130);
		voisin1.put(lestation[0], 130);
		voisin1.put(lestation[6], 220);
		voisin1.put(lestation[7], 125);
		lestation[1].setTemps_vers_station_voisine(voisin1);

		voisin2.put(lestation[3], 300);
		voisin2.put(lestation[1], 287);
		lestation[2].setTemps_vers_station_voisine(voisin2);
		
		voisin3.put(lestation[2], 222);
		voisin3.put(lestation[4], 111);
		lestation[3].setTemps_vers_station_voisine(voisin3);
		
		voisin4.put(lestation[3], 90);
		voisin4.put(lestation[5], 199);
		lestation[4].setTemps_vers_station_voisine(voisin4);
		
		voisin5.put(lestation[4], 210);
		voisin5.put(lestation[14], 105);
		lestation[5].setTemps_vers_station_voisine(voisin5);
		
		voisin6.put(lestation[1], 80);
		lestation[6].setTemps_vers_station_voisine(voisin6);
		
		voisin7.put(lestation[1], 95);
		voisin7.put(lestation[8], 155);
		lestation[7].setTemps_vers_station_voisine(voisin7);
		
		voisin8.put(lestation[7], 275);
		voisin8.put(lestation[9], 305);
		voisin8.put(lestation[13], 75);
		voisin8.put(lestation[14], 110);
		lestation[8].setTemps_vers_station_voisine(voisin8);
		
		voisin9.put(lestation[8], 150);
		voisin9.put(lestation[10], 225);
		lestation[9].setTemps_vers_station_voisine(voisin9);
		
		voisin10.put(lestation[9], 135);
		lestation[10].setTemps_vers_station_voisine(voisin10);
		
		voisin11.put(lestation[12], 80);
		lestation[11].setTemps_vers_station_voisine(voisin11);
		
		voisin12.put(lestation[11], 140);
		voisin12.put(lestation[13], 220);
		lestation[12].setTemps_vers_station_voisine(voisin12);
		
		voisin13.put(lestation[12], 160);
		voisin13.put(lestation[8], 360);
		lestation[13].setTemps_vers_station_voisine(voisin13);
		
		voisin14.put(lestation[5], 230);
		voisin14.put(lestation[8], 310);
		lestation[14].setTemps_vers_station_voisine(voisin14);
		
		//On affiche les stations dans un Jpanel
		JButton[] tableaubutton = new JButton[15];
		Graphics g;
			for (int i = 0; i < 15; i++) {
				//JButton jb = new JButton(lestation[i].getNom());
				JButton jb = new JButton(new ImageIcon("station.gif"));
				String nom = lestation[i].getNom();
				JLabel jl = new JLabel(nom,SwingConstants.CENTER);
				jb.setBorderPainted(false);
				jb.setFocusPainted(false);
				jb.setContentAreaFilled(false);
				jb.setOpaque(false);
				jb.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
				jp.setLayout(null);
				jb.setBounds(lestation[i].getCoordonnee_station().getX(),lestation[i].getCoordonnee_station().getY(),30,30);
				jp.add(jb);
				jp.setLayout(null);
				jb.setBounds(lestation[i].getCoordonnee_station().getX(),lestation[i].getCoordonnee_station().getY(),60,60);
				int x = lestation[i].getCoordonnee_station().getX() - 22;
				int y = lestation[i].getCoordonnee_station().getY() + 60;
				jl.setBounds(x,y, 100, 15);
				//g = jp;
				
				//g = jp.getGraphics();
				//g.fillRect(lestation[i].getCoordonnee_station().getX(), lestation[i].getCoordonnee_station().getY(), 0, 0);
		        //jp.paintComponents(g);	
				jp.add(jb);
				jp.add(jl);
				tableaubutton[i] = jb;
			}
			g = jp.getGraphics();
			for (int i = 0; i < tableaubutton.length; i++) {
				for(Entry<Station,Integer> e : lestation[i].getTemps_vers_station_voisine().entrySet()){
					g.drawLine(lestation[i].getCoordonnee_station().getX()+30, lestation[i].getCoordonnee_station().getY()+30,e.getKey().getCoordonnee_station().getX()+30, e.getKey().getCoordonnee_station().getY()+30);
				}
			}
			jp.paintComponents(g);
		for (int i = 0; i < 15; i++) {
			JButton jb = new JButton(lestation[i].getNom());
			jp.setLayout(null);
			jb.setBounds(lestation[i].getCoordonnee_station().getX(),lestation[i].getCoordonnee_station().getY(),60,60);
			jp.add(jb);
			tableaubutton[i] = jb;
		}
		//** TODO Tracé ligne entre station
		
		
		jp.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getX());
			}
		});
		

		ArrayList<Station> chemin = new ArrayList<Station>();
		ArrayList<ArrayList<Station>> solutions = new ArrayList<ArrayList<Station>>();
		AlgoRechercheChemin algo= new AlgoRechercheChemin(lestation[0]);
		algo.Tous_Les_Chemins(chemin, solutions,lestation[0],lestation[10]);
		
		//le temps le plus rapide entre la station 0 et 10 est de 1010
		
		for (Station station : algo.cheminPlusRapide(solutions)) {
			//System.out.println("res"+station.getNom());
			for (int i = 0; i < tableaubutton.length; i++) {
				if(tableaubutton[i].getText().compareTo(station.getNom())==0){
					tableaubutton[i].setBackground(Color.blue);
				}
			}
		}
		/*for (ArrayList<Station> a : solutions) {
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
		}*/
		
	}
	
}