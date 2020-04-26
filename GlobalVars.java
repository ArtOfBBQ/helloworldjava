import java.awt.Polygon;
import javax.swing.JFrame;
import java.awt.Graphics;

public class GlobalVars
{
    // Screen
    public static final int WIDTH = 640;
    public static final int HEIGHT = 400;

    public static JFrame appWindow = new JFrame(/*String title*/ "Polygon designer");
    public static Graphics appGraphics;

    // The polygon we're editing with this app
    public static Polygon UserDesign = new Polygon();
}
