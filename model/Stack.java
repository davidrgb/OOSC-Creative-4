package model;

import java.util.ArrayList;

public class Stack {
    
    ArrayList<Card> cards;

    public Stack() {
        cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public int size() {
        return cards.size();
    }
}
