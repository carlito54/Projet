import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


public class Affichage {


	private JFrame jf = new JFrame();
	private JPanel jp = new JPanel();
	private JButton[] tableaubutton = new JButton[15];
	private AlgoRechercheChemin algo;
	private Station[] lestation = new Station[15];

	
	Affichage(AlgoRechercheChemin a){
		algo = a;
		jf.add(jp);
		jf.setSize(new Dimension(900,700));
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setLocation(200,50);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setVisible(true);
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
		jp.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				setStation(algo.proche(e.getX(),e.getY(),lestation));
			}
		});
	}


}
