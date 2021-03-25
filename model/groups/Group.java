package model.groups;

import java.awt.Graphics2D;

import java.util.ArrayList;

import model.Card;

public abstract class Group {

    ArrayList<Card> cards;

    public Group() {
        cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public int size() {
        return cards.size();
    }

    public String contents() {
        return cards.size() + " " + cards;
    }

    public void render(Graphics2D g2) {
        cards.get(cards.size() - 1).render(g2);
    }
}
