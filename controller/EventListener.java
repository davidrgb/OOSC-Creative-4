package controller;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import model.Card;
import model.Deck;
import model.groups.Foundation;
import model.groups.Group;
import model.groups.Stack;
import model.groups.Waste;
import view.GamePanel;

public class EventListener implements MouseListener {

    GamePanel panel;

    ArrayList<Rectangle> boundingBoxes = new ArrayList<>();

    Card memoryCard;
    Group cardGroup;

    public EventListener(GamePanel panel) {
        this.panel = panel;
        memoryCard = null;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {  
        boundingBoxes.clear();
        int mouseX = e.getX();
        int mouseY = e.getY();

        Deck deck = panel.getGame().getDeck();

        Waste waste = panel.getGame().getWaste();

        Foundation foundationHearts = panel.getGame().getFoundationHearts();
        Foundation foundationDiamonds = panel.getGame().getFoundationDiamonds();
        Foundation foundationClubs = panel.getGame().getFoundationClubs();
        Foundation foundationSpades = panel.getGame().getFoundationSpades();

        Stack stackA = panel.getGame().getStackA();
        Stack stackB = panel.getGame().getStackB();
        Stack stackC = panel.getGame().getStackC();
        Stack stackD = panel.getGame().getStackD();
        Stack stackE = panel.getGame().getStackE();
        Stack stackF = panel.getGame().getStackF();
        Stack stackG = panel.getGame().getStackG();

        ArrayList<Group> groups = new ArrayList<>();

        groups.add(waste);
        groups.add(foundationHearts);
        groups.add(foundationDiamonds);
        groups.add(foundationClubs);
        groups.add(foundationSpades);
        groups.add(stackA);
        groups.add(stackB);
        groups.add(stackC);
        groups.add(stackD);
        groups.add(stackE);
        groups.add(stackF);
        groups.add(stackG);

        if (deck.getBoundingBox().contains(mouseX, mouseY)) {
            if (deck.getCards().size() == 0) {
                deck.setCards(waste.getCards());
                waste.emptyWaste();
            }

            memoryCard = null;
            cardGroup = null;

            waste.add(deck.drawToWaste());
            panel.getCanvas().repaint();
            return;
        }

        if (memoryCard == null) {
            for (var g: groups) {
                if (g.getBoundingBox().contains(mouseX, mouseY) && g.getCards().size() > 0) {
                    memoryCard = g.getSelectedCard(mouseY);
                    cardGroup = g;
                    System.out.println(memoryCard + " " + cardGroup);
                    return;
                }
            }
        }
        else {
            //move op
            
            memoryCard = null;
            cardGroup = null;
        }
        //boundingBoxes.add(deck.getBoundingBox());
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
