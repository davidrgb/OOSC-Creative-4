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

public class Stack extends Group {

    private int xOffset;
    private final int Y_OFFSET = 40;

    private static final int CARD_WIDTH = 80;
    private static final int CARD_HEIGHT = 120;
    private static final int STACKED_CARD_HEIGHT = 25;
    private final int INNER_OFFSET = 10;

    private int coveredCards = -1;

    private int selectedCardIndex;
    
    public Stack(int xOffset) {
        super();
        this.xOffset = xOffset;
    }

    public void incrementCoveredCards() {
        coveredCards++;
    }

    public void decreaseCoveredCards(int decrease) {
        coveredCards -= decrease;
    }

    public void render(Graphics2D g2) {
        for (int i = 0; i < cards.size(); i++) {
            int cardXLocation = xOffset + INNER_OFFSET;
            int cardYLocation = Y_OFFSET;

            g2.setColor(Color.white);
            if (cards.get(i).getxLocation() == 0) cards.get(i).updateLocation(cardXLocation, cardYLocation);
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

    /*@Override
    /public Card getSelectedCard(int mouseY) {
        selectedCardIndex = (mouseY - Y_OFFSET) / STACKED_CARD_HEIGHT + coveredCards - 1;
        if (selectedCardIndex >= cards.size()) {
            selectedCardIndex = cards.size() - 1;
        }
        return cards.get(selectedCardIndex);
    }*/

    @Override
    public void remove(int index) {
        super.remove(index);
        if (cards.size() == coveredCards) {
            coveredCards--;
        }
    }
    @Override
    public int getSelectedCard(int mouseY) {
        selectedCardIndex = (mouseY - Y_OFFSET) / STACKED_CARD_HEIGHT + coveredCards - 1;
        if (selectedCardIndex >= cards.size()) {
            selectedCardIndex = cards.size() - 1;
        }
        return selectedCardIndex;
    }

    @Override
    public Rectangle getBoundingBox() {
        int boxHeight = ((cards.size() - coveredCards) - 1) * STACKED_CARD_HEIGHT + CARD_HEIGHT;
        if (boxHeight < 1) boxHeight = 1;
        return new Rectangle(xOffset + INNER_OFFSET, Y_OFFSET, CARD_WIDTH, boxHeight);
    }

    public boolean transfer(ArrayList<Card> cards) {
        ISuitRender cardSuit = cards.get(0).getSuit();
        if (this.cards.size() > 0) {
            int topValue = this.cards.get(this.cards.size() - 1).getValue();
            if (suitCheck(cardSuit, this.cards.get(this.cards.size() - 1)) && cards.get(0).getValue() == topValue - 1) {
                for (int i = 0; i < cards.size(); i++) {
                    int cardXLocation = xOffset + INNER_OFFSET;
                    int cardYLocation = Y_OFFSET + (this.cards.size() - coveredCards) * STACKED_CARD_HEIGHT;

                    cards.get(i).updateLocation(cardXLocation, cardYLocation);
                    this.cards.add(cards.get(i));
                }
                return true;
            }
        }
        else if (cards.get(0).getValue() == 13) {
            for (int i = 0; i < cards.size(); i++) {
                int cardXLocation = xOffset + INNER_OFFSET;
                int cardYLocation = Y_OFFSET + (this.cards.size() - coveredCards) * STACKED_CARD_HEIGHT;

                cards.get(i).updateLocation(cardXLocation, cardYLocation);
                this.cards.add(cards.get(i));
            }
            return true;
        }
        return false;
    }

    public boolean suitCheck(ISuitRender suit, Card card) {
        if ((suit instanceof Heart || suit instanceof Diamond) && (card.getSuit() instanceof Club || card.getSuit() instanceof Spade)) {
            return true;
        }
        else if ((suit instanceof Club || suit instanceof Spade) && (card.getSuit() instanceof Heart || card.getSuit() instanceof Diamond)) {
            return true;
        }
        return false;
    }
}
