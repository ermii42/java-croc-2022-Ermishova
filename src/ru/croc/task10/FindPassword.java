package ru.croc.task10;

public class FindPassword implements Runnable {

    private final long start;
    private final long end;
    private final int symbols;
    private volatile boolean findPassword = false;

    @Override
    public void run() {
        for (long i = start; i <= end && !findPassword; ++i) {
            String password = makeCombination(i).toString();
            if (Hash.hashPassword(password).equals(Solution.hex)) {
                Solution.password = password;
                findPassword = true;
            }
        }
    }

    private StringBuilder makeCombination(long hex) {
        int[] password = new int[symbols];
        StringBuilder pass = new StringBuilder("");
        for (int i = 1; i <= symbols; ++i) {
            password[i - 1] = (int) (hex % 26);
            hex /= 26;
            pass.append((char) ('a' + password[i - 1]));
        }
        return pass;
    }

    public FindPassword(int number, int count, int symbols) {

        this.symbols = symbols;
        long countSymbols = (long) (Math.pow(26, symbols));
        start = (countSymbols * (number - 1)) / count;
        end = (countSymbols * number) / count - 1;
    }
}