import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class RoundButton extends JButton {
  public RoundButton() {
    super();
    Dimension size = getPreferredSize();
    size.width = size.height = 50;
    setPreferredSize(size);
    setContentAreaFilled(false);
  }

// Paint the round background and label.
  protected void paintComponent(Graphics g) {
    if (getModel().isArmed()) {
// You might want to make the highlight color 
   // a property of the RoundButton class.
      g.setColor(Color.lightGray);
    } else {
      g.setColor(getBackground());
    }
    g.fillOval(0, 0, getSize().width-1, 
      getSize().height-1);

// This call will paint the label and the 
   // focus rectangle.
    super.paintComponent(g);
  }

// Paint the border of the button using a simple stroke.
  protected void paintBorder(Graphics g) {
    g.setColor(getForeground());
    g.drawOval(0, 0, getSize().width-1, 
      getSize().height-1);
  }

// Hit detection.
  Shape shape;
  public boolean contains(int x, int y) {
// If the button has changed size, 
   // make a new shape object.
    if (shape == null || 
      !shape.getBounds().equals(getBounds())) {
      shape = new Ellipse2D.Float(0, 0, 
        getWidth(), getHeight());
    }
    return shape.contains(x, y);
  }

// Test routine.
  public static void main(String[] args) {
// Create a button with the label "Jackpot".
    JButton button = new RoundButton();
    button.setIcon(new ImageIcon("station.jpg"));

// Create a frame in which to show the button.
    JFrame frame = new JFrame();
    frame.getContentPane().setBackground(Color.white);
    frame.getContentPane().add(button);
    frame.getContentPane().setLayout(new FlowLayout());
    frame.setSize(150, 150);
    frame.setVisible(true);
  }
}
