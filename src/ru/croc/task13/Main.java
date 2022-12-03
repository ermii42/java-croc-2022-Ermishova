package ru.croc.task13;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // получение базы фильмов из файла
        Map<Integer, String> films = new HashMap<>();
        getFilmBase(films);

        // получение базы просмотров людей
        List<List<Integer>> users = new ArrayList<>();
        getPeopleBase(users);

        // ввод просмотров отдельного пользователя (через консоль)
        List<Integer> watchedMovies = new ArrayList<>();
        getWatchedMovies(watchedMovies);

        // рекомендация фильма для конкретного пользователя
        Recommendations movie = new Recommendations(films, users, watchedMovies);
        String res = movie.getRecommendation();
        System.out.println("Пользователю рекомендуем посмотреть фильм:");
        System.out.println(res);
    }

    static void getFilmBase(Map<Integer, String> films) {
        String[] scan;
        String path = "src/ru/croc/task13/sourse/" + "films.txt";
        try (Scanner s = new Scanner(new FileReader(path))) {
            while (s.hasNextLine()) {
                scan = s.nextLine().split(",");
                films.put(Integer.valueOf(scan[0]), scan[1]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + path + " не был найден");
            System.exit(-1);
        }
    }

    static void getPeopleBase(List<List<Integer>> users) {
        List<Integer> user;
        String[] scan;
        String path = "src/ru/croc/task13/sourse/" + "users.txt";
        try (Scanner s = new Scanner(new FileReader(path))) {
            while (s.hasNextLine()) {
                scan = s.nextLine().split(",");
                user = new ArrayList<>();
                for (String movie : scan) {
                    user.add(Integer.valueOf(movie));
                }
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + path + " не был найден");
            System.exit(-1);
        }
    }

    static void getWatchedMovies(List<Integer> watchedMovies) {
        System.out.println("Введите просмотры пользователя через запятую:");
        Scanner s = new Scanner(System.in);
        String[] userMovies = s.nextLine().split(",");
        for (String userMovie : userMovies) {
            watchedMovies.add(Integer.valueOf(userMovie));
        }
    }
}
