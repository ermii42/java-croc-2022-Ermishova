package ru.croc.task6;

public class Rectangle extends Figure {
    private int x1, y1, x2, y2;
    Rectangle(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void move(int dx, int dy) {
        x1 += dx;
        x2 += dx;
        y1 += dy;
        y2 += dy;
    }

    @Override
    public Boolean inArea(int x, int y) {
        if((x1 <= x && x <= x2) && (y1<=y && y<= y2)) return true;
        return false;
    }

    @Override
    public String toString() {
        return String.format("R (%d, %d), (%d, %d): ", x1, y1, x2, y2);
    }
}
