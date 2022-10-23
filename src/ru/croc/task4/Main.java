package ru.croc.task4;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String source;
        String noComments;

        while(true){
            source = in.nextLine();
            noComments = removeJavaComments(source);
            System.out.println(noComments);
        }
    }

    private static String removeJavaComments(String source){
        String output = "";
        boolean flag1 = false; // флаг, отвечающий за наличие в строке символа '/'
        boolean flag2 = false; // флаг, отвечающий за наличие в строке символа '*'
        for(int i=0; i<source.length(); i++){
            if(source.charAt(i) == '/'){
                if(flag2 && flag1){ // проверка, заканчивается ли комментарий ("*/")
                    flag1 = false;
                    flag2 = false;
                    continue;
                }
                if(flag1) break; // проверка, является ли комментарий однострочным ("//")
                flag1 = true;
            }
            else if(source.charAt(i) == '*'){
                flag2 = true;
            }
            else if(!flag1 && !flag2){
                output += source.charAt(i);
            }
        }
        return output;
    }
}
