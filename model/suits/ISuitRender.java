package model.suits;

import java.awt.Graphics2D;

public interface ISuitRender {
    void render(Graphics2D g2);
    void updateLocation(int xLocation, int yLocation);
}
