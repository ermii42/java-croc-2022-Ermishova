package ru.croc.task10;

public class Solution {
    public static volatile String password;
    public static volatile String hex;

    public static String calculatePassword(int threadsCounter, String hash) {
        hex = hash;

        Thread[] threads = new Thread[threadsCounter];

        for (int i = 1; i <= threadsCounter; ++i) {
            threads[i - 1] = new Thread(new FindPassword(i, threadsCounter, 7));
            threads[i - 1].start();
        }
        try {
            for (int i = 0; i < threadsCounter; ++i) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return password;
    }
}