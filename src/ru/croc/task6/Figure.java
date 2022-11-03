package ru.croc.task6;

public abstract class Figure implements Movable {
    protected String signature;

    public String getSignature(){
        return signature;
    }

    abstract public Boolean inArea(int x, int y);
}
