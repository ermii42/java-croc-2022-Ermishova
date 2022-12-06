package ru.croc.task14;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> comments = new ArrayList<>();
        inputTestComments(comments);
        List<String> blackList = new ArrayList<>();
        inputTestBlackList(blackList);

        MyFilter<String> filter = new MyFilter<>();
        ArrayList<String> arr = (ArrayList<String>) comments;
        // фильтр плохих комментариев
        for (String badWord : blackList) {
            arr = (ArrayList<String>) filter.filterComments(arr, isContains(badWord));
        }
        // вывод результата
        for (String arg : arr) {
            System.out.println(arg);
        }

    }

    // заполнение списка тестовыми комментариями
    static void inputTestComments(List<String> comments) {
        comments.add("Вкусные блинчики получились, хороший рецепт!");
        comments.add("Вкусные блинчики получились, классный,блин, рецепт!");
        comments.add("блинчики получились, каждый блинчик просто нечто!");
        comments.add("Тесто ужас");
        comments.add("Блин не повезло");
        comments.add("Ужас, а не рецепт рецепт");
        comments.add("ужасно вкусно");
    }

    // заполнение списка плохими тестовыми словами
    static void inputTestBlackList(List<String> blackList) {
        blackList.add("блин");
        blackList.add("ужас");
    }

    // предикат для проверки программы
    static Predicate<String> isContains(String badWOrd) {
        return p -> Arrays.asList(p.toLowerCase(Locale.ROOT).split("[^A-Za-zА-Яа-я]+")).contains(badWOrd);
    }
}
