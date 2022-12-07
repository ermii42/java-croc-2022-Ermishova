package ru.croc.task16;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Queue;

public class LogFiles {
    private static Queue<LogReader> filesQueue = new PriorityQueue<LogReader>(new Comparator<LogReader>() {
        @Override
        public int compare(LogReader o1, LogReader o2) {
            return Long.compare(o1.getTime(), o2.getTime());
        }
    });

    public static void readLogFiles(Path dir) throws IOException {
        for (File file: Files.walk(dir).filter(Files::isRegularFile)
                .filter(file -> file.getFileName().toString().toLowerCase(Locale.ROOT).matches(".+(.log|.trace)"))
                .map(Path::toFile).toList()){
            filesQueue.add(new LogReader(file));
        }
        while (!filesQueue.isEmpty()) {
            LogReader logFile = filesQueue.poll();
            System.out.println(logFile.getTime() + " " + logFile.getMessage());
            if (logFile.readLogLine() != null) {
                filesQueue.add(logFile);
                continue;
            }
            logFile.getBufferedReader().close();
        }
    }
}
