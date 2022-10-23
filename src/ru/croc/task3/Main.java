package ru.croc.task3;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] numbers = in.nextLine().split(" ");
        int n=numbers.length;

        // чтобы избежать лишних циклов, я определяю минимальное
        // и максимальное числа на стадии ввода
        int minim = 2147483647, maxim = -2147483647;
        int minIndex=0, maxIndex=0;
        int newNumber;

        int[] mas = new int[n];
        // Заполнение массива числами
        for(int i=0; i<n; i++){
            // ввод нового числа
            newNumber = Integer.parseInt(numbers[i]);
            // сразу проверяем, является ли оно минимальным или максимальным
            if(newNumber<minim){
                minim = newNumber;
                minIndex = i;
            }
            if(newNumber>maxim){
                maxim = newNumber;
                maxIndex = i;
            }
            //
            mas[i] = newNumber;
        }

        if(minIndex!=0) {
            // меняем элементы местами (минимальный и нулевой)
            mas[minIndex] += mas[0];
            mas[0] = mas[minIndex] - mas[0];
            mas[minIndex] = mas[minIndex] - mas[0];
        }
        if(maxIndex==0) maxIndex=minIndex;

        if(maxIndex!=n-1) {
            // меняем элементы местами (максимальный и последний)
            mas[maxIndex] += mas[n - 1];
            mas[n - 1] = mas[maxIndex] - mas[n - 1];
            mas[maxIndex] = mas[maxIndex] - mas[n - 1];
        }

        for(int i=0; i<n; i++){
            System.out.print(mas[i]+" ");
        }
    }
}
