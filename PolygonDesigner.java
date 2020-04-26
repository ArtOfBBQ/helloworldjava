import javax.swing.JFrame;
import java.awt.Color;

// This app is part of my 'write hello world in every language' efforts
// previously, I made a primitive game in Javascript (ASTROR) which uses
// polygon coordinates and HTML text as a weird graphics system.
// 
// This Java app should:
// 1. Draw a polygon on the screen representing a spaceship or an asteroid
// 2. The app shows the polygon coordinates of my awesome design
// 3. Copy the coordinates in the ASTROR source so I can see the design I made
//    in the game.
//
// (PS: The game stuff is for entertainment, this is functionally HelloWorld.java)
public class PolygonDesigner {
    public static void main(final String[] arguments)
    {
        GlobalVars.UserDesign.addPoint(/*int x*/ 4, /*int y*/ 31);
        GlobalVars.UserDesign.addPoint(5, 30);
        GlobalVars.UserDesign.addPoint(14, 29);
        GlobalVars.UserDesign.addPoint(15, 4);

        GlobalVars.appWindow.setSize(GlobalVars.WIDTH, GlobalVars.HEIGHT);
        GlobalVars.appWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GlobalVars.appWindow.getContentPane().addMouseListener(new PolygonEditorListener());
        GlobalVars.appWindow.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        GlobalVars.appWindow.setVisible(true);
        
        GlobalVars.appGraphics = GlobalVars.appWindow.getGraphics();
    }
}
