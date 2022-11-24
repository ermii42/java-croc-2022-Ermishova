package ru.croc.task13;

import java.util.*;

public class Recommendations {
    private final Map<Integer, String> films; // база фильмов
    private final List<List<Integer>> preferencesBase; // данные о предпочтениях других пользователей
    private final List<Integer> user; // просмотры пользователя

    public Recommendations(Map<Integer, String> films, List<List<Integer>> preferencesBase, List<Integer> user) {
        this.films = films;
        this.preferencesBase = preferencesBase;
        this.user = user;
    }

    // метод возвращает строковое значение - название фильма, которое стоит посмотреть пользователю.
    // если фильм не был найден, метод возвращает пустую строку
    public String getRecommendation() {
        // список пользователей, с которыми совпадают интересы
        List<List<Integer>> interestsCoincide = new ArrayList<>();

        // отбор из базы данных людей, с которыми у пользователя совпадают интересы
        for (List<Integer> integers : preferencesBase) {
            ArrayList<Integer> pref = (ArrayList<Integer>) integers;
            if (intersection(pref)) {
                interestsCoincide.add(pref);
            }
        }

        // поиск фильма по алгоритму
        int maxCount = -1;
        String film = "";
        int currentCount;
        for (Map.Entry<Integer, String> entry : films.entrySet()) {
            currentCount = 0;
            for (List<Integer> interest : interestsCoincide) {
                if (!user.contains(entry.getKey())) {
                    currentCount += getNumberOfEntries(interest, entry.getKey());
                }
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                film = entry.getValue();
            }
        }
        return film;
    }

    // метод возвращает число вхождений элемента в список
    private int getNumberOfEntries(List<Integer> preference, int filmNumber) {
        int result = 0;
        for (Integer elem : preference) {
            if (elem.equals(filmNumber)) result++;
        }
        return result;
    }

    // метод возвращает true, если кол-во совпадающих элементов больше или равно половине количества просмотренных пользователем фильмов
    // и false, если меньше половины
    private boolean intersection(List<Integer> preference) {
        int k = 0;
        for (Integer number : preference) {
            if (user.contains(number)) k++;
        }
        return k >= (user.size() / 2 + user.size() % 2);
    }
}
