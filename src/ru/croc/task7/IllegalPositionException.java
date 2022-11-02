package ru.croc.task7;

public class IllegalPositionException extends Exception{
    @Override
    public String getMessage() {
        return "Каждый индекс должен находится в диапазоне от 1 до 8";
    }
}
