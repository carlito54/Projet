
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 * Afficher une barre de progression dans un JFrame
 */
public class BarreProgression extends JFrame {

    public JProgressBar progressbar;

    public BarreProgression() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Chargement...");
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout());
        progressbar = new JProgressBar(0, 100);
        progressbar.setValue(0);
        progressbar.setStringPainted(true);
        pane.add(progressbar);
        setContentPane(pane);
    }

    /**
     * Afficher la progression de tache
     */

    public void loop() {
        int position = 0;
        while (position <= 105) {
            progressbar.setValue(position);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            position += 15;
        }
    }
}
