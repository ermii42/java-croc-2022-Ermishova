package ru.croc.task10;

public class Main {
    public static void main(String[] args) {
        String password = Solution.calculatePassword(Integer.parseInt(args[0]), args[1]);
        System.out.println(password);
    }
}
