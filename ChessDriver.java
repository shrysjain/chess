import javax.swing.*;

public class ChessDriver extends JFrame {
    public ChessDriver() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(710, 665);
        this.add(new ChessPanel());
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ChessDriver();
    }
}
