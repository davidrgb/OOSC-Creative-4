package model.groups;

import java.awt.Graphics2D;
import java.awt.Rectangle;

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

    public void remove(int index) {
        cards.remove(index);
    }

    public int size() {
        return cards.size();
    }

    public void render(Graphics2D g2) {
        cards.get(cards.size() - 1).render(g2);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getSelectedCard(int mouseY) {
        return cards.size() - 1;
    }

    public abstract Rectangle getBoundingBox();

    public abstract boolean transfer(ArrayList<Card> cards);
}
