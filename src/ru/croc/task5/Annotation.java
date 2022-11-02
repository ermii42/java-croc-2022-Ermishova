package ru.croc.task5;

public class Annotation {
    private Figure figure;
    private String type;

    Annotation(int x0, int y0, int radius, String signature){
        this.figure = new Circle(x0, y0, radius, signature);
        type = "circle";
    }

    Annotation(int x1, int y1, int x2, int y2, String signature){
        this.figure = new Rectangle(x1,y1,x2,y2,signature);
        type = "rectangle";
    }

    @Override
    public String toString(){
        if(type=="circle") return String.format("C (%d, %d), %d: %s",
                figure.getX0(), figure.getY0(), figure.getRadius(), figure.getSignature());
        else if(type=="rectangle") return String.format("R (%d, %d), (%d, %d): %s",
                figure.getX1(), figure.getY1(), figure.getX2(), figure.getY2(), figure.getSignature());
        return "";
    }
}
