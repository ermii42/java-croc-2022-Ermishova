package ru.croc.task4;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String noComments;


        final String testSourse =
        "/*\n"+
         "* My first ever program in Java!\n"+
         "*/\n"+
        "class Hello { // class body starts here\n"+
        " \n"+
        "    /* main method */\n"+
        "    public static void main(String[] args/* we put command line arguments here*/) {\n"+
        "        // this line prints my first greeting to the screen\n"+
        "        System.out.println(\"Hi!\"); // :)\n"+
        "    }\n"+
        "} // the end\n"+
        "// to be continued...";

        noComments=removeJavaComments(testSourse);
        System.out.println(noComments);

        // ввод построчно до тех пор, пока пользователь не введет слово "стоп"

        /*
        String source="";
        source = in.nextLine();
        while(!source.equals("stop")){
            noComments = removeJavaComments(source);
            System.out.println(noComments);
            source = in.nextLine();
        }
        */
    }

    private static String removeJavaComments(String source){
        String output = "";
        boolean flag1 = false; // флаг, отвечающий за наличие в строке символа '/'
        boolean flag2 = false; // флаг, отвечающий за наличие в строке символа '*'
        String[] lines = source.split("\n");
        for(int j=0; j<lines.length; j++){
            for(int i=0; i<lines[j].length(); i++){
                if(lines[j].charAt(i) == '/'){
                    if(flag2 && flag1){ // проверка, заканчивается ли комментарий ("*/")
                        flag1 = false;
                        flag2 = false;
                        continue;
                    }
                    if(flag1) break; // проверка, является ли комментарий однострочным ("//")
                    flag1 = true;
                }
                else if(lines[j].charAt(i) == '*'){
                    flag2 = true;
                }
                else if(!flag1 && !flag2){
                    output += lines[j].charAt(i);
                }
            }
            if (j != lines.length-1) output += "\n";
            flag1 = false;
            flag2 = false;
        }
        return output;
    }
}
