public abstract class Piece {
    protected int x, y;
    protected boolean isWhite;

    public Piece(int x, int y, boolean isWhite) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract boolean isValidMove(int newX, int newY, Piece[][] board);
}
