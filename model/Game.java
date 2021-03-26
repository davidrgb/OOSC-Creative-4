package model;

import java.awt.Graphics2D;

import java.util.Random;

import model.groups.Foundation;
import model.groups.Stack;

public class Game {
    
    public enum STATE {
        PLAYING, WIN
    }

    STATE state;

    Stack stackA;
    Stack stackB;
    Stack stackC;
    Stack stackD;
    Stack stackE;
    Stack stackF;
    Stack stackG;

    Foundation foundationHearts;
    Foundation foundationDiamonds;
    Foundation foundationSpades;
    Foundation foundationClubs;

    public Game() {
        state = STATE.PLAYING;

        Deck deck = new Deck();

        // Tableau
        final int tableauOffset = 540 + 20;
        stackA = new Stack(tableauOffset);
        stackB = new Stack(tableauOffset + 90 * 1);
        stackC = new Stack(tableauOffset + 90 * 2);
        stackD = new Stack(tableauOffset + 90 * 3);
        stackE = new Stack(tableauOffset + 90 * 4);
        stackF = new Stack(tableauOffset + 90 * 5);
        stackG = new Stack(tableauOffset + 90 * 6);

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

        foundationHearts = new Foundation(180, 1);
        foundationDiamonds = new Foundation(180 + 90 * 1, 2);
        foundationSpades = new Foundation(180 + 90 * 2, 3);
        foundationClubs = new Foundation(180 + 90 * 3, 4);
    }

    public void render(Graphics2D g2) {
        
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
}
