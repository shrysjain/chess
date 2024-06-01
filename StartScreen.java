import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends Panel {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public StartScreen() {
        // Create a CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create the new panel
        JPanel newPanel = new JPanel();
        newPanel.setBackground(Color.GREEN);
        JButton newPanelButton = new JButton("START");
        newPanelButton.setBackground(Color.GREEN);
        newPanel.add(newPanelButton);

        mainPanel.add(newPanel);

        // Add action listener to the start button
        // startButton.addActionListener(e -> cardLayout.show(mainPanel,"ChessPanel"));

        // Add the main panel to the frame
        add(mainPanel);
    }
}
