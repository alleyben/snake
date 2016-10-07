package snakegame.domain;

public class Piece {

    private int x;
    private int y;
    
    public Piece (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public boolean runsInto(Piece piece) {
        if (piece.x == x && piece.y == y) {
            return true;
        }
        return false;
    }
    
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
