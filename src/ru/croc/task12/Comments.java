package ru.croc.task12;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Comments implements BlackListFilter {
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        // список комментариев, которые необходимо удалить после фильтрации
        List<String> deletedComments = new ArrayList<>();
        for (String comment : comments) {
            for (String badWord : blackList) {
                // проверка, является ли плохое слово подсловом другого или нет (однокоренные слова не учитываются)
                if (comment.toLowerCase(Locale.ROOT).contains(badWord.toLowerCase(Locale.ROOT))) {
                    int index = comment.toLowerCase(Locale.ROOT).indexOf(badWord.toLowerCase(Locale.ROOT));
                    boolean b1 = index + badWord.length() <= comment.length();
                    boolean b2 = !Character.isLetter(comment.charAt(index + badWord.length()));
                    if (index == 0 && b1) {
                        if (b2) {
                            deletedComments.add(comment);
                        }
                    } else if (index != 0 && b1) {
                        if (!Character.isLetter(comment.charAt(index - 1)) && b2) {
                            deletedComments.add(comment);
                        }
                    } else {
                        deletedComments.add(comment);
                    }
                }
            }
        }
        comments.removeAll(deletedComments);
    }
}
