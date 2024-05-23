public class Bishop extends Piece {
    public Bishop(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board) {
        int dx = Math.abs(newX - x);
        int dy = Math.abs(newY - y);

        if (dx != dy) {
            return false;
        }

        int xStep = (newX > x) ? 1 : -1;
        int yStep = (newY > y) ? 1 : -1;

        for (int i = 1; i < dx; i++) {
            if (board[x + i * xStep][y + i * yStep] != null) {
                return false;
            }
        }

        return true;
    }
}

