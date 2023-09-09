import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DraggableMouseAdapter extends MouseAdapter {
    private Point startPoint;
    private Point startLocation;

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();
        startLocation = e.getComponent().getLocation();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (startPoint != null && startLocation != null) {
            int deltaX = e.getX() - startPoint.x;
            int deltaY = e.getY() - startPoint.y;

            Point newLocation = new Point(startLocation.x + deltaX, startLocation.y + deltaY);
            e.getComponent().setLocation(newLocation);
        }
    }
}

