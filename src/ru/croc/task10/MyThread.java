package ru.croc.task10;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final long from;
    private final long to;
    private final String hex;

    public MyThread(long from, long to, String hex) {
        this.from = from;
        this.hex = hex;
        this.to = to;
    }

    @Override
    public String call() throws Exception {
        for (long i = from; i <= to; i++) {
            if (!check(i)) continue;
            String code = code(i);
            if (hex.equals(hashPassword(code))) {
                return code;
            }
        }
        return "";
    }

    public static String hashPassword(String password) {
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

    static boolean check(long i) {
        while (i != 0) {
            if (0 <= i % 36 && i % 36 <= 9)
                return false;
            i /= 36;
        }
        return true;
    }

    // В данном конкретном случае можно схитрить и воспользоваться стандартной функцией
    static String code(long n) {
        return Long.toString(n, 36);
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


}
