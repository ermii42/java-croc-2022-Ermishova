package ru.croc.task14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public interface BlackListFilter<E> {
    default List<E> filterComments(Iterable<E> comments, Predicate<E> predicate) {
        List<E> out = new ArrayList<>();
        for (E comment : comments) {
            if (!predicate.test(comment)) {
                out.add(comment);
            }
        }
        return out;
    }
}
