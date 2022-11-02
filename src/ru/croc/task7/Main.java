package ru.croc.task7;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IllegalPositionException, IllegalMoveException {
        String[] pos = {"g8", "e7", "e6"};

        ChessPosition[] chessPositions = new ChessPosition[pos.length];
        for (int i=0; i< pos.length; i++){
            chessPositions[i] = ChessPosition.parse(pos[i]);
        }

        Horse horse = new Horse();
        for(int i=1; i< pos.length;i++){
            horse.check(chessPositions[i-1], chessPositions[i]);
        }
        System.out.println("OK");
    }
}
