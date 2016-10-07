package snakegame.domain;
import snakegame.Direction;
import java.util.*;

public class Snake {
    
    private Direction dir;
    private List<Piece> pieces;
    private boolean grow;
    
    public Snake(int originalX, int originalY, Direction originalDirection) {
        this.dir = originalDirection;
        this.pieces = new ArrayList<Piece>();
        pieces.add(new Piece(originalX, originalY));
        this.grow = true;
    }
    
    public Direction getDirection() {
        return dir;
    }
    
    public void setDirection(Direction dir) {
        this.dir = dir;
    }
    
    public int getLength() {
        return pieces.size();
    }
    
    public List<Piece> getPieces() {
        return pieces;
    }
    
    public void move() {               /////// may need to put boundaries in place depending on board & gameplay mechancis
        if (pieces.size() < 3) {
            grow();
        }
        
        Piece last = pieces.get(pieces.size()-1);
        int x = last.getX();
        int y = last.getY();
        
        if (dir == Direction.UP || dir == Direction.DOWN) {
            int newY = 0;
            if (dir == Direction.UP) {
                newY = y-1;
            } else {
                newY = y+1;
            }
            pieces.add(new Piece(x, newY));
        } else {
            int newX = 0;
            if (dir == Direction.LEFT) {
                newX = x-1;
            } else if (dir == Direction.RIGHT) {
                newX = x+1;
            }
            pieces.add(new Piece(newX, y));
        }
        if (!grow) {
            pieces.remove(pieces.get(0));
        } else {
            grow = false;
        }
    }
    
    public void grow() {
        grow = true;
    }
    
    public boolean runsInto(Piece piece) {
        Iterator<Piece> it = pieces.iterator();
        while (it.hasNext()) {
            if (it.next().runsInto(piece)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean runsIntoItself() {
        Iterator<Piece> it = pieces.iterator();
        Piece head = pieces.get(pieces.size()-1);
        while (it.hasNext()) {
            Piece itNow = it.next();
            if (head == itNow) {
                continue;
            }
            if (head.runsInto(itNow)) {
                return true;
            }
        }
        return false;
    }
}
