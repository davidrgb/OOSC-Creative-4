package model;

import model.suits.Club;
import model.suits.Diamond;
import model.suits.Heart;
import model.suits.ISuitRender;
import model.suits.Spade;

public abstract class Card {

    private int value;
    private ISuitRender suit;
    //stack

    private int xLocation;
    private int yLocation;

    public Card(int value, int suit) {
        xLocation = -1;
        yLocation = -1;

        this.value = value;
        switch (suit) {
            case 1:
                this.suit = new Heart(xLocation, yLocation);
                break;
            case 2:
                this.suit = new Diamond(xLocation, yLocation);
                break;
            case 3:
                this.suit = new Club(xLocation, yLocation);
                break;
            case 4:
                this.suit = new Spade(xLocation, yLocation);
                break;
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Rank: " + value + " Suit: " + suit;
    }
}
