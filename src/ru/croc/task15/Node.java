package ru.croc.task15;

import java.util.*;

// узел
public class Node {
    private final List<Node> offsprings = new ArrayList<>();
    private final int hours;
    private final String name;

    public Node(String name, int hours) {
        this.hours = hours;
        this.name = name;
    }

    public void addOffspring(Node elem) {
        offsprings.add(elem);
    }

    public String getName() {
        return name;
    }

    public int findTime() {
        int res = 0;
        for (Node node : offsprings) {
            res = Math.max(res, node.findTime());
        }
        return res + hours;
    }
}
