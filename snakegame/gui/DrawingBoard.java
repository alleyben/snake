package snakegame.gui;

import snakegame.game.SnakeGame;
import snakegame.domain.Apple;
import snakegame.domain.Piece;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.Iterator;

public class DrawingBoard extends JPanel implements Updatable {
    
    private SnakeGame game;
    private int pieceLength;
    
    public DrawingBoard(SnakeGame game, int pieceLength) {
        this.game = game;
        this.pieceLength = pieceLength;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        super.setBackground(Color.GRAY);
        
        Iterator<Piece> it = game.getWorm().getPieces().iterator();
        g.setColor(Color.BLACK);
        while (it.hasNext()) {
            Piece itNow = it.next();
            g.fill3DRect(itNow.getX()*pieceLength, itNow.getY()*pieceLength, pieceLength, pieceLength, true); // x, y, height, width
        }
        //g.fillRect(game.getWorm()., 0, pieceLength, pieceLength);
        Apple apple = game.getApple();
        g.setColor(Color.RED);
        g.fillOval(apple.getX()*pieceLength, apple.getY()*pieceLength, pieceLength, pieceLength); // x, y, diameter, diameter
    }
    
    @Override
    public void update() {
        this.repaint();
    }
}