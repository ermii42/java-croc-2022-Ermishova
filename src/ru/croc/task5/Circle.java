package ru.croc.task5;

public class Circle extends Figure {
    private int x0, y0, radius;

    Circle(int x0, int y0, int radius){
        this.x0 = x0;
        this.y0 = y0;
        this.radius = radius;
    }


    @Override
    public String toString() {
        return String.format("C (%d, %d), %d: ", x0, y0, radius);
    }
}

