package model.suits;

import java.awt.Color;
import java.awt.Graphics2D;

public class Diamond extends Suit implements ISuitRender {

    public Diamond(int xLocation, int yLocation) {
        super(xLocation, yLocation);
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.drawString("D", xLocation + 10, yLocation + 10);
    }
    
}
