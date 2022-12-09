package ru.croc.task19;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Window extends JFrame {

    private Image img;

    public Window() {
        int width = 480;
        int height = 266;
        setSize(width, height);
        setTitle("File Monitor:D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void loadImage(String src) throws FileNotFoundException {
        img = new ImageIcon(src).getImage();
        if (new ImageIcon(src).getIconHeight() < 0) throw new FileNotFoundException(src);
    }

    public void drawIcon() {
        Graphics g = getGraphics();
        g.drawImage(img, 0, 20, null);
    }
}