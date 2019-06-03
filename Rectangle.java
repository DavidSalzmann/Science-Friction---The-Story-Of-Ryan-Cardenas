package amazingPackageOfAmazingness;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.*;


public class Rectangle {
	public Rectangle(int i, int j, int k, int l) {
		
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Rectangle rect = new Rectangle(x, y, z, q);
		g.setColor(new Color(147, 112, 219));
		g2.fill(rect);

	
	public void paint(Graphics g) {
        g.fillRect(150, 100, 100, 10);
        g.fillRect(300, 300, 100, 10);
        g.fillRect(500, 300, 100, 10);
        g.fillRect(700, 300, 100, 10);
        g.fillRect(450, 300, 300, 10);
        g.fillRect(900, 300, 400, 10);
      //  g.fillRect(2000,300, 600, 10);
        g.fillOval(2600, 300, 50, 50);
        g.fillOval(1300, 250, 50, 50);

    }
	
}
