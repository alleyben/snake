package snakegame.game;

import snakegame.domain.Apple;
import snakegame.domain.Piece;
import snakegame.domain.Snake;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*; /// changed to star from Random
import javax.swing.Timer;
import snakegame.Direction;
import snakegame.gui.Updatable;

public class SnakeGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Snake worm;
    private Apple apple;
    private Random rand;

    public SnakeGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;

        addActionListener(this);
        setInitialDelay(2000);
        
        this.worm = new Snake(width/2, height/2, Direction.DOWN);
        this.rand = new Random();
        int x = rand.nextInt(width);
        int y = rand.nextInt(height);
        while (appleCheck(x, y)) {
            if (rand.nextBoolean()) {
                x = rand.nextInt(width);
            } else {
                y = rand.nextInt(height);
            }
        }
        this.apple = new Apple(x, y);
    }


    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (continues) {
            worm.move();
            if (worm.runsInto(apple)){ ////////////// check to see if we ate the apple
                // new apple
                int x = rand.nextInt(width);
                int y = rand.nextInt(height);
                while (appleCheck(x, y)) {
                    if (rand.nextBoolean()) {
                        x = rand.nextInt(width);
                    } else {
                        y = rand.nextInt(height);
                    }
                }
                setApple(new Apple(x, y)); // new apple set
                worm.grow();
            }
            Piece head = worm.getPieces().get(worm.getLength()-1);
            if (worm.runsIntoItself() || head.getX() >= width || head.getY() >= height || head.getX() < 0 || head.getY() < 0) {
                continues = false;
            }
            updatable.update();
            super.setDelay(1000/worm.getLength());
        } /*else {
            System.out.println("GAME OVER, MAN"); // show game over window, new jframe?
        play a game?
        }*/
    }
    
    public Snake getWorm() {
        return worm;
    }
    
    public void setWorm(Snake worm) {
        this.worm = worm;
    }
    
    public Apple getApple() {
        return apple;
    }
    
    public void setApple(Apple apple) {
        this.apple = apple;
    }
    
    public boolean appleCheck(int x1, int y1) {
        Iterator<Piece> segs = worm.getPieces().iterator();
        while (segs.hasNext()) {
            Piece itNow = segs.next();
            if (x1 == itNow.getX() && y1 == itNow.getY()) {
                return true;
            }
        }
        return false;
    }
}
