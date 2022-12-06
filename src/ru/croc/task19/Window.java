package ru.croc.task19;

import javax.swing.*;
import java.awt.*;

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

    public void loadImage(String src) {
        img = new ImageIcon(src).getImage();
        if (img == null) System.out.println("Нет картинки");
    }

    public void drawIcon() {
        Graphics g = getGraphics();
        g.drawImage(img, 0, 20, null);
    }
}