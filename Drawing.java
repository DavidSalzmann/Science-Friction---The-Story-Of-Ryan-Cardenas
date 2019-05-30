import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends Canvas {  
public static void main(String[] args) {
        JFrame frame = new JFrame("Hopefully more than an oval");
        Canvas canvas = new Drawing();
        canvas.setSize(1920, 1080);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        Color skyBlue = new Color(0, 176, 254);
        frame.setBackground(skyBlue);
    }

    public void paint(Graphics g) {
        g.fillRect(150, 100, 100, 10);
        g.fillRect(300, 300, 100, 10);
        g.fillRect(500, 300, 100, 10);
        g.fillRect(700, 300, 100, 10);
        g.fillRect(900, 300, 400, 10);
      //  g.fillRect(2000,300, 600, 10);
        g.fillOval(2600, 300, 50, 50);
    }
  
}