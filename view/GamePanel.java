package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Game;

public class GamePanel {
    
    private JFrame window;

    private GameCanvas canvas;

    private Game game;

    private JButton newGameButton;

    public GamePanel(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container container = window.getContentPane();

        game = new Game(); 

        canvas = new GameCanvas(this);
        container.add(BorderLayout.CENTER, canvas);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 1));

        newGameButton = new JButton("New Game");

        newGameButton.addActionListener( e -> {
            window.getContentPane().removeAll();
            var panel = new GamePanel(window);
            panel.init();
            window.pack();
            window.revalidate();
        });
        
        controlPanel.add(newGameButton);

        container.add(BorderLayout.SOUTH, controlPanel);
    }

    public JFrame getWindow() {
        return window;
    }

    public GameCanvas getCanvas() {
        return canvas;
    }

    public Game getGame() {
        return game;
    }

    public JButton getNewGameButton() {
        return newGameButton;
    }

    public void render(Graphics2D g2) {
        game.render(g2);
    }
}
