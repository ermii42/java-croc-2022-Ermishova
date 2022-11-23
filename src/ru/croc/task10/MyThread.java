package ru.croc.task10;

import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final long from;
    private final long to;
    private final String hex;
    public static volatile boolean isFind = false;

    public MyThread(long from, long to, String hex) {
        this.from = from;
        this.hex = hex;
        this.to = to;
    }

    @Override
    public String call() {
        for (long i = from; i <= to && !isFind; i++) {
            if (!Hash.check(i)) continue;
            String code = Hash.code(i);
            if (hex.equals(Hash.hashPassword(code))) {
                MyThread.isFind = true;
                return code;
            }
        }
        return "";
    }
}