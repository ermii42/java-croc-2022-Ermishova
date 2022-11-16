package ru.croc.task10;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//java src/ru/croc/task10/Main.java 2 40682260CC011947FC2D0B1A927138C5
public class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        String hex = args[1];
        Thread t;
        int len = 5;
        long min = min(len);
        long max = max(len);
        long step = (max - min) / n;
        long from = min;
        int k = 0;

        // перебор
        for (long i = min + step; i <= max; i += step) {
            t = new MyThread(from, i, hex);
            t.run();
            from = i + 1;
            k++;
            if (k == n) break;
        }
        t = new MyThread(from, max, hex);
        t.run();

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

    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

    private static String toHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(HEX_DIGITS[(b & 0xff) >> 4]);
            hex.append(HEX_DIGITS[b & 0x0f]);
        }
        return hex.toString();
    }

    private static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(password.getBytes());
        byte[] bytes = digest.digest();
        return toHexString(bytes);
    }

}
