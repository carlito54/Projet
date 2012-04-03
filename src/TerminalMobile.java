import java.awt.BorderLayout;
import java.awt.Dimension;

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
		jf.setVisible(true);
		
		Station[] lestation = new Station[14];
		
		lestation[0] = new Station(30,"La Défense",null,new Coordonnee(50,450),1);
		lestation[1] = new Station(45,"Esplanade de la Défense",null,new Coordonnee(150,450),4);
		lestation[2] = new Station(22,"Pont de Neuilly",null,new Coordonnee(325,450),1);
		lestation[3] = new Station(12,"Les Sablons",null,new Coordonnee(575,450),1);
		lestation[4] = new Station(43,"Porte Maillot",null,new Coordonnee(690,450),1);
		lestation[5] = new Station(99,"Argentine",null,new Coordonnee(777,450),6);
		
		for (int i = 0; i < 6; i++) {
			RoundBouton jb = new RoundBouton(new ImageIcon("station.jpg"));
			jp.setLayout(null);
			jb.setBounds(lestation[i].getCoordonnee_station().getX(),lestation[i].getCoordonnee_station().getY(),30,30);
			jp.add(jb);
		
		}
		
		System.out.println("ANTHO");
		System.out.println("BOUBOU");
	}

}
