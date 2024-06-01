import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChessDriver extends JFrame {
    public ChessDriver() {
        ChessPanel panel = new ChessPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(710, 665);
        this.add(panel);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                panel.stopBackgroundMusic();
                super.windowClosing(e);
            }
        });
    }

    public static void main(String[] args) {
        new ChessDriver();

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new StartScreen());
        f.setSize(400, 300);
        f.setVisible(false);
    }
}
