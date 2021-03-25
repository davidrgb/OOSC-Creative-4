package model;

import java.awt.Graphics2D;

public class NumberCard extends Card implements ICardRender {
    
    public NumberCard(int value, int suit) {
        super(value, suit);
    }

    @Override
    public void render(Graphics2D g2) {
        //render number card
    }
}
