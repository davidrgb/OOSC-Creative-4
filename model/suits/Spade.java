package model.suits;

import java.awt.Color;
import java.awt.Graphics2D;

public class Spade extends Suit implements ISuitRender {

    public Spade(int xLocation, int yLocation) {
        super(xLocation, yLocation);
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.drawString("S", xLocation + 10, yLocation + 10);
    }
    
}
