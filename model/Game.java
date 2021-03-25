package model;

import java.util.Random;

public class Game {
    
    public enum STATE {
        PLAYING, WIN
    }

    STATE state;

    public Game() {
        state = STATE.PLAYING;

        Deck deck = new Deck();

        // Tableau
        Stack stackA = new Stack();
        Stack stackB = new Stack();
        Stack stackC = new Stack();
        Stack stackD = new Stack();
        Stack stackE = new Stack();
        Stack stackF = new Stack();
        Stack stackG = new Stack();

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                Card card = deck.draw();
                switch (i) {
                    case 0:
                        stackA.add(card);
                        break;
                    case 1:
                        stackB.add(card);
                        break;
                    case 2:
                        stackC.add(card);
                        break;
                    case 3: 
                        stackD.add(card);
                        break;
                    case 4:
                        stackE.add(card);
                        break;
                    case 5:
                        stackF.add(card);
                        break;
                    case 6:
                        stackG.add(card);
                        break;
                }
            }
        }

        System.out.println(stackA.size());
        System.out.println(stackB.size());
        System.out.println(stackC.size());
        System.out.println(stackD.size());
        System.out.println(stackE.size());
        System.out.println(stackF.size());
        System.out.println(stackG.size());

    }
}
