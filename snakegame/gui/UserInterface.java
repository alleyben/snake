package snakegame.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import snakegame.game.SnakeGame;

public class UserInterface implements Runnable {

    private JFrame frame;
    private SnakeGame game;
    private int sideLength;
    private DrawingBoard board;

    public UserInterface(SnakeGame game, int sideLength) {
        this.game = game;
        this.sideLength = sideLength;
    }

    @Override
    public void run() {
        frame = new JFrame("Snake");
        int width = (game.getWidth() + 1) * sideLength + 10;
        int height = (game.getHeight() + 2) * sideLength + 10;

        frame.setPreferredSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        this.board = new DrawingBoard(game, sideLength);
        container.add(board);
        KeyboardListener kl = new KeyboardListener(game.getWorm());
        frame.addKeyListener(kl);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public Updatable getUpdatable() {
        return board;
    }
}
