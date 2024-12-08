import java.awt.*;

public class RectangleShape extends Shape {

    public RectangleShape(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillRect(x1, y1, x2 - x1, y2 - y1);
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
