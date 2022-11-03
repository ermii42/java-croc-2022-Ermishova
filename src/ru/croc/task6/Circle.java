package ru.croc.task6;

public class Circle extends Figure{
    private int x0, y0, radius;

    Circle(int x0, int y0, int radius){
        this.x0 = x0;
        this.y0 = y0;
        this.radius = radius;
    }

    @Override
    public void move(int dx, int dy) {
        x0 = dx;
        y0 = dy;
    }

    @Override
    public String toString() {
        return String.format("C (%d, %d), %d: ", x0, y0, radius);
    }

    @Override
    public Boolean inArea(int x, int y){
        if(((x-x0)*(x-x0) + (y-y0)*(y-y0)) <= radius*radius) return true;
        return false;
    }
}
