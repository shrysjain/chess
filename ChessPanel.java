import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessPanel extends JPanel implements MouseListener {
    private Board board;
    private int selectedX = -1, selectedY = -1;

    public ChessPanel() {
        this.board = new Board();
        this.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw chess board
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((row + col) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.GRAY);
                }
                g.fillRect(col * 80, row * 80, 80, 80);
            }
        }
        // Draw pieces
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getPieceAt(col, row);
                if (piece != null) {
                    if (piece.isWhite()) {
                        g.setColor(Color.WHITE);
                    } else {
                        g.setColor(Color.BLACK);
                    }
                    g.fillOval(col * 80 + 20, row * 80 + 20, 40, 40);
                }
            }
        }

        // Highlight selected piece
        if (selectedX != -1 && selectedY != -1) {
            g.setColor(Color.RED);
            g.drawRect(selectedX * 80, selectedY * 80, 80, 80);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX() / 80;
        int y = e.getY() / 80;

        if (selectedX == -1 && selectedY == -1) {
            // Select a piece
            if (board.getPieceAt(x, y) != null && board.getPieceAt(x, y).isWhite() == board.isWhiteTurn()) {
                selectedX = x;
                selectedY = y;
            }
        } else {
            // Move the piece
            if (board.movePiece(selectedX, selectedY, x, y)) {
                selectedX = -1;
                selectedY = -1;
            }
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
