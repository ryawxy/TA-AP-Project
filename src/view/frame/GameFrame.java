package view.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
    public GameFrame(JPanel panel) {
        this.setTitle("Game Window"); // Optional: set a title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(700, 700);
        this.add(panel); // Add your panel
        this.setLocationRelativeTo(null); // Center the window
        this.setVisible(true); // Make it visible
    }
}
