package ru.croc.task5;

public class Rectangle extends Figure {
    private int x1, y1, x2, y2;
    Rectangle(int x1, int y1, int x2, int y2, String signature){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.signature = signature;
    }

    @Override
    public String toString() {
        return String.format("R (%d, %d), (%d, %d): %s", x1, y1, x2, y2, signature);
    }
}