package amazingPackageOfAmazingness;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.File;
import java.io.IOException;


public class Second extends JPanel implements ActionListener, KeyListener{
	Timer t = new Timer(10, this);
	double x = 250, y = 250, velX = 0, velY = 0, accY = .8, m = 25, mew = .1,  accX = accY*mew;
	double rectx = 0;
	double recty = 0;
	double tempX = 0;
	double tempY = 0;
	double tempVX = 0;
	double tempVY = 0;
	double deathx = 0;
	double deathy = 0;
	int numJumps = 0;
	boolean collide = false;
	Ellipse2D circle ;
	Rectangle2D a = new Rectangle2D.Double(105, 950, 100, 10);
	Rectangle2D b = new Rectangle2D.Double(300, 850, 100, 10);
	Rectangle2D c = new Rectangle2D.Double(450, 750, 300, 10);
	Rectangle2D d = new Rectangle2D.Double(800, 650, 125, 10);
	Rectangle2D e = new Rectangle2D.Double(950, 550, 150, 10);
	Rectangle2D f = new Rectangle2D.Double(1100,350, 200, 10);
	Rectangle2D h = new Rectangle2D.Double(1450,250, 200, 10);
	
	
	Rectangle2D death1 = new Rectangle2D.Double(580, 690, 50, 60);
	Rectangle2D death2 = new Rectangle2D.Double(1170,290, 50, 60);
	Rectangle2D[] deathEntity = {death1, death2};
	
	Rectangle2D[] rects = {a, b, c, d, e, f, h};
	Rectangle[] boundz = new Rectangle[rects.length];

	
	public void endGame() {
		System.exit(0);
	}

	
	public Second() {
		t.restart();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(new Color(204, 242, 255));
		g.fillRect(0, 0, 1920, 1080);
		circle = new Ellipse2D.Double(x, y, 40, 40);
		g.setColor(new Color(147, 112, 219));
		g2.fill(circle);
		   g.setColor(new Color(126, 200, 80));
		   g.fillRect(105, 950, 100, 10);
		   g.fillRect(300, 850, 100, 10);
		   g.fillRect(450, 750, 300, 10);
		   g.fillRect(800, 650, 125, 10);
		   g.setColor(new Color(255,135,195));
		   g.fillRect(950, 550, 150, 10);
		   g.fillRect(1100,350, 200, 10);
		   g.fillRect(1450,250, 200, 10);
		   g.setColor(new Color(220,20,60));
		   g.fillRect(580, 690, 50, 60);
		   g.fillRect(1170,290, 50, 60);
		   g.setColor(new Color(75,0,130));
		   g.fillOval(1700, 50, 60, 80);
		   for (int i = 0; i < rects.length; i++) {
					boundz[i] = rects[i].getBounds();
				}
	}
	public void actionPerformed(ActionEvent e) {
		
		velY += accY;
		
	
		
		if (velX > 0) {
			velX -= accX;
		}
		else if (velX < 0) {
			velX += accX;
		}
		for (int i = 0; i < boundz.length; i++) {
			  rectx = rects[i].getCenterX();
			  recty = rects[i].getCenterY();
			  if (((x + velX) < rectx + ((rects[i].getWidth())/2) ) && ((x + velX)> rectx - ((rects[i].getWidth())/2) - 40 ) && ((y + velY) < recty + ((rects[i].getHeight())/2)) && ((y + velY) > recty - ((rects[i].getHeight())/2) - 40)){
		   velY = -velY/2;
		   collide = true;
		  }
			  else {
				  collide = false;
			  }
			  if (((x + velX) < 1700 + ((60)/2) ) && ((x + velX)> 1700 - ((60)/2) - 40 ) && ((y + velY) < 50 + ((80)/2)) && ((y + velY) > 50 - ((80)/2) - 40)){
				  endGame();
			  }
		}
		
		if (((x + velX) < 0  || (x + velX) > 1880) ) {
			velX = -velX;
			collide = true;
		}
	    if ((y + velY) < 0  || (y + velY) > 1040) {
			velY = -velY/2;
			collide = true;
		}
	    
	    for (int q = 0; q < deathEntity.length ; q++) {
			  deathx = deathEntity[q].getCenterX();
			  deathy = deathEntity[q].getCenterY();
			  if (((x + velX) < deathx + ((deathEntity[q].getWidth())/2) ) && ((x + velX)> deathx - ((deathEntity[q].getWidth())/2) - 40 ) && ((y + velY) < deathy + ((deathEntity[q].getHeight())/2)) && ((y + velY) > deathy - ((deathEntity[q].getHeight())/2) - 40)){
		   x = 50;
		   y = 250;
		  
		  }
	    }
		
	    if (!collide) {
		x += velX;
		y += velY;
			  }
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
		velX += -1;
	}
	public void right() {
		velY += 0;
		velX += 1;
	}
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			for (int i = 0; i < boundz.length; i++) {
				  tempVX = velX;
				  tempVY = velY - 2.5;
				  tempX += tempVX;
				  tempY += tempVY;
				  rectx = rects[i].getCenterX();
				  recty = rects[i].getCenterY();
				  if (((tempX < rectx + ((rects[i].getWidth())/2)) && (tempX > rectx - ((rects[i].getWidth())/2)) && (tempY < recty + ((rects[i].getHeight())/2)) && (tempY > recty - ((rects[i].getHeight())/2) - 40))){
					  velY = -velY;
			  }
				  else {
					  up();
				  }
		}
		}
		if (code == KeyEvent.VK_DOWN) {
			for (int i = 0; i < boundz.length; i++) {
				  tempVY = velY + 2.5;
				  tempVX = velX;
				  tempX += tempVX;
				  tempY += tempVY;
				  rectx = rects[i].getCenterX();
				  recty = rects[i].getCenterY();
				  if (((tempX < rectx + ((rects[i].getWidth())/2)) && (tempX > rectx - ((rects[i].getWidth())/2)) && (tempY < recty + ((rects[i].getHeight())/2)) && (tempY > recty - ((rects[i].getHeight())/2) - 40))){
					  velY = -velY;
			  }
				  else {
					  down();
				  }
		}
		}
		if (code == KeyEvent.VK_LEFT) {
			for (int i = 0; i < boundz.length; i++) {
				  tempVY = velY ;
				  tempVX = velX - 2.5;
				  tempX += tempVX;
				  tempY += tempVY;
				  rectx = rects[i].getCenterX();
				  recty = rects[i].getCenterY();
				  if (((tempX < rectx + ((rects[i].getWidth())/2)) && (tempX > rectx - ((rects[i].getWidth())/2)) && (tempY < recty + ((rects[i].getHeight())/2)) && (tempY > recty - ((rects[i].getHeight())/2) - 40))){
					  velX = -velX;
			  }
				  else {
					  left();
				  }
		}
		}
		if (code == KeyEvent.VK_RIGHT) {
			for (int i = 0; i < boundz.length; i++) {
				  tempVY = velY ;
				  tempVX = velX + 2.5;
				  tempX += tempVX;
				  tempY += tempVY;
				  rectx = rects[i].getCenterX();
				  recty = rects[i].getCenterY();
				  if (((tempX < rectx + ((rects[i].getWidth())/2)) && (tempX > rectx - ((rects[i].getWidth())/2)) && (tempY < recty + ((rects[i].getHeight())/2)) && (tempY > recty - ((rects[i].getHeight())/2) - 40))){
					  velX = -velX;
			      }
				  else {
					  right();
				  }
		      }
	    }
		}
	public void keyTyped(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {}
	
	

	
	
	
}
