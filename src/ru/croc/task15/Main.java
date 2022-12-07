package ru.croc.task15;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "src/ru/croc/task15/sourse/" + "input.txt";
        Tree tree = TreeFactory.createTree(path);
        System.out.println(tree.getRoot().findTime());
    }
}
