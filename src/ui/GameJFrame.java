package ui;

import javax.swing.*;

public class GameJFrame extends JFrame {
    public GameJFrame() {
        super("Puzzle Game");
        initJFrame();
        initJMenuBar();
        setVisible(true);
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
    }
}
