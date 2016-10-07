package snakegame.gui;

import snakegame.domain.Snake;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import snakegame.Direction;

public class KeyboardListener implements KeyListener{
    
    private Snake worm;
    
    public KeyboardListener(Snake worm) {
        this.worm = worm;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            worm.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            worm.setDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            worm.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            worm.setDirection(Direction.RIGHT);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
