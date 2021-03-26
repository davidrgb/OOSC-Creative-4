package model.groups;

import java.awt.Color;
import java.awt.Graphics2D;

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
                this.suit = new Heart(xOffset + CARD_WIDTH - 15, Y_OFFSET + CARD_HEIGHT / 2 - 15);
                break;
            case 2:
                this.suit = new Diamond(xOffset + CARD_WIDTH - 15, Y_OFFSET + CARD_HEIGHT / 2 - 15);
                break;
            case 3:
                this.suit = new Club(xOffset + CARD_WIDTH - 15, Y_OFFSET + CARD_HEIGHT / 2 - 15);
                break;
            case 4:
                this.suit = new Spade(xOffset + CARD_WIDTH - 15, Y_OFFSET + CARD_HEIGHT / 2 - 15);
                break;
        }
    }

    public void render(Graphics2D g2) {
        if (cards.size() == 0) {
            int cardXLocation = xOffset + ((CARD_WIDTH + INNER_OFFSET));
            int cardYLocation = Y_OFFSET;
            g2.setColor(Color.white);
            g2.fillRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT);
            g2.setColor(Color.black);
            g2.drawRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT); 
            suit.render(g2);
        }
    }

}
