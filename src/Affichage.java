import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.text.Position;


public class Affichage {


	private JFrame jf = new JFrame();
	private JPanel jp = new JPanel();
	private JButton[] tableaubutton = new JButton[15];
	private AlgoRechercheChemin algo;
	private Station[] lestation = new Station[15];
	private boolean positionner=false;;
	private ArrayList<Station> chemin = new ArrayList<Station>();
	private ArrayList<ArrayList<Station>> solutions = new ArrayList<ArrayList<Station>>();
	private Station depart,arrive,temp1; //temp1 et temp2 les fonctions par ou passer
	
	Affichage(AlgoRechercheChemin a){
		algo = a;
		
		jf.setSize(new Dimension(900,700));
		jf.setTitle("Terminal Mobile Metro");
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setLocation(200,50);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setLayout(new BorderLayout());
		jf.add(jp);
		
		JPanel radio = new JPanel();
		JRadioButton jradio = new JRadioButton("Chemin le plus rapide");
		JRadioButton jradio1 = new JRadioButton("Moins de changement de lignes");
		radio.add(jradio);
		radio.add(jradio1);
		jf.add(radio,BorderLayout.NORTH);
		
	}
	
	public void paint(Graphics g, JButton[] tableaubutton, Station[] lestation){
		for (int i = 0; i < tableaubutton.length; i++) {
			for(Entry<Station,Integer> e : lestation[i].getTemps_vers_station_voisine().entrySet()){
				g.drawLine(lestation[i].getCoordonnee_station().getX()+30, lestation[i].getCoordonnee_station().getY()+30,e.getKey().getCoordonnee_station().getX()+30, e.getKey().getCoordonnee_station().getY()+30);
			}
		}
		jp.paintComponents(g);
		
	}
	
	public JButton[] plan(Station[] lestation){
		this.lestation = lestation;
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
		return tableaubutton;
		
	}
	
	public void chargerLigne(){
		
		
	}

	public JFrame getJf() {
		return jf;
	}

	public void setJf(JFrame jf) {
		this.jf = jf;
	}

	public JPanel getJp() {
		return jp;
	}

	public void setJp(JPanel jp) {
		this.jp = jp;
	}
	
	public void setStation(int i){
		tableaubutton[i].setIcon(new ImageIcon("station_check.gif"));
		this.paint(jp.getGraphics(), tableaubutton, lestation);
	}

	
	public void stationPlusProche(){
		JOptionPane.showMessageDialog(jp,"Donnez votre position de départ");
		donnerPositionDepart();
		JOptionPane.showMessageDialog(jp,"Donnez votre position d'arriver");
		donnerPositionArrive();		
		int option = JOptionPane.showConfirmDialog(null, "Voulez-vous passez par un endroit précis?", "Station intermédiaire", 
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(option==JOptionPane.OK_OPTION){
			JOptionPane.showMessageDialog(jp,"Donnez votre position par ou passer");
			donnerPositionAPasser();
			algo.Tous_Les_Chemins(chemin, solutions,depart,temp1);
			ArrayList<Station> cheminplusrapide=algo.cheminPlusRapide(solutions);
			int premiertemps = algo.tempsPlusRapide(solutions); 
			for (Station station : cheminplusrapide) {
				for (int i = 0; i < lestation.length; i++) {
					if(lestation[i].getNom().compareTo(station.getNom())==0){
						setStation(i);
					}
				}
			}
			algo.Tous_Les_Chemins(chemin, solutions,temp1,arrive);
			ArrayList<Station> cheminplusrapide2=algo.cheminPlusRapide(solutions);
			for (Station station : cheminplusrapide2) {
				for (int i = 0; i < lestation.length; i++) {
					if(lestation[i].getNom().compareTo(station.getNom())==0){
						setStation(i);
					}
				}
			}
			if(depart!=arrive){
				BarreProgression frame = new BarreProgression();
		        frame.pack();
		        frame.setVisible(true);
		        frame.loop();
		        frame.setVisible(false);
				int totalsecondes = algo.tempsPlusRapide(solutions)+premiertemps; 
				int secondes = totalsecondes % 60;
				int minutes = (totalsecondes / 60) % 60;
				JOptionPane.showMessageDialog(jp,"Voila le chemin à prendre \nTemps estimé : "+minutes+" "+
							"minutes "+secondes+" secondes \nNombres de changements : "+(cheminplusrapide.size()+cheminplusrapide2.size()));
			}
			
		}else{
			algo.Tous_Les_Chemins(chemin, solutions,depart,arrive);
			
			ArrayList<Station> cheminplusrapide=algo.cheminPlusRapide(solutions);
	
			for (Station station : cheminplusrapide) {
				for (int i = 0; i < lestation.length; i++) {
					if(lestation[i].getNom().compareTo(station.getNom())==0){
						setStation(i);
					}
				}
			}
			if(depart!=arrive){
				BarreProgression frame = new BarreProgression();
		        frame.pack();
		        frame.setVisible(true);
		        frame.loop();
		        frame.setVisible(false);
				int totalsecondes = algo.tempsPlusRapide(solutions); 
				int secondes = totalsecondes % 60;
				int minutes = (totalsecondes / 60) % 60;
				JOptionPane.showMessageDialog(jp,"Voila le chemin à prendre \nTemps estimé : "+minutes+" "+
							"minutes "+secondes+" secondes \nNombres de changements : "+cheminplusrapide.size());
			}
		}
		
	}
	
	public boolean donnerPositionDepart(){
		jp.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				int stationplusproche=algo.proche(e.getX(),e.getY(),lestation);
				setStation(stationplusproche);
				depart=lestation[stationplusproche];
				jp.removeMouseListener(this);
				positionner=true;
			}
		});
		while(positionner==false);//on attend le clic de la position
		positionner=false;
		return positionner;
	}
	
	public boolean donnerPositionAPasser(){
		jp.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				int stationplusproche=algo.proche(e.getX(),e.getY(),lestation);
				setStation(stationplusproche);
				temp1=lestation[stationplusproche];
				jp.removeMouseListener(this);
				positionner=true;
			}
		});
		while(positionner==false);//on attend le clic de la position
		positionner=false;
		return positionner;
	}
	
	public boolean donnerPositionArrive(){
		jp.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				int stationplusproche=algo.proche(e.getX(),e.getY(),lestation);
					setStation(stationplusproche);
					arrive=lestation[stationplusproche];
					jp.removeMouseListener(this);
					positionner=true;
					if(depart==arrive){
						JOptionPane.showMessageDialog(jp,"Votre position de départ et d'arriver est trop proche, vous irez plus vite à pied!");
						effacerStation();
					}		
			}
		});
		while(positionner==false);//on attend le clic de la position
		positionner=false;
		return positionner;
	}
	
	public void effacerStation(){//remettre les station à l'etat initial
		for (int j = 0; j < tableaubutton.length; j++) {
			tableaubutton[j].setIcon(new ImageIcon("station.gif"));
		}
		this.paint(jp.getGraphics(), tableaubutton, lestation);

	}

}
