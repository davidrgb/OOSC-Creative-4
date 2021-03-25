package model.suits;

import java.awt.Color;
import java.awt.Graphics2D;

public class Diamond extends Suit implements ISuitRender {

    private final int X_OFFSET = 0;
    private final int Y_OFFSET = 0;

    private final int TOP_RIGHT_OFFSET_X = 55;
    private final int TOP_RIGHT_OFFSET_Y = 4;

    private final int MID_POINTS_OFFSET = 2;

    private final int BOUNDS = 20;

    public Diamond(int xLocation, int yLocation) {
        super(xLocation, yLocation);
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(Color.RED);

        int[] xPoints = new int[4];
        int[] yPoints = new int[4];

        xPoints[0] = xLocation + TOP_RIGHT_OFFSET_X + X_OFFSET + BOUNDS / 2;
        yPoints[0] = yLocation + TOP_RIGHT_OFFSET_Y + Y_OFFSET;

        xPoints[1] = xLocation + TOP_RIGHT_OFFSET_X + X_OFFSET + BOUNDS - MID_POINTS_OFFSET;
        yPoints[1] = yLocation + TOP_RIGHT_OFFSET_Y + Y_OFFSET + BOUNDS / 2;

        xPoints[2] = xLocation + TOP_RIGHT_OFFSET_X + X_OFFSET + (BOUNDS / 2);
        yPoints[2] = yLocation + TOP_RIGHT_OFFSET_Y + Y_OFFSET + BOUNDS;

        xPoints[3] = xLocation + TOP_RIGHT_OFFSET_X + X_OFFSET + MID_POINTS_OFFSET;
        yPoints[3] = yLocation + TOP_RIGHT_OFFSET_Y + Y_OFFSET + BOUNDS / 2;

        g2.fillPolygon(xPoints, yPoints, xPoints.length);
    }
    
}
