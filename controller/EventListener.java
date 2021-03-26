package controller;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import model.Card;
import model.Deck;
import model.groups.Waste;
import view.GamePanel;

public class EventListener implements MouseListener {

    GamePanel panel;

    ArrayList<Rectangle> boundingBoxes = new ArrayList<>();

    public EventListener(GamePanel panel) {
        this.panel = panel;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {  
        boundingBoxes.clear();

        Deck deck = panel.getGame().getDeck();
        Waste waste = panel.getGame().getWaste();

        boundingBoxes.add(deck.getBoundingBox());
        for (int i = 0; i < boundingBoxes.size(); i++) {
            Rectangle box = boundingBoxes.get(i);
            if (box.contains(e.getX(), e.getY())) {
                if (deck.getCards().size() == 0) {
                    deck.setCards(waste.getCards());
                    waste.emptyWaste();
                }

                waste.add(deck.drawToWaste());
                panel.getCanvas().repaint();
                return;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
