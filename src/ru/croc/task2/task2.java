package ru.croc.task2;
import java.util.Scanner;

public class task2 {
    static void printBytes(double number){

        // массив ед. измерения
        String ByteSize[] = {"B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};
        int k=0;
        while(number/1024.0 >= 1){
            k++;
            number /= 1024.0;
        }
        // вывод в "человеко-читаемом" формате
        System.out.println(String.format("%.1f", number)+" "+ByteSize[k]);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        printBytes(input.nextDouble());
    }

}
