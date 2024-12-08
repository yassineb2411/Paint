import javax.swing.*;
import java.awt.*;

public class ToolbarPanel extends JPanel {
    public ToolbarPanel(DrawingPanel drawingPanel) {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton rectButton = new JButton("Rectangle");
        rectButton.addActionListener(e -> drawingPanel.setSelectedTool("Rectangle"));

        JButton circleButton = new JButton("Cercle");
        circleButton.addActionListener(e -> drawingPanel.setSelectedTool("Cercle"));

        JButton triangleButton = new JButton("Triangle");
        triangleButton.addActionListener(e -> drawingPanel.setSelectedTool("Triangle"));

        JButton drawButton = new JButton("Dessin");
        drawButton.addActionListener(e -> drawingPanel.setSelectedTool("Dessin"));

        JButton eraserButton = new JButton("Gomme");
        eraserButton.addActionListener(e -> drawingPanel.setSelectedTool("Gomme"));

        JButton colorButton = new JButton("Couleur");
        colorButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(this, "Choisir une couleur", drawingPanel.getSelectedColor());
            if (selectedColor != null) {
                drawingPanel.setSelectedColor(selectedColor);
            }
        });

        add(rectButton);
        add(circleButton);
        add(triangleButton);
        add(drawButton);
        add(eraserButton);
        add(colorButton);
    }
}
