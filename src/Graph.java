import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

class ReczneWykresy {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ReczneWykresy::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Reczne Wykresy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new WykresPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class WykresPanel extends JPanel {
    private final int width = 800;
    private final int height = 600;

    private final int X = 2;
    private final int Y = -1000;

    private double[] zbior1X = {1.0, 2.5, 3.7, 4.2, 5.5};
    private double[] zbior1Y = {5.0, 2.0, 6.0, 4.5, 7.5};

    private double[] zbior2X = {1.5, 2.0, 3.2, 4.8, 5.2};
    private double[] zbior2Y = {4.0, 3.5, 5.8, 6.5, 6.0};

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Rysowanie punktów
        g2d.setColor(Color.RED);
        for (int i = 0; i < zbior1X.length; i++) {
            int x = (int) (zbior1X[i] * 50);
            int y = height - (int) (zbior1Y[i] * 50);
            g2d.fill(new Ellipse2D.Double(x - 3, y - 3, 6, 6));
        }

        g2d.setColor(Color.BLUE);
        for (int i = 0; i < zbior2X.length; i++) {
            int x = (int) (zbior2X[i] * 50);
            int y = height - (int) (zbior2Y[i] * 50);
            g2d.fill(new Ellipse2D.Double(x - 3, y - 3, 6, 6));
        }

        // Rysowanie funkcji
        g2d.setColor(Color.GREEN);
        for (int x = 50; x <= width - 50; x++) {
            int y = height - (int) (2 * (x - 50)); // y = 2x
            g2d.drawLine(x, y, x + 1, height - (int) (2 * (x - 49)));
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
}
