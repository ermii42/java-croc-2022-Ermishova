package ru.croc.task15;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String[] scan;
        Tree tree = new Tree();
        try (Scanner s = new Scanner(new FileReader("src/ru/croc/task15/sours/" + "input.txt"))) {
            while (s.hasNextLine()) {
                scan = s.nextLine().split(",");

                if (scan[1].equals("-")) {
                    tree.setRoot(new Node(scan[0], parseInt(scan[2])));
                } else {
                    tree.addNode(scan[0], scan[1], parseInt(scan[2]));
                }
            }
        }
        int result = tree.getRoot().findTime();
        System.out.println(result);
    }
}
