package model.suits;

public abstract class Suit {
    
    int xLocation;
    int yLocation;

    public Suit(int xLocation, int yLocation) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    public void updateLocation(int xLocation, int yLocation) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }
}
