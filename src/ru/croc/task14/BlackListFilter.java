package ru.croc.task14;

import java.util.Collection;
import java.util.function.Predicate;

public interface BlackListFilter<E> {

    public Collection<E> filterComments(Iterable<E> comments, Predicate<? super E> predicate);
}
