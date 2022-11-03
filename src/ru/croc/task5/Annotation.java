package ru.croc.task5;

public class Annotation {
    private Figure figure;
    private String signature;


    Annotation(int x0, int y0, int radius, String signature){
        this.signature = signature;
        this.figure = new Circle(x0, y0, radius);
    }

    Annotation(int x1, int y1, int x2, int y2, String signature){
        this.signature = signature;
        this.figure = new Rectangle(x1,y1,x2,y2);
    }

    public String getSignature(){return signature;}

    @Override
    public String toString(){
        return figure.toString()+signature;
    }
}
