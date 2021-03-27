package model;

import java.awt.Graphics2D;

import java.util.Random;

import model.groups.Foundation;
import model.groups.Stack;
import model.groups.Waste;

public class Game {
    
    public enum STATE {
        PLAYING, WIN
    }

    STATE state;

    Deck deck;

    Waste waste;

    Foundation foundationHearts;
    Foundation foundationDiamonds;
    Foundation foundationSpades;
    Foundation foundationClubs;

    Stack stackA;
    Stack stackB;
    Stack stackC;
    Stack stackD;
    Stack stackE;
    Stack stackF;
    Stack stackG;

    public Game() {
        state = STATE.PLAYING;

        deck = new Deck();

        final int TABLEAU_OFFSET = 560 + 30;
        stackA = new Stack(TABLEAU_OFFSET);
        stackB = new Stack(TABLEAU_OFFSET + 90 * 1);
        stackC = new Stack(TABLEAU_OFFSET + 90 * 2);
        stackD = new Stack(TABLEAU_OFFSET + 90 * 3);
        stackE = new Stack(TABLEAU_OFFSET + 90 * 4);
        stackF = new Stack(TABLEAU_OFFSET + 90 * 5);
        stackG = new Stack(TABLEAU_OFFSET + 90 * 6);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                Card card = deck.draw();
                switch (i) {
                    case 0:
                        stackA.add(card);
                        stackA.incrementCoveredCards();
                        break;
                    case 1:
                        stackB.add(card);
                        stackB.incrementCoveredCards();
                        break;
                    case 2:
                        stackC.add(card);
                        stackC.incrementCoveredCards();
                        break;
                    case 3: 
                        stackD.add(card);
                        stackD.incrementCoveredCards();
                        break;
                    case 4:
                        stackE.add(card);
                        stackE.incrementCoveredCards();
                        break;
                    case 5:
                        stackF.add(card);
                        stackF.incrementCoveredCards();
                        break;
                    case 6:
                        stackG.add(card);
                        stackG.incrementCoveredCards();
                        break;
                }
            }
        }

        System.out.println(stackA.contents());
        System.out.println(stackB.contents());
        System.out.println(stackC.contents());
        System.out.println(stackD.contents());
        System.out.println(stackE.contents());
        System.out.println(stackF.contents());
        System.out.println(stackG.contents());

        System.out.println(deck.size());

        final int FOUNDATION_OFFSET = 180 + 30;
        foundationHearts = new Foundation(FOUNDATION_OFFSET, 1);
        foundationDiamonds = new Foundation(FOUNDATION_OFFSET + 90 * 1, 2);
        foundationSpades = new Foundation(FOUNDATION_OFFSET + 90 * 2, 3);
        foundationClubs = new Foundation(FOUNDATION_OFFSET + 90 * 3, 4);

        final int WASTE_OFFSET = 100;

        waste = new Waste(WASTE_OFFSET);

    }

    public void checkWin() {
        boolean win = true;
        if (foundationHearts.getCards().size() < 13) win = false;
        if (foundationDiamonds.getCards().size() < 13) win = false;
        if (foundationClubs.getCards().size() < 13) win = false;
        if (foundationSpades.getCards().size() < 13) win = false;
        if (win) state = STATE.WIN;
    }

    public void render(Graphics2D g2) {

        deck.render(g2);

        waste.render(g2);
        
        foundationHearts.render(g2);
        foundationDiamonds.render(g2);
        foundationSpades.render(g2);
        foundationClubs.render(g2);

        stackA.render(g2);
        stackB.render(g2);
        stackC.render(g2);
        stackD.render(g2);
        stackE.render(g2);
        stackF.render(g2);
        stackG.render(g2);

    }

    public STATE getState() {
        return state;
    }

    public Deck getDeck() {
        return deck;
    }

    public Waste getWaste() {
        return waste;
    }

    public Foundation getFoundationHearts() {
        return foundationHearts;
    }

    public Foundation getFoundationDiamonds() {
        return foundationDiamonds;
    }

    public Foundation getFoundationClubs() {
        return foundationClubs;
    }

    public Foundation getFoundationSpades() {
        return foundationSpades;
    }

    public Stack getStackA() {
        return stackA;
    }

    public Stack getStackB() {
        return stackB;
    }

    public Stack getStackC() {
        return stackC;
    }

    public Stack getStackD() {
        return stackD;
    }

    public Stack getStackE() {
        return stackE;
    }

    public Stack getStackF() {
        return stackF;
    }

    public Stack getStackG() {
        return stackG;
    }
}
