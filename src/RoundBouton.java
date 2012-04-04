import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;


public class RoundBouton extends JButton {

	private static final long serialVersionUID = 7824724817261535225L;

public RoundBouton(Icon icon) {
    super(icon);
    setBorderPainted(false);
    setFocusPainted(false);
    setContentAreaFilled(false);
    setOpaque(false);
    setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
  }

  public boolean contains(int x, int y) {
    Dimension size = getSize();
    float x0 = size.width / 2F;
    float y0 = size.height / 2F;
 
    Icon icon = getIcon();
    float w = icon.getIconWidth() / 2F;
    float h = icon.getIconHeight() / 2F;
 
    return (x - x0) * (x - x0) + (y - y0) * (y - y0) <= w * h;
  }
}