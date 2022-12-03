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
        // выборка (список фильмов пользователей со схожими интересами, которые не смотрел юзер)
        Set<Integer> sample = new HashSet<>();

        // отбор из базы данных людей, с которыми у пользователя совпадают интересы
        for (List<Integer> integers : preferencesBase) {
            ArrayList<Integer> pref = (ArrayList<Integer>) integers;
            if (intersection(pref)) {
                for (Integer movie : pref) {
                    if (!user.contains(movie)) {
                        sample.add(movie);
                    }
                }
            }
        }
        int maxCount = -1;
        int currentCount;
        String film = "";
        // выбор наиболее просматриваемого фильма, который не смотрел пользователь и который смотрели люди с похожими интересами
        for (Integer movie : sample) {
            currentCount = 0;
            for (List<Integer> integers : preferencesBase) {
                currentCount += getNumberOfEntries(integers, movie);
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                film = films.get(movie);
            }
        }
        if(maxCount == -1){
            return null;
        }
        return film;
    }

    // метод возвращает число вхождений элемента в список
    private int getNumberOfEntries(List<Integer> preference, int filmNumber) {
        int result = 0;
        for (Integer elem : preference) {
            if (elem.equals(filmNumber)) {
                result++;
            }
        }
        return result;
    }

    // метод возвращает true, если кол-во совпадающих элементов больше или равно половине
    // количества просмотренных пользователем фильмов
    // и false, если меньше половины
    private boolean intersection(List<Integer> preference) {
        int k = 0;
        List<Integer> watched = new ArrayList<>();
        for (Integer number : preference) {
            if (user.contains(number) && !watched.contains(number)) {
                k++;
                watched.add(number);
            }
        }
        return k >= (user.size() / 2 + user.size() % 2);
    }
}
