import javax.swing.*;
import java.awt.*;

public class PaintApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Paint Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            DrawingPanel drawingPanel = new DrawingPanel();

            ToolbarPanel toolbarPanel = new ToolbarPanel(drawingPanel);

            frame.add(toolbarPanel, BorderLayout.NORTH);
            frame.add(drawingPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}
