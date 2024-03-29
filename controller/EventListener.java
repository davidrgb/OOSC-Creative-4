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
    ArrayList<Card> memoryCards = new ArrayList<>();
    int memoryCardIndex;
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
                if (waste.getCards().size() > 0) {
                    deck.setCards(waste.getCards());
                    waste.emptyWaste();
                }
            }

            memoryCards = new ArrayList<>();
            memoryCardIndex = -1;
            cardGroup = null;

            if (deck.getCards().size() > 0) waste.add(deck.drawToWaste());
            int xLocationMarker = -15;
            int yLocationMarker = -15;
            panel.getCanvas().setMarkerLocation(xLocationMarker, yLocationMarker);
            panel.getCanvas().repaint();
            return;
        }

        if (memoryCards.size() == 0) {
            for (var g: groups) {
                if (g.getBoundingBox().contains(mouseX, mouseY) && g.getCards().size() > 0) {
                    memoryCardIndex = g.getSelectedCard(mouseY);
                    for (int i = memoryCardIndex; i < g.getCards().size(); i++) {
                        memoryCards.add(g.getCards().get(i));
                    }
                    cardGroup = g;
                    int xLocationMarker = memoryCards.get(0).getxLocation() + 32;
                    int yLocationMarker = memoryCards.get(0).getyLocation() + 7;
                    panel.getCanvas().setMarkerLocation(xLocationMarker, yLocationMarker);
                    panel.getCanvas().repaint();
                    return;
                }
            }
        }
        else {
            for (var g: groups) {
                if (g.getBoundingBox().contains(mouseX, mouseY)) {
                    if (g.transfer(memoryCards)) {
                        for (int i = memoryCardIndex; i < cardGroup.size();) {
                            cardGroup.remove(memoryCardIndex);
                        }
                        int xLocationMarker = -15;
                        int yLocationMarker = -15;
                        panel.getCanvas().setMarkerLocation(xLocationMarker, yLocationMarker);
                        memoryCards = new ArrayList<>();
                        memoryCardIndex = -1;
                        cardGroup = null;
                        panel.getGame().checkWin();
                        panel.getCanvas().repaint();
                        return;
                    }
                }
            }

            memoryCards = new ArrayList<>();
            memoryCardIndex = -1;
            cardGroup = null;
            int xLocationMarker = -15;
            int yLocationMarker = -15;
            panel.getCanvas().setMarkerLocation(xLocationMarker, yLocationMarker);
            panel.getCanvas().repaint();
        
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
