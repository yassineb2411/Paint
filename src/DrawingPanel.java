import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {
    private List<Shape> shapes = new ArrayList<>();
    private Shape currentShape = null;
    private String selectedTool = "Rectangle";
    private Color selectedColor = Color.RED;

    public DrawingPanel() {
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                switch (selectedTool) {
                    case "Rectangle":
                        currentShape = new RectangleShape(e.getX(), e.getY(), e.getX(), e.getY(), selectedColor);
                        break;
                    case "Cercle":
                        currentShape = new CircleShape(e.getX(), e.getY(), e.getX(), e.getY(), selectedColor);
                        break;
                    case "Triangle":
                        currentShape = new TriangleShape(e.getX(), e.getY(), e.getX(), e.getY(), selectedColor);
                        break;
                    case "Dessin":
                        currentShape = new FreehandShape(selectedColor);
                        ((FreehandShape) currentShape).addPoint(e.getX(), e.getY());
                        shapes.add(currentShape);
                        break;
                    case "Gomme":
                        shapes.removeIf(shape -> shape.contains(e.getX(), e.getY()));
                        repaint();
                        break;
                }
                if (currentShape != null && !"Dessin".equals(selectedTool) && !"Gomme".equals(selectedTool)) {
                    shapes.add(currentShape);
                }
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                currentShape = null;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (currentShape != null) {
                    switch (selectedTool) {
                        case "Rectangle":
                        case "Cercle":
                        case "Triangle":
                            currentShape.resize(e.getX(), e.getY());
                            break;
                        case "Dessin":
                            if (currentShape instanceof FreehandShape) {
                                ((FreehandShape) currentShape).addPoint(e.getX(), e.getY());
                            }
                            break;
                    }
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (Shape shape : shapes) {
            shape.draw(g2d);
        }
    }

    public void setSelectedTool(String tool) {
        this.selectedTool = tool;
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(Color color) {
        this.selectedColor = color;
    }
}
