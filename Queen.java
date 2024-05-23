public class Queen extends Piece {
    public Queen(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    public boolean isValidMove(int newX, int newY, Piece[][] board) {
        int dx = Math.abs(newX - x);
        int dy = Math.abs(newY - y);

        if (dx == dy || newX == x || newY == y) {
            int xStep = (newX > x) ? 1 : (newX < x) ? -1 : 0;
            int yStep = (newY > y) ? 1 : (newY < y) ? -1 : 0;

            for (int i = 1; i < Math.max(dx, dy); i++) {
                if (board[x + i * xStep][y + i * yStep] != null) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public String getName() {
        return "queen";
    }
}

