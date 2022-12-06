package ru.croc.task18;

public class NotUniqueException extends Exception {
    private final String vendorCode;

    public NotUniqueException(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    @Override
    public String getMessage() {
        return "Продукт с артиклем " + vendorCode + " уже существует";
    }

}
