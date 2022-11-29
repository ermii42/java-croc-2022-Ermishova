package ru.croc.task12;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface BlackListFilter {
    public void filterComments(List<String> comments, Set<String> blackList);
}
