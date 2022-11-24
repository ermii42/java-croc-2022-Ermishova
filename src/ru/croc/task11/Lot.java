package ru.croc.task11;


import java.util.Date;
import java.util.Scanner;

public class Lot {
    private static final Object lock = new Object();
    int currentPrice;
    private volatile String userName = "";
    private volatile Date date;

    // в конструктор подается время окончания торгов
    public Lot(Date date) {
        this.date = date;
    }

    // ставка
    public boolean Bid(int currentPrice, String userName, Date date) {
        synchronized (lock){
            if (date.after(this.date)) return false;
            if (currentPrice > this.currentPrice) {
                this.currentPrice = currentPrice;
                this.userName = userName;
            }
            return true;
        }
    }

    // получение победителя
    public String getWinner() {

        if((new Date()).before(this.date)){
            return "ставки не окончены";
        }
        else{
            return userName;
        }
    }
}
