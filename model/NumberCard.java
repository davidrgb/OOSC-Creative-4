package model;

import java.awt.Font;
import java.awt.Graphics2D;

public class NumberCard extends Card {

    private final int X_OFFSET = 2 + 4;
    private final int Y_OFFSET = 2 + 19;
    
    public NumberCard(int value, int suit) {
        super(value, suit);
    }

    @Override
    public void render(Graphics2D g2) {
        super.render(g2);
        g2.setFont(new Font("Courier New", Font.BOLD, 21));
        g2.drawString(getValue() + "", X_OFFSET + getxLocation(), + Y_OFFSET + getyLocation());
    }
}
