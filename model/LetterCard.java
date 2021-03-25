package model;

import java.awt.Font;
import java.awt.Graphics2D;

public class LetterCard extends Card implements ICardRender {

    private final int X_OFFSET = 2 + 4;
    private final int Y_OFFSET = 2 + 17;

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
        super.render(g2);
        g2.setFont(new Font("Courier New", Font.BOLD, 21));
        g2.drawString(rank, X_OFFSET + getxLocation(), + Y_OFFSET + getyLocation());
    }
}
