import javax.swing.*;

public class ChessFrame extends JFrame {
    public ChessFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 640);
        this.add(new ChessPanel());
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ChessFrame();
    }
}
