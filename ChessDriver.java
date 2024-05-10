import javax.swing.JFrame;

public class ChessDriver {
   public static void main(String[] args) {
      JFrame frame = new JFrame("Chess");
      frame.setSize(750, 800);
      frame.setLocation(200, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Board());
      frame.setVisible(true);
   }
}
