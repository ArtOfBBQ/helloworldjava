import java.awt.Frame;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;

// must inherit from Canvas and override "paint"
// in order for this standard library feature to work
public class helloworld extends Canvas
{
    public static void main(String[] args) {

        final int WIDTH = 320;
        final int HEIGHT = 200;
        
        Frame window = new Frame("I'm a frame title");
        Canvas screen = new helloworld();

        screen.setSize(WIDTH, HEIGHT);
        screen.setBackground(Color.pink);
        
        window.add(screen);
        window.setBounds(40, 40, WIDTH, HEIGHT);
        window.setVisible(true);
    }

    // overrides aren't marked as overrides?!
    public void paint(Graphics g) {
        g.setColor(new Color(125, 175, 255));
        g.fillOval(130, 70, 50, 50);
    }
}
