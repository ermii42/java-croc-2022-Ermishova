package ru.croc.task15;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {

        String[] scan;
        Tree tree = new Tree(new Node(null, 0));
        try (Scanner s = new Scanner(new FileReader("src/ru/croc/task15/sourse/" + "input.txt"))) {
            while (s.hasNextLine()) {
                scan = s.nextLine().split(",");

                if (scan[1].equals("-")) {
                    tree = new Tree(new Node(scan[0], parseInt(scan[2])));
                } else {
                    tree.addNode(scan[0], scan[1], parseInt(scan[2]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(tree.findTime(tree.getRoot()));
    }
}
