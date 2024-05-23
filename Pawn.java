public class Pawn extends Piece {
    public Pawn(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board) {
        int direction = isWhite ? -1 : 1;

        // Basic move forward
        if (newX == x && newY == y + direction && board[newX][newY] == null) {
            return true;
        }

        // Capture move
        if (Math.abs(newX - x) == 1 && newY == y + direction && board[newX][newY] != null &&
                board[newX][newY].isWhite() != isWhite) {
            return true;
        }

        // Initial double move
        if ((y == 1 && !isWhite) || (y == 6 && isWhite)) {
            if (newX == x && newY == y + 2 * direction && board[newX][newY] == null &&
                    board[x][y + direction] == null) {
                return true;
            }
        }

        return false;
    }
}
