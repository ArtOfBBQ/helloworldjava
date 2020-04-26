import java.awt.Color;

public class ScreenUpdater
{
    public static void DrawPolygon()
    {        
        GlobalVars.appGraphics.setColor(
            /*Baby blue*/
            new Color(/*Red*/ 125, /*Green*/ 175, /*Blue*/ 255));
        
        GlobalVars.appGraphics.fillPolygon(/*Polygon p*/ GlobalVars.UserDesign);

        GlobalVars.appGraphics.setColor(Color.BLUE);
        for (var i = 0; i < GlobalVars.UserDesign.npoints; i++) 
        {
            // a circle to represent each corner coordinate that
            // the user can move around / delete for design
            GlobalVars.appGraphics.fillOval(
                /* x */ GlobalVars.UserDesign.xpoints[i] - 5,
                /* y */ GlobalVars.UserDesign.ypoints[i] - 5,
                /* width */ 10,
                /* height */ 10);
        }
    }
}
