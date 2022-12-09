package ru.croc.task19;

import java.io.FileNotFoundException;

public class task19 {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        loadAnimation();
    }

    public static void loadAnimation() throws InterruptedException, FileNotFoundException {
        Window wind = new Window();
        int k = 0;
        while (k < 1 << 5) {
            for (int i = 1; i < 72; i++) {
                wind.loadImage("src/ru/croc/task19/sourse/" + i + ".png");
                wind.drawIcon();
                Thread.sleep(50);
                k++;
            }
        }
    }
}
