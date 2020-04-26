import javax.swing.JFrame;

public class PolygonEditor {
    public static void main(final String[] arguments) {
        final int WIDTH = 320;
        final int HEIGHT = 200;

        final JFrame window = new JFrame("I'm a title!");

        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().addMouseListener(new PolygonEditorListener());
        window.setVisible(true);
        
    }
}
