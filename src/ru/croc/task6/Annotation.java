package ru.croc.task6;

public class Annotation {
    private Figure figure;

    Annotation(int x0, int y0, int radius, String signature){
        this.figure = new Circle(x0, y0, radius, signature);
    }

    Annotation(int x1, int y1, int x2, int y2, String signature){
        this.figure = new Rectangle(x1,y1,x2,y2,signature);
    }

    public Boolean inArea(int x, int y){
        return figure.inArea(x, y);
    }

    public String getSignature(){return figure.getSignature();}

    @Override
    public String toString(){
        return figure.toString();
    }
}
