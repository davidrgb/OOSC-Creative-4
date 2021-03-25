package model;

import java.awt.Graphics2D;

public class LetterCard extends Card implements ICardRender {

    private String rank;
    
    public LetterCard(int value, int suit) {
        super(value, suit);

        switch (value) {
            case 1:
                rank = "A";
                break;
            case 11:
                rank = "J";
                break;
            case 12:
                rank = "Q";
                break;
            case 13:
                rank = "K";
                break;
        }
    }

    @Override
    public void render(Graphics2D g2) {
        //render letter card
    }
}
