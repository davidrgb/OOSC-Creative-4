package model.suits;

import java.awt.Color;
import java.awt.Graphics2D;

public class Heart extends Suit implements ISuitRender {
    
    public Heart(int xLocation, int yLocation) {
        super(xLocation, yLocation);
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.drawString("H", xLocation + 10, yLocation + 10);
    }
}
