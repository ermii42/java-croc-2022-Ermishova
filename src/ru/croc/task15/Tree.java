package ru.croc.task15;

import java.util.HashMap;
import java.util.Map;

public class Tree {
    private Node root;
    private Map<String, Node> tree = new HashMap<>();

    public Tree(Node root) {
        this.root = root;
        tree.put(root.getName(), root);
    }

    public void addNode(String name, String parent, int hours){
        Node node = new Node(name, hours);
        tree.put(name, node);
        tree.get(parent).addOffspring(node);
    }

    public Node getRoot() {
        return root;
    }
}
