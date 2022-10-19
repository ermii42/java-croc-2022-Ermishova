package ru.croc.task1;
import java.util.Scanner;

public class Main {

    static class Point {
        double x;
        double y;

        // раастояние между двумя точками
        double getDistance(Point a){
            return Math.sqrt((x-a.x)*(x-a.x)+(y-a.y)*(y-a.y));
        }
    }

    // поиск площади (использую формулу Герона)
    static double square(Point a, Point b, Point c){
        double abSide, acSide, bcSide;
        // вычисление всех трех сторон
        abSide = a.getDistance(b);
        acSide = a.getDistance(c);
        bcSide = b.getDistance(c);

        // проверка треугольника на существование
        if((abSide+acSide <= bcSide)||(abSide+bcSide<=acSide)||(bcSide+acSide)<=abSide){
            return -1;
        }

        // вычисление полупериметра
        double SemiPerimentr = (abSide + acSide + bcSide)/2;
        // по формуле Герона вычисляем площадь
        double result = Math.sqrt(SemiPerimentr*(SemiPerimentr-abSide)*(SemiPerimentr-acSide)*(SemiPerimentr-bcSide));
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ввод координат вершин
        Point a = new Point();
        System.out.print("Введите координату х вершины №1: ");
        a.x = input.nextDouble();
        System.out.print("Введите координату y вершины №1: ");
        a.y = input.nextDouble();

        Point b = new Point();
        System.out.print("Введите координату х вершины №2: ");
        b.x = input.nextDouble();
        System.out.print("Введите координату y вершины №2: ");
        b.y = input.nextDouble();

        Point c = new Point();
        System.out.print("Введите координату х вершины №3: ");
        c.x = input.nextDouble();
        System.out.print("Введите координату y вершины №3: ");
        c.y = input.nextDouble();

        // обработка ошибки
        double result = square(a, b, c);
        if(result == -1) System.out.println("Треугольник с заданными координатами вершин не существует!");
        else System.out.println("Площадь треугольника равна: " + result);
        // ...
    }
}

