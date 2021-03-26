import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import view.GamePanel;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Solitaire");

        Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
        final int SCREEN_X_RESOLUTION = resolution.width;
        final int SCREEN_Y_RESOLUTION = resolution.height;

        final int X_RESOLUTION = 1250;
        final int Y_RESOLUTION = 750;

        window.setLocation(SCREEN_X_RESOLUTION / 2 - (X_RESOLUTION / 2), SCREEN_Y_RESOLUTION / 2 - (Y_RESOLUTION / 2));

        var panel = new GamePanel(window);
        panel.init();
        window.pack();
        window.setVisible(true);
    }
}