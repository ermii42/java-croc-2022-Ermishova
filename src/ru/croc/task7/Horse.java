package ru.croc.task7;

public class Horse {
    public void check(ChessPosition start, ChessPosition end) throws IllegalMoveException{
        if(Math.abs(start.getX()-end.getX())==1 && Math.abs(start.getY()-end.getY())==2) return;
        if(Math.abs(start.getY()-end.getY())==1 && Math.abs(start.getX()-end.getX())==2) return;
        throw new IllegalMoveException(start, end);
    }
}
