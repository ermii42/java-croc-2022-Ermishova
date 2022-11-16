package ru.croc.task9;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(getPath(input));
    }

    public static String getPath(String line) {
        Pattern pattern = Pattern.compile("\\.{1,2}/([a-zA-Z0-9а-яА-Я/]+)");
        Matcher matcher = pattern.matcher(line);
        int k = 0;
        while (matcher.find(k)) {
            k++;
        }
        k -= 2;
        if (k < 0) return line;
        else if (matcher.find(k)) {
            return matcher.group();
        }
        return "";
    }
}
