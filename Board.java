public class Board {
    private Piece[][] board;
    private boolean whiteTurn;

    public Board() {
        board = new Piece[8][8];
        whiteTurn = true;
        initializeBoard();
    }

    private void initializeBoard() {
        // Place pieces on the board
        for (int i = 0; i < 8; i++) {
            board[i][1] = new Pawn(i, 1, false);
            board[i][6] = new Pawn(i, 6, true);
        }
        board[0][0] = new Rook(0, 0, false);
        board[7][0] = new Rook(7, 0, false);
        board[0][7] = new Rook(0, 7, true);
        board[7][7] = new Rook(7, 7, true);

        board[1][0] = new Knight(1, 0, false);
        board[6][0] = new Knight(6, 0, false);
        board[1][7] = new Knight(1, 7, true);
        board[6][7] = new Knight(6, 7, true);

        board[2][0] = new Bishop(2, 0, false);
        board[5][0] = new Bishop(5, 0, false);
        board[2][7] = new Bishop(2, 7, true);
        board[5][7] = new Bishop(5, 7, true);

        board[3][0] = new Queen(3, 0, false);
        board[3][7] = new Queen(3, 7, true);

        board[4][0] = new King(4, 0, false);
        board[4][7] = new King(4, 7, true);
    }

    public boolean movePiece(int startX, int startY, int endX, int endY) {
        Piece piece = board[startX][startY];
        if (piece == null || piece.isWhite() != whiteTurn) {
            return false;
        }

        if (piece.isValidMove(endX, endY, board)) {
            board[endX][endY] = piece;
            board[startX][startY] = null;
            piece.setPosition(endX, endY);
            whiteTurn = !whiteTurn;
            return true;
        }
        return false;
    }

    public Piece getPieceAt(int x, int y) {
        return board[x][y];
    }

    public boolean isWhiteTurn() {
        return whiteTurn;
    }
}
