package ru.croc.task12;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Comments implements BlackListFilter {
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        List<String> deletedComments = new ArrayList<>();
        for (String comment : comments) {
            for (String badWord : blackList) {
                if (comment.toLowerCase(Locale.ROOT).contains(badWord.toLowerCase(Locale.ROOT))) {
                    int index = comment.toLowerCase(Locale.ROOT).indexOf(badWord.toLowerCase(Locale.ROOT));
                    if (index == 0 && index + badWord.length() <= comment.length()) {
                        if (!Character.isLetter(comment.charAt(index + badWord.length()))) {
                            deletedComments.add(comment);
                        }
                    } else if(index != 0 && index + badWord.length() <= comment.length()){
                        if (!Character.isLetter(comment.charAt(index - 1))
                                && !Character.isLetter(comment.charAt(index + badWord.length()))) {
                            deletedComments.add(comment);
                        }
                    }
                    else{
                        deletedComments.add(comment);
                    }
                }
            }
        }
        comments.removeAll(deletedComments);
    }
}
