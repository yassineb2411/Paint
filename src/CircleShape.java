import java.awt.*;

public class CircleShape extends Shape {
    private int radius;

    public CircleShape(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
        this.radius = (int) Math.hypot(x2 - x1, y2 - y1);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x1 - radius, y1 - radius, radius * 2, radius * 2);
    }

    @Override
    public void resize(int x2, int y2) {
        this.radius = (int) Math.hypot(x2 - x1, y2 - y1);
    }

    @Override
    public boolean contains(int x, int y) {
        int distance = (int) Math.hypot(x - x1, y - y1);
        return distance <= radius;
    }
}
