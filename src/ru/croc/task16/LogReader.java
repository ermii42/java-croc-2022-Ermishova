package ru.croc.task16;

import java.io.*;

public class LogReader {
    private final BufferedReader bufferedReader;
    private long time;
    private String message;

    public LogReader(File path) throws IOException {
        bufferedReader = new BufferedReader(new FileReader(path));
        readLogLine();
    }

    public long getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public String readLogLine() throws IOException {
        String line = bufferedReader.readLine();
        if(line != null){
            String[] args = line.split(" ");
            time = Long.parseLong(args[0]);
            message = args[1];
        }
        return line;
    }
}
