public class Rook extends Piece {
    public Rook(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board) {
        if (newX != x && newY != y) {
            return false;
        }

        if (newX == x) {
            int step = newY > y ? 1 : -1;
            for (int i = y + step; i != newY; i += step) {
                if (board[x][i] != null) {
                    return false;
                }
            }
        } else {
            int step = newX > x ? 1 : -1;
            for (int i = x + step; i != newX; i += step) {
                if (board[i][y] != null) {
                    return false;
                }
            }
        }

        return true;
    }
}
