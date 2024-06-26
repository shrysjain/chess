public class Knight extends Piece {
    public Knight(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    public boolean isValidMove(int newX, int newY, Piece[][] board) {
        int dx = Math.abs(newX - x);
        int dy = Math.abs(newY - y);

        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }

    public String getName() {
        return "knight";
    }
}
