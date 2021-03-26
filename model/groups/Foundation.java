package model.groups;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import model.Card;
import model.suits.Club;
import model.suits.Diamond;
import model.suits.Heart;
import model.suits.ISuitRender;
import model.suits.Spade;

public class Foundation extends Group {

    private int xOffset;
    private final int Y_OFFSET = 40;

    private static final int CARD_WIDTH = 80;
    private static final int CARD_HEIGHT = 120;
    private final int INNER_OFFSET = 10;

    private ISuitRender suit;
    
    public Foundation(int xOffset, int suit) {
        super();
        this.xOffset = xOffset;
        switch (suit) {
            case 1:
                this.suit = new Heart(xOffset - 15, Y_OFFSET + CARD_HEIGHT / 2 - 15);
                break;
            case 2:
                this.suit = new Diamond(xOffset - 15, Y_OFFSET + CARD_HEIGHT / 2 - 15);
                break;
            case 3:
                this.suit = new Club(xOffset - 15, Y_OFFSET + CARD_HEIGHT / 2 - 15);
                break;
            case 4:
                this.suit = new Spade(xOffset - 15, Y_OFFSET + CARD_HEIGHT / 2 - 15);
                break;
        }
    }

    public void render(Graphics2D g2) {

        int cardXLocation = xOffset + INNER_OFFSET;
        int cardYLocation = Y_OFFSET;

        if (cards.size() == 0) {
            g2.setColor(Color.white);
            g2.fillRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT);
            g2.setColor(Color.black);
            g2.drawRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT); 
            suit.render(g2);
        } else {
            cards.get(cards.size() - 1).updateLocation(cardXLocation, cardYLocation);
            g2.setColor(Color.white);
            g2.fillRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT);
            g2.setColor(Color.black);
            g2.drawRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT); 
            cards.get(cards.size() - 1).render(g2);
        }
    }

    @Override
    public Rectangle getBoundingBox() {
        return new Rectangle(xOffset + INNER_OFFSET, Y_OFFSET, CARD_WIDTH, CARD_HEIGHT);
    }

    public boolean transfer(ArrayList<Card> cards) {
        ISuitRender cardSuit = cards.get(0).getSuit();
        int topValue = this.cards.get(cards.size() - 1).getValue();
        if (cardSuit == this.suit && cards.get(0).getValue() == topValue + 1 && cards.size() == 1) {
            add(cards.get(0));
            return true;
        }
        return false;
    }
}
