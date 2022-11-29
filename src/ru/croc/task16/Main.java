package ru.croc.task16;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        mergeLogs("src/ru/croc/task16/logs/");
    }

    static void mergeLogs(String directory) {
        File dir = new File(directory);
        Stream<String> s = Arrays.stream(new String[]{});
        for (String fname : Objects.requireNonNull(dir.list())) {
            if (fname.contains(".log") || fname.contains(".trace")) {
                try {
                    s = Stream.concat(Files.lines(Paths.get(directory + fname)), s);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        s = s.sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                long l = Long.parseLong(o1.substring(0, o1.indexOf(' ')));
                long l2 = Long.parseLong(o2.substring(0, o2.indexOf(' ')));
                if (l > l2) {
                    return 1;
                } else if (l == l2) {
                    return 0;
                }
                return -1;
            }
        });
        for (String st : s.toList()) {
            System.out.println(st);
        }
    }
}
