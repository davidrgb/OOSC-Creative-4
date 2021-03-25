package model.suits;

import java.awt.Color;
import java.awt.Graphics2D;

public class Spade extends Suit implements ISuitRender {

    private final int X_OFFSET = 6;
    private final int Y_OFFSET = 6;

    private final int TOP_RIGHT_OFFSET_X = 55;
    private final int TOP_RIGHT_OFFSET_Y = 4;

    private final int BOUNDS = 20;
    private final int RADIUS = 6;
    private final int CIRCLE_OFFSET = 2;

    public Spade(int xLocation, int yLocation) {
        super(xLocation, yLocation);
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(Color.BLACK);

        int[] xPointsTop = new int[3];
        int[] yPointsTop = new int[3];

        xPointsTop[0] = xLocation + TOP_RIGHT_OFFSET_X + X_OFFSET + BOUNDS / 2 - RADIUS;
        yPointsTop[0] = yLocation + TOP_RIGHT_OFFSET_Y + Y_OFFSET - RADIUS - 1;

        xPointsTop[1] = xLocation + TOP_RIGHT_OFFSET_X + X_OFFSET + BOUNDS - RADIUS - 1;
        yPointsTop[1] = yLocation + TOP_RIGHT_OFFSET_Y + Y_OFFSET + BOUNDS / 3 - RADIUS;

        xPointsTop[2] = xLocation + TOP_RIGHT_OFFSET_X + X_OFFSET - RADIUS + 1;
        yPointsTop[2] = yLocation + TOP_RIGHT_OFFSET_Y + Y_OFFSET + BOUNDS / 3 - RADIUS;

        g2.fillPolygon(xPointsTop, yPointsTop, xPointsTop.length);
        
        g2.fillOval(xLocation + TOP_RIGHT_OFFSET_X + X_OFFSET - RADIUS, yLocation + TOP_RIGHT_OFFSET_Y + Y_OFFSET - RADIUS * 2 + BOUNDS / 2, RADIUS * 2, RADIUS * 2);
        g2.fillOval(xLocation + TOP_RIGHT_OFFSET_X + X_OFFSET - RADIUS + (RADIUS + CIRCLE_OFFSET), yLocation + TOP_RIGHT_OFFSET_Y + Y_OFFSET - RADIUS * 2 + BOUNDS / 2, RADIUS * 2, RADIUS * 2);

        int[] xPointsBottom = new int[3];
        int[] yPointsBottom = new int[3];

        xPointsBottom[0] = xLocation + TOP_RIGHT_OFFSET_X + X_OFFSET + BOUNDS / 2 - RADIUS;
        yPointsBottom[0] = yLocation + TOP_RIGHT_OFFSET_Y + Y_OFFSET + RADIUS;

        xPointsBottom[1] = xLocation + TOP_RIGHT_OFFSET_X + X_OFFSET + BOUNDS - RADIUS - BOUNDS / 3;
        yPointsBottom[1] = yLocation + TOP_RIGHT_OFFSET_Y + Y_OFFSET + BOUNDS - RADIUS;

        xPointsBottom[2] = xLocation + TOP_RIGHT_OFFSET_X + X_OFFSET - RADIUS + BOUNDS / 3;
        yPointsBottom[2] = yLocation + TOP_RIGHT_OFFSET_Y + Y_OFFSET + BOUNDS - RADIUS;

        g2.fillPolygon(xPointsBottom, yPointsBottom, xPointsBottom.length);
    }
    
}
