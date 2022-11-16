package ru.croc.task9;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(getPath(input));
    }

    public static String getPath(String line) {
        String[] lst = line.split("/");
        LinkedList<String> res = new LinkedList<>();
        boolean prevString = false;
        for (String elem : lst) {
            if (elem.equals("..")) {
                if (res.isEmpty() || !prevString) {
                    res.add("..");
                    prevString = false;
                } else {
                    res.removeLast();
                    if (res.isEmpty()) continue;
                    else if (res.getLast().equals("..")) prevString = false;
                }
            } else if (elem.equals(".")) {
            } else {
                res.add(elem);
                prevString = true;
            }
        }
        return String.join("/", res);
    }
}
