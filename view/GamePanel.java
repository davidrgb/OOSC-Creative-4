package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel {
    
    private JFrame window;

    private GameCanvas canvas;

    //private Game game;

    private JButton newGameButton;

    public GamePanel(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container container = window.getContentPane();

        //Create game object

        canvas = new GameCanvas(this);
        container.add(BorderLayout.CENTER, canvas);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 1));

        newGameButton = new JButton("New Game");
        
        controlPanel.add(newGameButton);

        container.add(BorderLayout.SOUTH, controlPanel);
    }

    public JFrame getWindow() {
        return window;
    }

    //get canvas

    //get game

    public JButton getNewGameButton() {
        return newGameButton;
    }

    public void render(Graphics2D g) {
        //
    }
}
