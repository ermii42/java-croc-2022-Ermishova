package ru.croc.task6;

public abstract class Figure {
    protected String signature;

    public String getSignature(){
        return signature;
    }

    abstract public int getX1();
    abstract public int getY1();
    abstract public int getX2();
    abstract public int getY2();

    abstract public int getRadius();
    abstract public int getX0();
    abstract public int getY0();
}
