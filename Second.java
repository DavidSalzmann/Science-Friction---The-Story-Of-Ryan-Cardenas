package amazingPackageOfAmazingness;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;


public class Second extends JPanel implements ActionListener, KeyListener{
	Timer t = new Timer(5, this);
	double x = 250, y = 250, velX = 0, velY = 0, accY = .2, m = 25, mew = .8,  accX = accY*mew;
	double rectx = 0;
	Ellipse2D circle ;
	Rectangle2D a = new Rectangle2D.Double(105, 950, 100, 10);
	Rectangle2D b = new Rectangle2D.Double(300, 850, 100, 10);
	Rectangle2D c = new Rectangle2D.Double(450, 750, 300, 10);
	Rectangle2D d = new Rectangle2D.Double(800, 650, 125, 10);
	Rectangle2D e = new Rectangle2D.Double(950, 550, 150, 10);
	Rectangle2D[] rects = {a, b, c, d, e};
	Rectangle[] boundz = new Rectangle[rects.length];

	
	boolean collision = false;

	
	public Second() {
		t.restart();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		circle = new Ellipse2D.Double(x, y, 40, 40);
		g.setColor(new Color(147, 112, 219));
		g2.fill(circle);
		   g.setColor(new Color(126, 200, 80));
		   g.fillRect(105, 950, 100, 10);
		   g.fillRect(300, 850, 100, 10);
		   g.fillRect(450, 750, 300, 10);
		   g.fillRect(800, 650, 125, 10);
		   g.fillRect(450, 300, 300, 10);
		   g.fillRect(950, 550, 150, 10);
		   g.fillRect(1100,350, 200, 10);
		 //  g.fillRect(200,30, 600, 10);
		   g.fillOval(2600, 300, 50, 50);
		   g.fillOval(1300, 250, 50, 50);
		   for (int i = 0; i < rects.length; i++) {
					boundz[i] = rects[i].getBounds();
				}
	}
	public void actionPerformed(ActionEvent e) {
		if (x < 0  || x > 1880) {
			velX = -velX;
		}
		if (y < 0  || y > 1040) {
			velY = -velY;
		}
	
	  for (int i = 0; i < boundz.length; i++) {
		  rectx = rects[i].getCenterX();
		  if ((x < rectx + ((rects[i].getWidth())/2)) && (x > rectx - ((rects[i].getWidth())/2)) )
	   velY = 0;
	  }
		//if (collision == true) {
	//		velX = -velX;
	//	}
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
	
	public void collision(Rectangle2D q) {
		if (circle.intersects(q)) {
			collision = true;
		}
	}

	
	
	
}