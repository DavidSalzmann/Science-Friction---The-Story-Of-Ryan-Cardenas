package amazingPackageOfAmazingness;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;


public class Second extends JPanel implements ActionListener, KeyListener{
	Timer t = new Timer(5, this);
	double x = 250, y = 250, velX = 0, velY = 0, accY = .2, m = 25, mew = .8,  accX = accY*mew;
	
	public Second() {
		t.restart();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D circle = new Ellipse2D.Double(x, y, 40, 40);
		g.setColor(new Color(147, 112, 219));
		g2.fill(circle);

	}
	public void actionPerformed(ActionEvent e) {
		if (x < 0  || x > 1880) {
			velX = -velX;
		}
		if (y < 0  || y > 1040) {
			velY = -velY;
		}
		//velX -= accX;
		velY += accY;
		x += velX;
		y += velY;
		repaint();
	}
	public void up() {
		velY += -2.5 ;
		velX += 0;
	}
	public void down() {
		velY += 2.5;
		velX += 0;
	}
	public void left() {
		velY +=  0;
		velX += -2.5;
	}
	public void right() {
		velY += 0;
		velX += 2.5;
	}
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			up();
		}
		if (code == KeyEvent.VK_DOWN) {
			down();
		}
		if (code == KeyEvent.VK_LEFT) {
			left();
		}
		if (code == KeyEvent.VK_RIGHT) {
			right();
		}
		
	}
	public void keyTyped(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {}

	
	
	
}