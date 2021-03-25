package model;

import java.awt.Graphics2D;

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

    public int getxLocation() {
        return xLocation;
    }

    public int getyLocation() {
        return yLocation;
    }

    public void render(Graphics2D g2) {
        suit.render(g2);
    }

    public void updateLocation(int xLocation, int yLocation) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        suit.updateLocation(xLocation, yLocation);
    }

    @Override
    public String toString() {
        return "Rank: " + value + " Suit: " + suit;
    }
}
