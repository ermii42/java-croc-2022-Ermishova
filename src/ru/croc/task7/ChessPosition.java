package ru.croc.task7;

public class ChessPosition {
    private int x, y;
    private static String board = "abcdefgh";

    static ChessPosition parse(String position) throws IllegalPositionException {
        ChessPosition obj = new ChessPosition();
        int x = board.indexOf(position.charAt(0))+1;
        int y = position.charAt(1)-'0';
        if(x<1 || x > 8 || y<1 || y>8) throw new IllegalPositionException();
        obj.setX(x);
        obj.setY(y);
        return obj;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getPosition(){
        return String.format("%s%d", board.charAt(x-1), y);
    }

    @Override
    public String toString() {
        return String.format("%s%d", board.charAt(x-1), y);
    }
}
