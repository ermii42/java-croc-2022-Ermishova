package ru.croc.task15;

import java.util.ArrayList;

// узел
public class Node {
    private final ArrayList<Node> offsprings = new ArrayList<>();
    private final int hours;
    private final String name;

    public Node(String name, int hours) {
        this.hours = hours;
        this.name = name;
    }

    public void addOffspring(Node elem) {
        offsprings.add(elem);
    }

    public ArrayList<Node> getOffsprings() {
        return offsprings;
    }

    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }
}
