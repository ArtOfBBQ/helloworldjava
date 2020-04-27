import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import java.awt.Polygon;

public class PolygonEditorListener extends MouseAdapter
{
    // set this to -1 when not moving any point,
    // 2 to represent "currently click & dropping point with index 2"
    public Integer DraggingPoint;

    @Override
    public void mousePressed(MouseEvent e) 
    {
        Integer firstCollision = firstPolygonPointCollision(/*MouseEvent clickToCheck*/ e);

        if (SwingUtilities.isLeftMouseButton(/*MouseEvent anEvent*/ e)) 
        {
            if (firstCollision == null)
            {
                if (DraggingPoint == null) 
                {
                    GlobalVars.UserDesign.addPoint(e.getX(), e.getY());
                }
                else 
                {
                    // release dragging point
                    GlobalVars.UserDesign.xpoints[DraggingPoint] = e.getX();
                    GlobalVars.UserDesign.ypoints[DraggingPoint] = e.getY();
                    DraggingPoint = null;
                }
            }
            else 
            {
                DraggingPoint = firstCollision;
            }
            
            ScreenUpdater.Update();
        }
        else
        {
            if (firstCollision == null) { return ;}
            
            // Now I understand that the pre-defined class Polygon
            // doesn't really fit my need at all. It has many
            // methods I won't need, and it doesn't support
            // removing points which is one of the main things
            // I need to be able to do. I should just refactor
            // this to use my own class or even just 2x ArrayList<int>
            System.out.println("Delete " + firstCollision);
            Polygon tempCopyForDelete = new Polygon();
            for (var i = 0; i < GlobalVars.UserDesign.npoints; i++) 
            {
                if (firstCollision == i) { continue; }
                tempCopyForDelete.addPoint(
                    /* x */ GlobalVars.UserDesign.xpoints[i],
                    /* y */ GlobalVars.UserDesign.ypoints[i]);
            }
            GlobalVars.UserDesign.xpoints = tempCopyForDelete.xpoints;
            GlobalVars.UserDesign.ypoints = tempCopyForDelete.ypoints;
            GlobalVars.UserDesign.npoints = tempCopyForDelete.npoints;
            
            ScreenUpdater.Update();
        }
    }

    private Integer firstPolygonPointCollision(MouseEvent clickToCheck)
    {
        for (var i = 0; i < GlobalVars.UserDesign.npoints; i++) 
        {
            if (Math.abs(clickToCheck.getX() - GlobalVars.UserDesign.xpoints[i])
                <= (GlobalVars.POINTSIZE / 2)
                && Math.abs(clickToCheck.getY() - GlobalVars.UserDesign.ypoints[i])
                    <= (GlobalVars.POINTSIZE / 2))
            {
                return i;
            }
        }

        return null;
    }
}
