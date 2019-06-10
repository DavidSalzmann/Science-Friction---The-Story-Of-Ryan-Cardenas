package amazingPackageOfAmazingness;


import javax.imageio.ImageIO;   //packages we import and implement 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.File;
import java.io.IOException;


public class Second extends JPanel implements ActionListener, KeyListener{
	Timer t = new Timer(10, this);  //timer to implement changes every click (10 milliseconds)
	double x = 250, y = 250, velX = 0, velY = 0, accY = .8, m = 25, mew = .1,  accX = accY*mew;  //initializing variables
	double rectx = 0;  //placeholder for a certain rectangle x center
	double recty = 0;  //placeholder for a certain rectangle y center
	double tempX = 0;  //Temporary x so that x could be changed 
	double tempY = 0;  //Temporary y so that y could be changed 
	double tempVX = 0; //Temporary vx so that vx could be changed 
	double tempVY = 0; //Temporary vy so that vy could be changed 
	double deathx = 0; //placeholder for a certain death rectangle x center
	double deathy = 0; //placeholder for a certain death rectangle x center
	boolean collide = false;  //used to check for collision with rectangles
	Ellipse2D circle ;  
	Rectangle2D a = new Rectangle2D.Double(105, 950, 100, 10);   //creates the platforms to jump on
	Rectangle2D b = new Rectangle2D.Double(300, 850, 100, 10);
	Rectangle2D c = new Rectangle2D.Double(450, 750, 300, 10);
	Rectangle2D d = new Rectangle2D.Double(800, 650, 125, 10);
	Rectangle2D e = new Rectangle2D.Double(950, 550, 150, 10);
	Rectangle2D f = new Rectangle2D.Double(1100,350, 200, 10);
	Rectangle2D h = new Rectangle2D.Double(1450,250, 200, 10);
	Rectangle2D i = new Rectangle2D.Double(0,0,0,0);  //this the ghost of a lost rectangle
	
	
	Rectangle2D death1 = new Rectangle2D.Double(580, 690, 50, 60);   //creates the death rectangles
	Rectangle2D death2 = new Rectangle2D.Double(1170,290, 50, 60);
	Rectangle2D[] deathEntity = {death1, death2};  //array of death rectangles
	
	Rectangle2D[] rects = {a, b, c, d, e, f, h, i};  //array of regular rectangles

	
	public void endGame() {  //movie and ends the game
		System.exit(0);
	}

	
	public Second() {  
		t.restart();  //restarts the timer
		addKeyListener(this);  //checks to see what keys have been pressed
		setFocusable(true);  
		setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(Graphics g) {  //draws everything
		super.paintComponent(g); 
		Graphics2D g2 = (Graphics2D) g;  //everything is a g
		g.setColor(new Color(204, 242, 255)); 
		g.fillRect(0, 0, 1920, 1080);
		circle = new Ellipse2D.Double(x, y, 40, 40);
		g.setColor(new Color(147, 112, 219));
		g2.fill(circle);
		   g.setColor(new Color(126, 200, 80));    //shows the boxes and or circles and or death rectangles
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
		  
	}
	public void actionPerformed(ActionEvent e) {  //whenever an action is performed
		
		velY += accY;  //adds "gravity"
		
	
		
		if (velX > 0) {  //checks to see which way to make acceleration go bc it should move in the opposite direction bc friction
			velX -= accX;
		}
		else if (velX < 0) {  //same as above
			velX += accX;
		}
		for (int i = 0; i < rects.length; i++) {   //checks to see collision of the circle player and rectangles
			  rectx = rects[i].getCenterX();
			  recty = rects[i].getCenterY();
			  //
			  if (((x + velX) < rectx + ((rects[i].getWidth())/2) ) && ((x + velX)> rectx - ((rects[i].getWidth())/2) - 40 ) && ((y + velY) < recty + ((rects[i].getHeight())/2)) && ((y + velY) > recty - ((rects[i].getHeight())/2) - 40)){  //checks to see if circle is colliding with rectangle boundaries 
		   velY = -velY/2;  //makes it so that collision is not perfectly elastic 
		   if (velX > -0.1 && velX < 0.1) //friction code - makes sure that when the ball velocity approaches 0 stays that way
		    {
		    	velX = 0;
		    }
	   		if (x > 700 && velX > 0) //past 700 different friction is implemented & checks to see which way to make acceleration go bc it should move in the opposite direction bc friction
	   		{
	   			velX -= (m  * mew) / 70;
	   			
	   		}
	   		if (x > 700 && velX < 0)  //same as above comment
	   		{
	   			velX += (m  * mew) / 70;
	   			
	   		}
		   collide = true;  //when it intersects with a rectangle
		  }
			  else {
				  collide = false;  //if it is not intersecting collide should be false
			  }
			  if (((x + velX) < 1700 + ((60)/2) ) && ((x + velX)> 1700 - ((60)/2) - 40 ) && ((y + velY) < 50 + ((80)/2)) && ((y + velY) > 50 - ((80)/2) - 40)){  //if the player collides with the ellipse at the far right
				  endGame();  //ends the game and closes the window
			  }
		}
		
		if (((x + velX) < 0  || (x + velX) > 1880) ) {  //checks x boundaries
			velX = -velX;
			collide = true;
		}
	    if ((y + velY) < 0  || (y + velY) > 1040) {  //checks y boundaries
			velY = -velY/2;
			collide = true;
		}
	    
	    for (int q = 0; q < deathEntity.length ; q++) {  //iterates through every death rectangle
			  deathx = deathEntity[q].getCenterX();
			  deathy = deathEntity[q].getCenterY();
			  if (((x + velX) < deathx + ((deathEntity[q].getWidth())/2) ) && ((x + velX)> deathx - ((deathEntity[q].getWidth())/2) - 40 ) && ((y + velY) < deathy + ((deathEntity[q].getHeight())/2)) && ((y + velY) > deathy - ((deathEntity[q].getHeight())/2) - 40)){  //checks to see if future position will be colliding with the death rectangle
		   x = 50;   //if it does then it moves it to this starting point
		   y = 250;
		  
		  }
	    }
		
	    if (!collide) {  //as long as there is no collision then it allows x and y to change
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
	public void keyPressed(KeyEvent e) {  //when a key is pressed it triggers this class
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_UP) {  //if up is clicked
			for (int i = 0; i < rects.length; i++) {  //basically checks to see that if moving the object if it will collide with any rectangles in the array
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
					  up();  //if not colliding then allows movement
				  }
		}
		}
		if (code == KeyEvent.VK_DOWN) { //if down is clicked
			for (int i = 0; i < rects.length; i++) {  //basically checks to see that if moving the object if it will collide with any rectangles in the array
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
					  down(); //if not colliding then allows movement
				  }
		}
		}
		if (code == KeyEvent.VK_LEFT) { //if left is clicked
			for (int i = 0; i < rects.length; i++) {  //basically checks to see that if moving the object if it will collide with any rectangles in the array
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
					  left(); //if not colliding then allows movement
				  }
		}
		}
		if (code == KeyEvent.VK_RIGHT) { //if right is clicked
			for (int i = 0; i < rects.length; i++) {  //basically checks to see that if moving the object if it will collide with any rectangles in the array
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
					  right(); //if not colliding then allows movement
				  }
		      }
	    }
		}
	public void keyTyped(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {}
	
	

	
	
	
}
