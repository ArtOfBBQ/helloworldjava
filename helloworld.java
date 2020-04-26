import java.awt.Frame;

public class helloworld
{
    public static void main(String[] args)
    {
        final int WIDTH = 320;
        final int HEIGHT = 200;

        Frame screen = new Frame("I'm a frame title");

        screen.setBounds(40, 40, WIDTH, HEIGHT);
        screen.setVisible(true);
        
        System.out.println("hello there");
    }
}
