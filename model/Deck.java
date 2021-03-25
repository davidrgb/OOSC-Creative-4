package model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    
    //private static final int CARD_WIDTH = 80;
    //private static final int CARD_HEIGHT = 120;
    //private final int INNER_OFFSET = 10;

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
}
