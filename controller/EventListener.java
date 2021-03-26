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
        boundingBoxes.add(panel.getGame().getDeck().getBoundingBox());
        for (int i = 0; i < boundingBoxes.size(); i++) {
            Rectangle box = boundingBoxes.get(i);
            if (box.contains(e.getX(), e.getY())) {
                Deck deck = panel.getGame().getDeck();
                Waste waste = panel.getGame().getWaste();
                if (panel.getGame().getDeck().getCards().size() == 0) {
                    //panel.getGame().getDeck().setCards(panel.getGame().getWaste().getCards());
                    //panel.getGame().getWaste().emptyWaste();
                    deck.setCards(waste.getCards());
                    waste.emptyWaste();
                    //for (int j = 0; j < waste.getCards().size(); j++) {
                        //Card card = waste.getCards().get(j);
                        //deck.add(waste.getCards().get(j));
                        //waste.getCards().remove(j);
                    //}
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
