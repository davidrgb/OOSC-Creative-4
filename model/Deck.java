package model;

import java.awt.Color;
import java.awt.Graphics2D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    private final int X_OFFSET = 10;
    private final int Y_OFFSET = 40;

    private static final int CARD_WIDTH = 80;
    private static final int CARD_HEIGHT = 120;
    private final int INNER_OFFSET = 10;
    
    private ArrayList<Card> cards = new ArrayList<>();

    public Deck() {
        createDeck();
        shuffleDeck();
    }

    private void createDeck() {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 14; j++) {
                if (j < 2 || j > 10) {
                    cards.add(new LetterCard(j, i));
                }
                else {
                    cards.add(new NumberCard(j, i));
                }
            }
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        Random rand = new Random();
        int index = rand.nextInt(cards.size());
        Card card = cards.get(index);
        cards.remove(index);
        return card;
    }

    public int size() {
        return cards.size();
    }

    public void render(Graphics2D g2) {
        if (cards.size() > 0) {
            int cardXLocation = X_OFFSET + INNER_OFFSET;
            int cardYLocation = Y_OFFSET;
            g2.setColor(Color.red);
            g2.fillRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT);
            g2.setColor(Color.black);
            g2.drawRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT); 
        } 
    }
}
