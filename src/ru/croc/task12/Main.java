package ru.croc.task12;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<String> comments = new ArrayList<>();
        comments.add("Вкусные блинчики получились, хороший рецепт!");
        comments.add("Вкусные блинчики получились, классный,блин, рецепт!");
        comments.add("блинчики получились, каждый блинчик просто нечто!");
        comments.add("Тесто ужас");
        comments.add("Блин не повезло");
        comments.add("Ужас, а не рецепт рецепт");
        comments.add("ужасно вкусно");
        Set<String> blackList = new HashSet<>();
        blackList.add("блин");
        blackList.add("ужас");
        Comments commentsFilter = new Comments();
        commentsFilter.filterComments(comments, blackList);
        for (String comment : comments) {
            System.out.println(comment);
        }
    }
}
