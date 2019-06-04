import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class Menu {
   /*
    * THIS IS SUPPOSED TO BE THE DEATH SCREEN
    * 
    * 
    * 
    * 
    * THE NAMES ARE SWAPPED 
    * 
    * 
    * 
    * 
    * IM FULLY AWARE OF HOW ANNOYING THAT IS
    * 
    */
   @SuppressWarnings("serial")
private static class dScreen extends JPanel {
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawString( "You died", 20, 30 );
      }
   }
   public void paint(Graphics g){
       
       g.fillRect(0, 500, 600, 100);
       
   }

   
   private static class ButtonHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
    	  JFrame frame = new JFrame();
          frame.setSize(1200,600);
          frame.getContentPane().add(new deathScreen());
          frame.setLocationRelativeTo(null);
          Color skyBlue = new Color(0, 176, 240);
          frame.setBackground(skyBlue);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setVisible(true);
      }
  }  
   
   public static void main(String[] args) {
      
      dScreen displayPanel = new dScreen();
      JButton okButton = new JButton("Return to Menu");
      ButtonHandler listener = new ButtonHandler();
      okButton.addActionListener(listener);

      JPanel content = new JPanel();
      content.setLayout(new BorderLayout());
      content.add(displayPanel, BorderLayout.CENTER);
      content.add(okButton, BorderLayout.SOUTH);

      JFrame window = new JFrame("GUI Test");
      window.setContentPane(content);
      window.setSize(250,100);
      window.setLocation(100,100);
      window.setVisible(true);

   }
   
}


