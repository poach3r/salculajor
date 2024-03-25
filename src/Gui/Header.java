package Gui;

import Main.Main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Header extends JPanel {
    private final JLabel statusLabel;
    private Font font;
    private Border margin;

    public Header() {
        font = new Font(Font.MONOSPACED, Font.PLAIN, 12);
        margin = BorderFactory.createEmptyBorder();

        statusLabel = new JLabel("r > 0, 0 > 0.0");

        setLayout(new BorderLayout());
        add(statusLabel, BorderLayout.WEST);
        setVisible(true);
    }

    public void loadDecoration() {
        statusLabel.setForeground(Main.config.colors[2]);
        statusLabel.setFont(font);

        setBackground(Main.config.colors[1]);
        setBorder(margin);
    }

    public void updateText() {
        statusLabel.setText(Main.interactorLogic.getMode() + " > " + Main.interactorLogic.getLastDigit()[0] + ", " + Main.interactorLogic.getLastDigit()[1] + " > " + Main.interactorLogic.getValue());
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Border getMargin() {
        return margin;
    }

    public void setMargin(Border margin) {
        this.margin = margin;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
}
