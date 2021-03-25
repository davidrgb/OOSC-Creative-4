package model;

import model.suits.ISuitRender;

public abstract class Card {

    private int value;
    private ISuitRender suit;
    //stack

    public Card(int value, String suit) {
        this.value = value;
        switch (suit) {
            case "Hearts":

                break;
            case "Diamonds":
                break;
            case "Clubs":
                break;
            case "Spades":
                break;
        }
    }

    public int getValue() {
        return value;
    }
}
