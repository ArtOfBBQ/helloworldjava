import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

public class PolygonEditorListener extends MouseAdapter
{
    @Override
    public void mousePressed(MouseEvent e) 
    {
        if (SwingUtilities.isLeftMouseButton(e)) 
        {
            System.out.println(e.getX() + ", " + e.getY());
        }
        else 
        {
            System.out.println("Right mouse key");
        }
        
    }
}