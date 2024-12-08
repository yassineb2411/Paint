import java.awt.*;

public class TriangleShape extends Shape {

    public TriangleShape(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        int[] xPoints = {x1, x2, (x1 + x2) / 2};
        int[] yPoints = {y1, y2, y1 - (y2 - y1)};
        g.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public void resize(int x2, int y2) {
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public boolean contains(int x, int y) {
        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }
}
