package ru.croc.task16;

import java.io.IOException;
import java.nio.file.Path;


public class task16 {
    public static void main(String[] args) throws IOException {
        LogFiles.readLogFiles(Path.of(args[0]));
    }
}
