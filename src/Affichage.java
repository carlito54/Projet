import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.text.Position;


public class Affichage {


	private JFrame jf = new JFrame();
	JRadioButton jradio,jradio1;
	private JPanel jp=new JPanel(),radio = new JPanel();
	private JButton[] tableaubutton = new JButton[15];
	private JButton departbutton;
	private AlgoRechercheChemin algo;
	private Station[] lestation = new Station[15];
	private boolean positionner=false;;
	private ArrayList<Station> chemin = new ArrayList<Station>();
	private ArrayList<ArrayList<Station>> solutions = new ArrayList<ArrayList<Station>>();
	private Station depart,arrive,temp1; //temp1 et temp2 les fonctions par ou passer
	private ArrayList<Station> cheminplusrapide,cheminmoinschangement,cheminplusrapide2,cheminmoinschangement2;
	
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
		
		ButtonGroup group = new ButtonGroup();
		jradio = new JRadioButton("Chemin le plus rapide");
		jradio1 = new JRadioButton("Moins de changement de lignes");
		group.add(jradio);
		group.add(jradio1);
		jradio.setSelected(true);
		radio.add(jradio);
		radio.add(jradio1);
		jf.add(radio,BorderLayout.NORTH);
		jradio.setEnabled(false);
		jradio1.setEnabled(false);
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
		JOptionPane.showMessageDialog(jp,"Donnez votre position de d�part");
		donnerPositionDepart();
		JOptionPane.showMessageDialog(jp,"Donnez votre position d'arriver");
		donnerPositionArrive();	
		int option = JOptionPane.showConfirmDialog(null, "Voulez-vous passez par un endroit pr�cis?", "Station interm�diaire", 
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(option==JOptionPane.OK_OPTION){//si on veut passer par un endroit pr�cis
			JOptionPane.showMessageDialog(jp,"Donnez votre position par ou passer");
			donnerPositionAPasser();
			algo.depart=depart;
			algo.Tous_Les_Chemins(chemin, solutions,depart,temp1);
			cheminplusrapide=algo.cheminPlusRapide(solutions);
			cheminmoinschangement=algo.cheminMoinsChangement(solutions);

			if(algo.nbLignes(cheminmoinschangement)==algo.nbLignes(cheminplusrapide))
				cheminmoinschangement=cheminplusrapide;
			
			for (Station station : cheminplusrapide) {
				for (int i = 0; i < lestation.length; i++) {
					if(lestation[i].getNom().compareTo(station.getNom())==0){
						setStation(i);
					}
				}
			}
			chemin.clear();
			solutions.clear();
			algo.depart=temp1;
			algo.Tous_Les_Chemins(chemin, solutions,temp1,arrive);//2e partie du chemin
			cheminplusrapide2= new ArrayList<Station>();
			cheminmoinschangement2=algo.cheminMoinsChangement(solutions);

			if(algo.nbLignes(cheminmoinschangement2)==algo.nbLignes(cheminplusrapide2))
				cheminmoinschangement2=cheminplusrapide2;
			
			cheminplusrapide2.add(temp1);//pour le temps du chemin
			for (Station station : algo.cheminPlusRapide(solutions)) {
				cheminplusrapide2.add(station);
			}
			for (Station station : cheminplusrapide2) {
				for (int i = 0; i < lestation.length; i++) {
					if(lestation[i].getNom().compareTo(station.getNom())==0){
						setStation(i);
					}
				}
			}
			//if(depart!=arrive){
				BarreProgression frame = new BarreProgression();
		        frame.pack();
		        frame.setVisible(true);
		        frame.loop();
		        frame.setVisible(false);
				int totalsecondes = algo.tempsChemin(cheminplusrapide2)-temp1.getTempsarret()-arrive.getTempsarret()+algo.tempsChemin(cheminplusrapide); 
				int secondes = totalsecondes % 60;
				int minutes = (totalsecondes / 60) % 60;
				JOptionPane.showMessageDialog(jp,"Voila le chemin � prendre \nTemps estim� : "+minutes+" "+
							"minutes "+secondes+" secondes \nNombres de changement(s) : "+(algo.nbLignes(cheminplusrapide2)+algo.nbLignes(cheminplusrapide)));
				//}
			
		}else{
			algo.depart=depart;
			algo.Tous_Les_Chemins(chemin, solutions,depart,arrive);
			
			cheminplusrapide=algo.cheminPlusRapide(solutions);
			cheminmoinschangement=algo.cheminMoinsChangement(solutions);

			if(algo.nbLignes(cheminmoinschangement)==algo.nbLignes(cheminplusrapide))
				cheminmoinschangement=cheminplusrapide;
			
			
			for (Station station : cheminplusrapide) {
				for (int i = 0; i < lestation.length; i++) {
					if(lestation[i].getNom().compareTo(station.getNom())==0){
						setStation(i);
					}
				}
			}
			//if(depart!=arrive){
				BarreProgression frame = new BarreProgression();
		        frame.pack();
		        frame.setVisible(true);
		        frame.loop();
		        frame.setVisible(false);
				int totalsecondes = algo.tempsChemin(cheminplusrapide)-arrive.getTempsarret(); 
				int secondes = totalsecondes % 60;
				int minutes = (totalsecondes / 60) % 60;
				JOptionPane.showMessageDialog(jp,"Voila le chemin � prendre \nTemps estim� : "+minutes+" "+
							"minutes "+secondes+" secondes \nNombres de changement(s) : "+algo.nbLignes(cheminplusrapide));
			//}
				jradio.setEnabled(true);
				jradio1.setEnabled(true);
				jradio.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					effacerStation();
					//departbutton.setIcon(new ImageIcon("station_check.gif"));
					changementChemin(cheminplusrapide);
					}
				});
				jradio1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						effacerStation();
						//departbutton.setIcon(new ImageIcon("station_check.gif"));
						changementChemin(cheminmoinschangement);
					}
				});
				
		}//fin else
		
		
	}
	
	public boolean donnerPositionDepart(){
		ajoutListenerDepart();
		jp.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				int stationplusproche=algo.proche(e.getX(),e.getY(),lestation);
				departbutton = tableaubutton[stationplusproche];
				setStation(stationplusproche);
				depart=lestation[stationplusproche];
				jp.removeMouseListener(this);
				supprimerListenerBouton();
				positionner=true;
			}
		});
		while(positionner==false);//on attend le clic de la position
		positionner=false;
		return positionner;
	}
	
	public boolean donnerPositionAPasser(){
		ajoutListenerAPasser();
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
				supprimerListenerBouton();
				positionner=true;
			}
		});
		while(positionner==false);//on attend le clic de la position
		positionner=false;
		return positionner;
	}
	
	public boolean donnerPositionArrive(){
		ajoutListenerArrive();
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
					supprimerListenerBouton();
					positionner=true;
					/*if(depart==arrive){
						JOptionPane.showMessageDialog(jp,"Votre position de d�part et d'arriver est trop proche, vous irez plus vite � pied!");
						effacerStation();
					}*/	
			}
		});
		while(positionner==false);//on attend le clic de la position
		positionner=false;
		return positionner;
	}
	
	public void effacerStation(){//remettre les station � l'etat initial
		for (int j = 0; j < tableaubutton.length; j++) {
			tableaubutton[j].setIcon(new ImageIcon("station.gif"));
		}
		this.paint(jp.getGraphics(), tableaubutton, lestation);

	}
	
	public void ajoutListenerDepart(){
		for (int i = 0; i < tableaubutton.length; i++) {
			tableaubutton[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton cliquer=(JButton) e.getSource();
					departbutton = cliquer;
					depart=boutonCliquer(cliquer);
					cliquer.setIcon(new ImageIcon("station_check.gif"));
					positionner=true;
					supprimerListenerBouton();
					supprimerListenerSouris();
				}
			});
				
		}
	}
	
	public void ajoutListenerArrive(){
		for (int i = 0; i < tableaubutton.length; i++) {
			tableaubutton[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton cliquer=(JButton) e.getSource();
					arrive=boutonCliquer(cliquer);
					cliquer.setIcon(new ImageIcon("station_check.gif"));
					positionner=true;
					supprimerListenerBouton();
					supprimerListenerSouris();
				}
			});
				
		}
	}
	
	public void ajoutListenerAPasser(){
		for (int i = 0; i < tableaubutton.length; i++) {
			tableaubutton[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton cliquer=(JButton) e.getSource();
					temp1=boutonCliquer(cliquer);
					cliquer.setIcon(new ImageIcon("station_check.gif"));
					positionner=true;
					supprimerListenerBouton();
					supprimerListenerSouris();
				}
			});
				
		}
	}
	
	public Station boutonCliquer(JButton clic){
		for (int i = 0; i < tableaubutton.length; i++) {
			if(tableaubutton[i].getX()==clic.getX() && tableaubutton[i].getY()==clic.getY()){
				return lestation[i];	
			}
		}
		return null;
	}
	
	public void supprimerListenerBouton(){
		for (int i = 0; i < tableaubutton.length; i++) {
			for (ActionListener act : tableaubutton[i].getActionListeners()) {
				tableaubutton[i].removeActionListener(act);
			}
			
		}
	}
	
	public void supprimerListenerSouris(){
		for (MouseListener mouse : jp.getMouseListeners()) {
			jp.removeMouseListener(mouse);
		}
	}
	
	public void changementChemin(ArrayList<Station> chemin){
		for (Station station : chemin) {
			for (int i = 0; i < lestation.length; i++) {
				if(lestation[i].getNom().compareTo(station.getNom())==0){
					setStation(i);
				}
			}
		}
		//if(depart!=arrive){
			int totalsecondes = algo.tempsChemin(chemin)-arrive.getTempsarret(); 
			int secondes = totalsecondes % 60;
			int minutes = (totalsecondes / 60) % 60;
			JOptionPane.showMessageDialog(jp,"Voila le chemin � prendre \nTemps estim� : "+minutes+" "+
						"minutes "+secondes+" secondes \nNombres de changement(s) : "+algo.nbLignes(chemin));
		//}
	}
	

}
