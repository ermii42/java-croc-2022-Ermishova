package ru.croc.task1;
import java.util.Scanner;

public class Main {

    static class Point {
        double x;
        double y;

        double getDistance(Point a){
            return Math.sqrt((x-a.x)*(x-a.x)+(y-a.y)*(y-a.y));
        }
    }

    static double square(Point a, Point b, Point c){
        double ab_side, ac_side, bc_side;
        ab_side = a.getDistance(b);
        ac_side = a.getDistance(c);
        bc_side = b.getDistance(c);
        double semi_perimentr = (ab_side + ac_side + bc_side)/2;
        double result = Math.sqrt(semi_perimentr*(semi_perimentr-ab_side)*(semi_perimentr-ac_side)*(semi_perimentr-bc_side));
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

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

        System.out.println("Площадь треугольника равна: " + square(a, b, c));
        // ...
    }
}

