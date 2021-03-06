import java.awt.Polygon;
import javax.swing.JFrame;
import java.awt.Graphics;

public class GlobalVars
{
    // Screen
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;

    // the size of one of the 'polygon corner' point widgets on screen
    public static final int POINTSIZE = 10;

    public static JFrame appWindow = new JFrame(/*String title*/ "Polygon designer");
    public static Graphics appGraphics;

    // The polygon we're editing with this app
    public static Polygon UserDesign = new Polygon();
}
