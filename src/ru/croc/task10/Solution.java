package ru.croc.task10;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Solution {
    private static int len = 7;

    public static String calculatePassword(int threadsNumber, String hashPass) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(threadsNumber);

        //Thread t;
        // длина исходного пароля
        long min = min(len);
        long max = max(len);
        long step = (max - min) / threadsNumber;
        long from = min;
        int k = 0;
        Future<String> result;

        // перебор
        for (long i = min + step; i <= max; i += step) {
            //t = new MyThread(from, i, hashPass);
            result = pool.submit(new MyThread(from, i, hashPass));
            from = i + 1;
            k++;
            if(!result.get().isEmpty()) return result.get();
            if (k == threadsNumber - 1) break;
        }
        result = pool.submit(new MyThread(from, max, hashPass));
        return result.get();
    }

    public void setLen(int len) {
        this.len = len;
    }

    static long max(long length) {
        long max = 0;
        long radixPower = 1;
        for (int i = 0; i < length; i++) {
            radixPower = i == 0 ? 1 : radixPower * 36;
            max = max + radixPower;
        }
        return max * 35;
    }

    static long min(long length) {
        long min = 0;
        long radixPower = 1;
        for (int i = 0; i < length; i++) {
            radixPower = i == 0 ? 1 : radixPower * 36;
            min = min + radixPower;
        }
        return min * 10;
    }
}
