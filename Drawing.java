import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends Canvas {  
public static void main(String[] args) {
        JFrame frame = new JFrame("A Level");
        Canvas canvas = new Drawing();
        canvas.setSize(1920, 1080);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        Color skyBlue = new Color(0, 176, 254);
        frame.setBackground(skyBlue);
    }

    public void paint(Graphics g) {
        g.fillRect(105, 950, 100, 10);
        g.fillRect(300, 850, 100, 10);
        g.fillRect(450, 750, 300, 10);
        g.fillRect(800, 650, 125, 10);
        g.fillRect(950, 550, 150, 10);
        g.fillRect(1100, 350, 200, 10);
        g.fillOval(1300, 250, 50, 50);
        
    }

}