package ru.croc.task11;


import java.util.Date;
import java.util.Scanner;

public class Lot implements Runnable {
    private static final Object lock = new Object();
    int currentPrice;
    String userName;
    Date date;

    // в конструктор подается время окончания торгов
    public Lot(Date date) {
        this.date = date;
    }

    // ставка
    public boolean Bid(int currentPrice, String userName, Date date) {
        if (date.before(this.date)) return false;
        if (currentPrice < this.currentPrice) {
            this.currentPrice = currentPrice;
            this.userName = userName;
        }
        return true;
    }

    // получение победителя
    public String getWinner() {
        return userName;
    }


    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        int pr;
        String name;
        while (true) {
            synchronized (lock) {
                pr = in.nextInt();
                name = in.next();
                // на вход подается текущее время
                // если оно позже закрытия торгов, аукцион прекращается
                if (!Bid(pr, name, new Date())) break;
            }
        }
        System.out.println("И победителем аукциона является - " + getWinner());
    }
}
