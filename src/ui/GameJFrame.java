package ui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameJFrame extends JFrame {
    public GameJFrame() {
        super("Puzzle Game");
        initJFrame();
        initJMenuBar();
        initImage();
        setVisible(true);
    }

    private void initImage() {
        List<Integer> indices = randomIndices();
        for (int i = 0; i < 16; i++) {
            ImageIcon image = new ImageIcon("image\\animal\\animal3\\" + indices.get(i) + ".jpg");
            JLabel label = new JLabel(image);
            label.setBounds(105 * (i % 4)+83, 105 * (i / 4)+134, 105, 105);
            this.getContentPane().add(label);
        }
    }

    private void initJMenuBar() {
        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a menu
        JMenu fileMenu = new JMenu("File");
        JMenu aboutUs = new JMenu("About Us");

        // Create menu items
        JMenuItem newGameItem = new JMenuItem("New Game");
        JMenuItem reLoginItem = new JMenuItem("Re-Login");
        JMenuItem exitItem = new JMenuItem("Exit");

        JMenuItem contactUsItem = new JMenuItem("Contact Us");

        // Add menu items to the menus
        fileMenu.add(newGameItem);
        fileMenu.add(reLoginItem);
        fileMenu.add(exitItem);
        aboutUs.add(contactUsItem);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(aboutUs);

        // Set the menu bar for the frame
        setJMenuBar(menuBar);
    }

    private void initJFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(603, 680);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);

        setLayout(null);
    }

    private List<Integer> randomIndices() {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            indices.add(i);
        }
        Collections.shuffle(indices);
        return indices;
    }
}
