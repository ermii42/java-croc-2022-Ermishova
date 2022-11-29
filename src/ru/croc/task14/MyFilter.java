package ru.croc.task14;


import java.util.*;
import java.util.function.Predicate;

public class MyFilter<E> implements BlackListFilter<E> {
    @Override
    public List<E> filterComments(Iterable<E> comments, Predicate<? super E> predicate) {
        List<E> out = new ArrayList<>();
        for (E comment : comments) {
            if (!predicate.test(comment)) out.add(comment);
        }
        return out;
    }
}
