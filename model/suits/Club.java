package model.suits;

import java.awt.Color;
import java.awt.Graphics2D;

public class Club extends Suit implements ISuitRender {

    private final int X_OFFSET = 6;
    private final int Y_OFFSET = 6;

    private final int BOUNDS = 20;
    private final int RADIUS = 6;
    private final int CIRCLE_OFFSET = 2;
    
    public Club(int xLocation, int yLocation) {
        super(xLocation, yLocation);
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(Color.BLACK);

        g2.fillOval(xLocation + X_OFFSET - RADIUS * 2 + BOUNDS / 2, yLocation + Y_OFFSET - RADIUS, RADIUS * 2, RADIUS * 2);
        g2.fillOval(xLocation + X_OFFSET - RADIUS, yLocation + Y_OFFSET - RADIUS * 2 + BOUNDS / 2, RADIUS * 2, RADIUS * 2);
        g2.fillOval(xLocation + X_OFFSET - RADIUS + (RADIUS + CIRCLE_OFFSET), yLocation + Y_OFFSET - RADIUS * 2 + BOUNDS / 2, RADIUS * 2, RADIUS * 2);

        int[] xPoints = new int[3];
        int[] yPoints = new int[3];

        xPoints[0] = xLocation + X_OFFSET + BOUNDS / 2 - RADIUS;
        yPoints[0] = yLocation + Y_OFFSET + RADIUS;

        xPoints[1] = xLocation + X_OFFSET + BOUNDS - RADIUS - BOUNDS / 3;
        yPoints[1] = yLocation + Y_OFFSET + BOUNDS - RADIUS;

        xPoints[2] = xLocation + X_OFFSET - RADIUS + BOUNDS / 3;
        yPoints[2] = yLocation + Y_OFFSET + BOUNDS - RADIUS;

        g2.fillPolygon(xPoints, yPoints, xPoints.length);
    }
}
