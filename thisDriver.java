package amazingPackageOfAmazingness;

import java.awt.Component;

import javax.swing.JFrame;

public class thisDriver {
	public static void main(String args[])
    {
        Second s = new Second();
        JFrame f = new JFrame();
        f.add(s);
        f.setVisible(true);
        f.setSize(1920, 1080);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Moving Ball");
        Rectangle a = new Rectangle (150, 100, 100, 10);
    	Rectangle b = new Rectangle (300, 300, 100, 10);
    	Rectangle c = new Rectangle (450, 300, 300, 10);
    	Rectangle d = new Rectangle (800, 300, 125, 10);
    	Rectangle e = new Rectangle (950, 300, 150, 10);
    	Rectangle g = new Rectangle (1100, 300, 200, 10);
    
               
    }
}
      