import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

public class PolygonEditorListener extends MouseAdapter
{
    @Override
    public void mousePressed(MouseEvent e) 
    {
        if (SwingUtilities.isLeftMouseButton(/*MouseEvent anEvent*/ e)) 
        {
            System.out.println(e.getX() + ", " + e.getY());
            ScreenUpdater.DrawPolygon();
        }
        else 
        {
            System.out.println("Right mouse key");
        }
    }
}
