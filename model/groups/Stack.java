package model.groups;

import java.awt.Color;
import java.awt.Graphics2D;

public class Stack extends Group {

    private int xOffset;
    private final int Y_OFFSET = 40;

    private static final int CARD_WIDTH = 80;
    private static final int CARD_HEIGHT = 120;
    private static final int STACKED_CARD_HEIGHT = 25;
    private final int INNER_OFFSET = 10;

    private int coveredCards = -1;
    
    public Stack(int xOffset) {
        super();
        this.xOffset = xOffset;
    }

    public void incrementCoveredCards() {
        coveredCards++;
    }

    public void render(Graphics2D g2) {
        for (int i = 0; i < cards.size(); i++) {
            int cardXLocation = xOffset + INNER_OFFSET;
            int cardYLocation = Y_OFFSET;

            g2.setColor(Color.white);
            cards.get(i).updateLocation(cardXLocation, cardYLocation);
            if (i >= coveredCards) {
                if (i < cards.size() - 1) {
                    g2.fillRect(cardXLocation, cardYLocation + STACKED_CARD_HEIGHT * (i - coveredCards), CARD_WIDTH, STACKED_CARD_HEIGHT);
                    g2.setColor(Color.black);
                    g2.drawRect(cardXLocation, cardYLocation + STACKED_CARD_HEIGHT * (i - coveredCards), CARD_WIDTH, STACKED_CARD_HEIGHT);   
                }
                else {
                    g2.fillRect(cardXLocation, cardYLocation + STACKED_CARD_HEIGHT * (i - coveredCards), CARD_WIDTH, CARD_HEIGHT);
                    g2.setColor(Color.black);
                    g2.drawRect(cardXLocation, cardYLocation + STACKED_CARD_HEIGHT * (i - coveredCards), CARD_WIDTH, CARD_HEIGHT);  
                }
                cards.get(i).render(g2);
            }
        }

        if (cards.size() == 0) {
            int cardXLocation = xOffset + INNER_OFFSET;
            int cardYLocation = Y_OFFSET;
            g2.setColor(Color.red);
            g2.fillRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT);
            g2.setColor(Color.black);
            g2.drawRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT); 
        }

        /*for (int i = 0; i < cards.size(); i++) {
            int cardXLocation = xOffset + ((CARD_WIDTH + INNER_OFFSET));
            int cardYLocation = Y_OFFSET;

            g2.setColor(Color.white);
            if (i < cards.size() - 1) {
                g2.fillRect(cardXLocation, cardYLocation + STACKED_CARD_HEIGHT * i, CARD_WIDTH, STACKED_CARD_HEIGHT);
                g2.setColor(Color.black);
                g2.drawRect(cardXLocation, cardYLocation + STACKED_CARD_HEIGHT * i, CARD_WIDTH, STACKED_CARD_HEIGHT);   
            }
            else {
                g2.fillRect(cardXLocation, cardYLocation + STACKED_CARD_HEIGHT * i, CARD_WIDTH, CARD_HEIGHT);
                g2.setColor(Color.black);
                g2.drawRect(cardXLocation, cardYLocation + STACKED_CARD_HEIGHT * i, CARD_WIDTH, CARD_HEIGHT);  
            }
        }*/
    }  
}
