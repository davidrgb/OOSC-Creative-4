package model.groups;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import java.util.ArrayList;

public class Waste extends Group {
    
    private int xOffset;
    private final int Y_OFFSET = 40;

    private static final int CARD_WIDTH = 80;
    private static final int CARD_HEIGHT = 120;
    private final int INNER_OFFSET = 10;

    public Waste(int xOffset) {
        super();
        this.xOffset = xOffset;
    }

    public void render(Graphics2D g2) {

        int cardXLocation = xOffset + INNER_OFFSET;
        int cardYLocation = Y_OFFSET;

        if (cards.size() > 0) {
            cards.get(cards.size() - 1).updateLocation(cardXLocation, cardYLocation);
            g2.setColor(Color.white);
            g2.fillRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT);
            g2.setColor(Color.black);
            g2.drawRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT); 
            cards.get(cards.size() - 1).render(g2);
        }
    }

    public void emptyWaste() {
        cards = new ArrayList<>();
    }

    @Override
    public Rectangle getBoundingBox() {
        return new Rectangle(xOffset + INNER_OFFSET, Y_OFFSET, CARD_WIDTH, CARD_HEIGHT);
    }
}
