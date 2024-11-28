package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {
    private ArrayList<Integer> data;
    private int index;
    private int pictureIndex;
    private final ArrayList<Integer> winData =
            new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0));
    private int step = 0;

    public GameJFrame() {
        super("Puzzle Game");
        initJFrame();
        initJMenuBar();
        initImage();
        setVisible(true);
    }

    private boolean victory() {
        for (int i = 0; i < 16; i++) {
            if (!this.data.get(i).equals(this.winData.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void initImage() {
        //print data in 4x4 format
        for (int i = 0; i < 16; i++) {
            System.out.print(this.data.get(i) + " ");
            if (i % 4 == 3) {
                System.out.println();
            }
        }
        this.getContentPane().removeAll();

        for (int i = 0; i < 16; i++) {
            ImageIcon image = new ImageIcon("image\\animal\\animal" + this.pictureIndex + "\\" + this.data.get(i) + ".jpg");
            JLabel label = new JLabel(image);
            label.setBounds(105 * (i % 4) + 83, 105 * (i / 4) + 134, 105, 105);
            label.setBorder(new BevelBorder(BevelBorder.LOWERED));
            this.getContentPane().add(label);
        }

        //Step count
        JLabel stepCount = new JLabel("Step: " + this.step);
        stepCount.setBounds(50, 30, 100, 30);
        this.getContentPane().add(stepCount);

        this.getContentPane().repaint();
        if (this.victory()) {
            JOptionPane.showMessageDialog(this, "You Win!", "Victory", JOptionPane.INFORMATION_MESSAGE);
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

        //add ActionListener
        newGameItem.addActionListener(e -> {
            System.out.println("New Game");
            this.randomIndices();
            this.step = 0;
            this.initImage();
        });
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
        randomIndices();
        addKeyListener(this);
    }

    private void randomIndices() {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            indices.add(i);
        }
        Collections.shuffle(indices);
        this.index = indices.indexOf(0);
        this.pictureIndex = new Random().nextInt(5) + 1;
        this.data = indices;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A) {
            this.getContentPane().removeAll();
            ImageIcon image = new ImageIcon("image\\animal\\animal" + this.pictureIndex + "\\all.jpg");
            JLabel all = new JLabel(image);
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //up left down right
        if (this.victory()) {
            return;
        }
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                if (this.index > 3) {
                    Collections.swap(this.data, this.index, this.index - 4);
                    this.index -= 4;
                    step++;
                    initImage();
                }
                break;
            case KeyEvent.VK_DOWN:
                if (this.index < 12) {
                    Collections.swap(this.data, this.index, this.index + 4);
                    this.index += 4;
                    step++;
                    initImage();
                }
                break;
            case KeyEvent.VK_LEFT:
                if (this.index % 4 != 0) {
                    Collections.swap(this.data, this.index, this.index - 1);
                    this.index -= 1;
                    step++;
                    initImage();
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (this.index % 4 != 3) {
                    Collections.swap(this.data, this.index, this.index + 1);
                    this.index += 1;
                    step++;
                    initImage();
                }
                break;
            case KeyEvent.VK_A:
                initImage();
                break;
            case KeyEvent.VK_W:
                //order the data
                this.data.remove(this.index);
                Collections.sort(this.data);
                this.data.add(0);
                this.index = 15;
                initImage();
                break;
            default:
                System.out.println("Other key released");
                break;
        }

    }

}
