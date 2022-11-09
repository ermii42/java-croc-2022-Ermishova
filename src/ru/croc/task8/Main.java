package ru.croc.task8;

import java.io.*;

/*
Путь к файлу задается первым аргументом командной строки (args[0]).
 */
public class Main {
    public static void main(String[] args) {
        int k=0;
        try (BufferedReader r = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = r.readLine()) != null)
                k += line.split("[\\s,;]+").length;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(k);
    }
}
//java src/ru/croc/task8/Main.java src/ru/croc/task8/sourse/inp.txt
