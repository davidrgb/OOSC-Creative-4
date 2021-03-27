package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import model.Game;

public class GameCanvas extends JPanel {

    private GamePanel panel;

    private final int X_RESOLUTION = 1250;
    private final int Y_RESOLUTION = 750;

    private int xOffset;
    private int yOffset;

    private int xLocationMarker;
    private int yLocationMarker;

    public GameCanvas(GamePanel panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(X_RESOLUTION, Y_RESOLUTION));
        setBackground(Color.green);
        xLocationMarker = -15;
        yLocationMarker = -15;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        panel.render(g2);

        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Courier New", Font.BOLD, 36));

        panel.render(g2);

        g2.setColor(Color.blue);
        g2.fillOval(xLocationMarker, yLocationMarker, 10, 10);

        if (panel.getGame().getState() == Game.STATE.WIN) {
            xOffset = (X_RESOLUTION / 2) - (g.getFontMetrics().stringWidth("YOU WIN") / 2);
            yOffset = 725;
            g2.setColor(Color.white);
            g2.drawString("YOU WIN", xOffset, yOffset);
        }
    }

    public void setMarkerLocation(int xLocationMarker, int yLocationMarker) {
        this.xLocationMarker = xLocationMarker;
        this.yLocationMarker = yLocationMarker;
    }
    
}
