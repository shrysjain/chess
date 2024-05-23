import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.HashMap;
import java.util.Map;

public class ChessPanel extends JPanel implements MouseListener {
    private Board board;
    private int selectedX = -1, selectedY = -1;
    private Map<String, BufferedImage> pieceImages;
    private ChessTimer chessTimer;

    public ChessPanel() {
        this.board = new Board();
        this.pieceImages = loadPieceImages();
        this.addMouseListener(this);
        this.chessTimer = new ChessTimer();
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chessTimer.step();
                repaint();
            }
        });
        timer.start();
    }

    private Map<String, BufferedImage> loadPieceImages() {
        Map<String, BufferedImage> images = new HashMap<>();
        String[] pieceNames = {"king", "queen", "rook", "bishop", "knight", "pawn"};
        String[] colors = {"White", "Black"};

        for (String pieceName : pieceNames) {
            for (String color : colors) {
                String fileName = "assets/" + pieceName + color + ".png";
                try {
                    images.put(pieceName + color, ImageIO.read(new File(fileName)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return images;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the board
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                // Highlight the selected square
                if (row == selectedY && col == selectedX) {
                    g.setColor(Color.YELLOW);
                } else if ((row + col) % 2 == 0) {
                    g.setColor(new Color(233, 234, 207));
                } else {
                    g.setColor(new Color(113, 147, 82));
                }
                g.fillRect(col * 80, row * 80, 80, 80);
            }
        }

        // Draw pieces
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getPieceAt(col, row);
                if (piece != null) {
                    String pieceName = piece.getName();
                    String pieceColor = piece.isWhite() ? "White" : "Black";
                    BufferedImage image = pieceImages.get(pieceName + pieceColor);
                    if (image != null) {
                        g.drawImage(image, col * 80, row * 80, 80, 80, this);
                    }
                }
            }
        }

        chessTimer.drawMe(g);
    }

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

    public void mousePressed(MouseEvent e) { }

    public void mouseReleased(MouseEvent e) { }

    public void mouseEntered(MouseEvent e) { }

    public void mouseExited(MouseEvent e) { }
}
