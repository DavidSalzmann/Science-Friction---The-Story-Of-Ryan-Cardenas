package amazingPackageOfAmazingness;

/*
 * original HelloWorldGUI2 from:
 * http://math.hws.edu/javanotes/c6/s1.html
 * original LoadImageAppfrom:
 * https://docs.oracle.com/javase/tutorial/2d/images/examples/LoadImageApp.java
 * line setting userprofile variable from:
 * https://stackoverflow.com/questions/11218943/how-do-i-add-a-userprofile-variable-normally-userprofile
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Color;
import java.awt.FlowLayout;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
 

public class trustMachine {
   private static class HelloWorldDisplay extends JPanel {
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawString( "Welcome to Science Friction-The Story of Ryan Cardenas!", 30, 50 );
      }//text to put on the open menu
   }
 
   
   private static class ButtonHandler implements ActionListener {
	      public void actionPerformed(ActionEvent e) {
	    	  JFrame frame = new JFrame();
	    	  //when the button is clicked, a Level 1 window is made
	          frame.setSize(1920,1100);
	          //makes a full screen window
	          
	          //LoadImageApp has the ode the start the game
	          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	          frame.setVisible(true);
	          Second s = new Second();
		      //opens the second class with the game code
		      frame.add(s);
		      frame.setVisible(true);
		      frame.setSize(1920, 1080);
		      //full screen size
		      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		       frame.setTitle("Moving Ball-Level 1");  
	      }
	  }
   
   public static void main(String[] args) {
      
      HelloWorldDisplay displayPanel = new HelloWorldDisplay();
      JButton okButton = new JButton("Level 1");
      ButtonHandler listener = new ButtonHandler();
      okButton.addActionListener(listener);
      //the start menu is made, it has a start button
      //which initiates ActionListener if clicked
      //ActionListner will then make the background image appear
      JPanel content = new JPanel();
      content.setLayout(new BorderLayout());
      content.add(displayPanel, BorderLayout.CENTER);
      content.add(okButton, BorderLayout.SOUTH);

      JFrame window = new JFrame("Menu");
      window.setContentPane(content);
      window.setSize(400,200);
      window.setLocation(955,550);
      window.setVisible(true);
      //sizes, names, and locates the menu, then makes it visible

   }
}
