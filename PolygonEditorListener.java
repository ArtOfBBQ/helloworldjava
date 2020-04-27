import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import java.awt.Polygon;

public class PolygonEditorListener extends MouseAdapter
{
    @Override
    public void mousePressed(MouseEvent e) 
    {
        if (SwingUtilities.isLeftMouseButton(/*MouseEvent anEvent*/ e)) 
        {
            GlobalVars.UserDesign.addPoint(e.getX(), e.getY());
            
            ScreenUpdater.DrawPolygon();
        }
        else 
        {            
            // check if any of the polygons are close to this click
            for (var i = 0; i < GlobalVars.UserDesign.npoints; i++) 
            {
                System.out.println(i);

                if (Math.abs(e.getX() - GlobalVars.UserDesign.xpoints[i])
                        <= (GlobalVars.POINTSIZE / 2)
                    && Math.abs(e.getY() - GlobalVars.UserDesign.ypoints[i])
                        <= (GlobalVars.POINTSIZE / 2))
                {
                    // This is one of the things I hate about
                    // pre-defined classes like Polygon. It has 1000 methods
                    // I don't need and won't use, but it doesn't
                    // support removing a point because the points are defined
                    // as fixed arrays.....
                    //
                    // I guess I'm forced
                    // to create a new polygon and copy each point except
                    // the one I want to delete? Or if I was smart I could,
                    // now that I understand this class doesn't fit my need,
                    // ditch it and implement it by myself.
                    // choices choices...
                    System.out.println("Delete " + i);
                    Polygon tempCopyForDelete = new Polygon();
                    for (var y = 0; y < GlobalVars.UserDesign.npoints; y++) 
                    {
                        if (i == y) { continue; }
                        tempCopyForDelete.addPoint(
                            /* x */ GlobalVars.UserDesign.xpoints[y],
                            /* y */ GlobalVars.UserDesign.ypoints[y]);
                    }
                    GlobalVars.UserDesign.xpoints = tempCopyForDelete.xpoints;
                    GlobalVars.UserDesign.ypoints = tempCopyForDelete.ypoints;
                    GlobalVars.UserDesign.npoints = tempCopyForDelete.npoints;
                    
                    break;
                }
            }
            
            ScreenUpdater.DrawPolygon();
        }
    }
}
