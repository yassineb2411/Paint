import java.awt.*;

public abstract class Shape {
    protected int x1, y1, x2, y2;
    protected Color color;

    public Shape(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    public abstract void draw(Graphics2D g);

    public abstract void resize(int x2, int y2);

    public abstract boolean contains(int x, int y);
}
