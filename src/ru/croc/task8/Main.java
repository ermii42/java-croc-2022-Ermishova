package ru.croc.task8;

import java.io.*;

/*
Путь к файлу задается первым аргументом командной строки (args[0]).
 */
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(countWords(args[0]));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static int countWords(String filename) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(filename));
        int k=0;
        String line;
        while ((line = r.readLine()) != null)
            if(!line.isEmpty()) k += line.split("[\\s,;]+").length;
        return k;
    }
}
//java src/ru/croc/task8/Main.java src/ru/croc/task8/sourse/inp.txt
