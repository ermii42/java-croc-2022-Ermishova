package ru.croc.task9;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\.{1,2}/([a-zA-Z0-9а-яА-Я/]+)");
        String input = in.nextLine();

        Matcher matcher = pattern.matcher(input);
        int k=0;
        while (matcher.find(k)){
            k++;
        }

        k-=2;
        if(k<0) System.out.println(input);
        else if(matcher.find(k)){
            System.out.println(matcher.group());
        }
    }
}
