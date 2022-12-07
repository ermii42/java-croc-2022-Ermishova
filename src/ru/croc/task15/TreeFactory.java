package ru.croc.task15;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class TreeFactory {
    public static Tree createTree(String path) throws FileNotFoundException {
        Tree tree = new Tree();
        String[] scan;
        try (Scanner s = new Scanner(new FileReader(path))) {
            while (s.hasNextLine()) {
                scan = s.nextLine().split(",");

                if (scan[1].equals("-")) {
                    tree.setRoot(new Node(scan[0], parseInt(scan[2])));
                } else {
                    tree.addNode(scan[0], scan[1], parseInt(scan[2]));
                }
            }
        }
        return tree;
    }
}
