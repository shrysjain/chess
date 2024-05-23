import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessTimer implements Animatable {
    private int seconds;
    private Timer timer;
    private boolean running;

    public ChessTimer() {
        this.seconds = 0;
        this.running = false;
        this.timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (running) {
                    step();
                }
            }
        });
    }

    public void start() {
        this.running = true;
        this.timer.start();
    }

    public void stop() {
        this.running = false;
    }

    public void reset() {
        this.seconds = 0;
    }

    public void step() {
        this.seconds++;
    }

    public void drawMe(Graphics g) {
        int minutes = seconds / 60;
        int secs = seconds % 60;
        String timeStr = String.format("%02d:%02d", minutes, secs);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(timeStr, 650, 100);
    }
}
