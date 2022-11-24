package ru.croc.task13;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // получение базы фильмов из файла
        Map<Integer, String> films = new HashMap<>();
        String scan;
        try (Scanner s = new Scanner(new FileReader("src/ru/croc/task13/sourse/" + "films.txt"))) {
            while (s.hasNextLine()) {
                scan = s.nextLine();
                films.put(scan.charAt(0) - '0', scan.substring(2));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // получение базы просмотров людей
        List<List<Integer>> users = new ArrayList<>();
        List<Integer> user;
        try (Scanner s = new Scanner(new FileReader("src/ru/croc/task13/sourse/" + "users.txt"))) {
            while (s.hasNextLine()) {
                int iterationCount = 0;
                scan = s.nextLine();
                user = new ArrayList<>();
                for (int i = 0; i < scan.length(); i += 2, iterationCount += 1) {
                    user.add(scan.charAt(i) - '0');
                }
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // ввод просмотров отдельного пользователя (через консоль)
        List<Integer> watchedMovies = new ArrayList<>();
        int iterationCount = 0;
        Scanner s = new Scanner(System.in);
        String userMovies = s.nextLine();
        for (int i = 0; i < userMovies.length(); i += 2, iterationCount += 1) {
            watchedMovies.add(userMovies.charAt(i) - '0');
        }

        // рекомендация фильма для конкретного пользователя
        Recommendations movie = new Recommendations(films, users, watchedMovies);
        String res = movie.getRecommendation();
        System.out.println(res);
    }
}
