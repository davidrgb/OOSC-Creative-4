package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import model.suits.Club;
import model.suits.Diamond; // Remove after testing
import model.suits.Heart; // Remove later after testing
import model.suits.Spade;

public class GameCanvas extends JPanel {

    private GamePanel panel;

    private final int X_RESOLUTION = 1300;
    private final int Y_RESOLUTION = 750;

    private int xOffset;

    public GameCanvas(GamePanel panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(X_RESOLUTION, Y_RESOLUTION));
        setBackground(Color.green);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        panel.render(g2);

        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Courier New", Font.BOLD, 36));

        panel.render(g2);

        /* if (panel.getGame().getState() == Game.State.WIN) {
            xOffset = (X_RESOLUTION / 2) - (g.getFontMetrics().stringWidth("YOU WIN") / 2);
            yOffset = 725;
            g2.drawString("YOU WIN", xOffset, yOffset);
        }*/
    }
    
}
