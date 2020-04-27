import java.awt.Color;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class ScreenUpdater
{
    public static void Update()
    {
        GlobalVars.appGraphics.clearRect(
            /* x */ 0,
            /* y */ 0,
            /* width */ GlobalVars.WIDTH,
            /* height */ GlobalVars.HEIGHT);
        
        UpdateAppTitle();

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
                /* width */ GlobalVars.POINTSIZE,
                /* height */ GlobalVars.POINTSIZE);
        }
    }

    private static void UpdateAppTitle()
    {
        // get the user design centers so we can show relative
        // coordinates
        int smallestx = GlobalVars.UserDesign.xpoints[0];
        int biggestx = GlobalVars.UserDesign.xpoints[0];
        int smallesty = GlobalVars.UserDesign.ypoints[0];
        int biggesty = GlobalVars.UserDesign.ypoints[0];

        if (GlobalVars.UserDesign.npoints > 0) 
        {
            for (int i = 1; i < GlobalVars.UserDesign.npoints; i++) 
            {
                if (GlobalVars.UserDesign.xpoints[i] < smallestx) 
                {
                    smallestx = GlobalVars.UserDesign.xpoints[i];
                }
                else if (GlobalVars.UserDesign.xpoints[i] > biggestx) 
                {
                    biggestx = GlobalVars.UserDesign.xpoints[i];
                }
                
                smallesty = GlobalVars.UserDesign.ypoints[i] < smallesty ?
                    GlobalVars.UserDesign.ypoints[i]
                    : smallesty;

                biggesty = GlobalVars.UserDesign.ypoints[i] > biggesty ?
                    GlobalVars.UserDesign.ypoints[i]
                    : biggesty;
            }
        }
        
        int centerx = (biggestx + smallestx) / 2;
        int centery = (biggesty + smallesty) / 2;

        System.out.println("center x: " + centerx);
        System.out.println("center y: " + centery);

        // build string
        String Coordinates = "";
        for (int i = 0; i < GlobalVars.UserDesign.npoints; i++) 
        {
            if (Coordinates != "") { Coordinates += ","; }
            Coordinates += "["
                            + (GlobalVars.UserDesign.xpoints[i] - centerx)
                            + ","
                            + (GlobalVars.UserDesign.ypoints[i] - centery)
                            + "]";
        }

        StringSelection stringSelection = new StringSelection(Coordinates);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        
        GlobalVars.appWindow.setTitle("Design was copied to clipboard - " + Coordinates);
    }
}
