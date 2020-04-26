import java.awt.Color;

public class ScreenUpdater
{
    public static void DrawPolygon()
    {        
        GlobalVars.appGraphics.setColor(
            /*Baby blue*/
            new Color(/*Red*/ 125, /*Green*/ 175, /*Blue*/ 255));
          
        GlobalVars.appGraphics.fillPolygon(/*Polygon p*/ GlobalVars.UserDesign);
    }
}
