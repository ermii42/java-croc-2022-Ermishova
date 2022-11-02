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
    public int getX1() {
        return x1;
    }

    @Override
    public int getY1() {return y1;}

    @Override
    public int getX2() {
        return x2;
    }

    @Override
    public int getY2() {
        return y2;
    }

    @Override
    public int getRadius() {
        return 0;
    }

    @Override
    public int getX0() {
        return 0;
    }

    @Override
    public int getY0() {
        return 0;
    }
}
