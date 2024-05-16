import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Board extends JPanel {
   private JButton[][] board;
   private int[][] matrix;
   private JLabel label;
   private JButton reset;
   private final int N = 8;
   public Board() {
      setLayout(new BorderLayout());

      JPanel north = new JPanel();
      north.setLayout(new FlowLayout());
      add(north, BorderLayout.NORTH);
      label = new JLabel("Welcome to Chess.");
      north.add(label);

      JPanel center = new JPanel();
      center.setLayout(new GridLayout(N, N));
      add(center, BorderLayout.CENTER);

      board = new JButton[N][N];
      matrix = new int[N][N];

      ImageIcon pawnW = new ImageIcon(new ImageIcon("assets/wp.png").getImage().getScaledInstance(80,80,java.awt.Image.SCALE_SMOOTH));
      ImageIcon rookW = new ImageIcon(new ImageIcon("assets/wr.png").getImage().getScaledInstance(80,80,java.awt.Image.SCALE_SMOOTH));
      ImageIcon knightW = new ImageIcon(new ImageIcon("assets/wn.png").getImage().getScaledInstance(80,80,java.awt.Image.SCALE_SMOOTH));
      ImageIcon bishopW = new ImageIcon(new ImageIcon("assets/wb.png").getImage().getScaledInstance(80,80,java.awt.Image.SCALE_SMOOTH));
      ImageIcon queenW = new ImageIcon(new ImageIcon("assets/wq.png").getImage().getScaledInstance(80,80,java.awt.Image.SCALE_SMOOTH));
      ImageIcon kingW = new ImageIcon(new ImageIcon("assets/wk.png").getImage().getScaledInstance(80,80,java.awt.Image.SCALE_SMOOTH));

      ImageIcon pawnB = new ImageIcon(new ImageIcon("assets/bp.png").getImage().getScaledInstance(80,80,java.awt.Image.SCALE_SMOOTH));
      ImageIcon rookB = new ImageIcon(new ImageIcon("assets/br.png").getImage().getScaledInstance(80,80,java.awt.Image.SCALE_SMOOTH));
      ImageIcon knightB = new ImageIcon(new ImageIcon("assets/bn.png").getImage().getScaledInstance(80,80,java.awt.Image.SCALE_SMOOTH));
      ImageIcon bishopB = new ImageIcon(new ImageIcon("assets/bb.png").getImage().getScaledInstance(80,80,java.awt.Image.SCALE_SMOOTH));
      ImageIcon queenB = new ImageIcon(new ImageIcon("assets/bq.png").getImage().getScaledInstance(80,80,java.awt.Image.SCALE_SMOOTH));
      ImageIcon kingB = new ImageIcon(new ImageIcon("assets/bk.png").getImage().getScaledInstance(80,80,java.awt.Image.SCALE_SMOOTH));

      for (int r = 0; r < N; r++) {
         for (int c = 0; c < N; c++) {
            matrix[r][c] = 0;

            board[r][c] = new JButton();
            board[r][c].setOpaque(true);
            board[r][c].setBorderPainted(true);

            if (r % 2 == 0 && c % 2 == 1 || r % 2 == 1 && c % 2 == 0) {
               board[r][c].setBackground(new Color(113, 147, 82));
               board[r][c].setBorder(new LineBorder(new Color(113, 147, 82)));
            } else {
               board[r][c].setBackground(new Color(233, 234, 207));
               board[r][c].setBorder(new LineBorder(new Color(233, 234, 207)));
            }

            if (r == 6) {
               board[r][c].setIcon(pawnW);
            }

            if (r == 1) {
               board[r][c].setIcon(pawnB);
            }

            if (r == 0 && (c == 0 || c == 7))
               board[r][c].setIcon(rookB);
            if (r == 0 && (c == 1 || c == 6))
               board[r][c].setIcon(knightB);
            if (r == 0 && (c == 2 || c == 5))
               board[r][c].setIcon(bishopB);
            if (r == 0 && c == 3)
               board[r][c].setIcon(queenB);
            if (r == 0 && c == 4)
               board[r][c].setIcon(kingB);

            if (r == 7 && (c == 0 || c == 7))
               board[r][c].setIcon(rookW);
            if (r == 7 && (c == 1 || c == 6))
               board[r][c].setIcon(knightW);
            if (r == 7 && (c == 2 || c == 5))
               board[r][c].setIcon(bishopW);
            if (r == 7 && c == 3)
               board[r][c].setIcon(queenW);
            if (r == 7 && c == 4)
               board[r][c].setIcon(kingW);

            board[r][c].addActionListener(new Handler1(r, c));
            center.add(board[r][c]);
         }
      }

      for (int r = 0; r < N; r++) {
         for (int c = 0; c < N; c++) {
            if (board[r][c].getIcon() == pawnW) {
               matrix[r][c] = 1;
            }
         }
      }

      reset = new JButton("Restart Game");
      reset.addActionListener(new Handler2());
      reset.setEnabled(false);
      add(reset, BorderLayout.SOUTH);
   }



   private class Handler1 implements ActionListener {
      private int row = 0;
      private int col = 0;

      public Handler1(int r, int c) {
         row = r;
         col = c;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         Icon piece = board[row][col].getIcon();

         board[row][col].setIcon(null);

         board[row-2][col].setIcon(piece);
      }
   }

   private class Handler2 implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
               board[r][c].setEnabled(true);
               board[r][c].setBackground(Color.BLUE);
               label.setText("Welcome to Chess");
            }
         }
      }
   }
}
