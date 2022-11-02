package ru.croc.task5;

public class Circle extends Figure{
    private int x0, y0, radius;

    Circle(int x0, int y0, int radius, String signature){
        this.signature = signature;
        this.x0 = x0;
        this.y0 = y0;
        this.radius = radius;
    }

    @Override
    public int getX1() {
        return 0;
    }

    @Override
    public int getY1() {
        return 0;
    }

    @Override
    public int getX2() {
        return 0;
    }

    @Override
    public int getY2() {
        return 0;
    }

    @Override
    public int getRadius() {
        return radius;
    }

    @Override
    public int getX0() {
        return x0;
    }

    @Override
    public int getY0() {
        return y0;
    }

}
