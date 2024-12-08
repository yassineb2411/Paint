import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FreehandShape extends Shape {
    private final List<Point> points = new ArrayList<>();

    public FreehandShape(Color color) {
        super(0, 0, 0, 0, color);
    }

    public void addPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        for (int i = 1; i < points.size(); i++) {
            Point p1 = points.get(i - 1);
            Point p2 = points.get(i);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    @Override
    public void resize(int x2, int y2) {
    }

    @Override
    public boolean contains(int x, int y) {
        for (Point point : points) {
            if (point.distance(x, y) < 5) {
                return true;
            }
        }
        return false;
    }
}
