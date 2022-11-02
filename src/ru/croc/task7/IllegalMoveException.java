package ru.croc.task7;

public class IllegalMoveException extends Exception{
    private ChessPosition position1, position2;

    IllegalMoveException(ChessPosition position1, ChessPosition position2){
        this.position1 = position1;
        this.position2 = position2;
    }

    @Override
    public String getMessage() {
        return String.format("конь так не ходит: %s -> %s", position1.getPosition(), position2.getPosition());
    }
}
