package ru.croc.task12;

import java.util.*;

public class Comments implements BlackListFilter {
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        // список комментариев, которые необходимо удалить после фильтрации
        List<String> deletedComments = new ArrayList<>();
        metka:
        for (String comment : comments) {
            for (String badWord : blackList) {
                // проверка, есть ли в строке плохие слова
                for (String elem : comment.toLowerCase(Locale.ROOT).split("[^A-Za-zА-Яа-я]+")) {
                    if (elem.equals(badWord)) {
                        deletedComments.add(comment);
                        continue metka;
                    }
                }
            }
        }
        comments.removeAll(deletedComments);
    }
}
