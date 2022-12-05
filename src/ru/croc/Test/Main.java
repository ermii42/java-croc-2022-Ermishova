package ru.croc.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Download: https://www.h2database.com/html/main.html
 * Run h2-{version}.jar
 * H2 tray icon -> Create a new database...
 *   Database path: ~/test
 *   Creates a new database file test.mv.db inn a home directory
 * Open h2-console localhost:8082 in a browser window
 *   JDBC URL: jdbc:h2:tcp://localhost/~/test
 * Run queries from schema.sql and data.sql files
 * Add h2 dependency to a project
 *   Open File -> Project Structure...
 *   Switch to Project Settings / Libraries
 *   + -> Java -> Select h2-{version}.jar
 *
 * H2 commands help:
 * https://www.h2database.com/html/commands.html
 */

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // load JDBC driver class
        Class.forName("org.h2.Driver");

        // connection properties:
        // connect to a local database file test.mv.db
        // in a user home directory with 'sa' user credentials
        String connectionUrl = "jdbc:h2:tcp://localhost/~/test";
        String user = "sa";
        String password = "sa";

        // open connection as an auto-closeable resource
        try (Connection connection = DriverManager
                .getConnection(connectionUrl, user, password)) {

            // create and run statement
            String sql = "SELECT * FROM Sign s JOIN Figure f ON s.figure = f.id";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);

                // print result set to stdout
                printResultSet(resultSet);
            }
        }
    }

    private static void printResultSet(ResultSet resultSet) throws SQLException {
        ResultSetMetaData meta = resultSet.getMetaData();
        int numColumns = meta.getColumnCount();
        for (int i = 0; i < numColumns; i++) {
            if (i > 0)
                System.out.print(", ");
            System.out.print(meta.getColumnName(i + 1));
        }
        System.out.println();
        System.out.println("---");
        while (resultSet.next()) {
            for (int i = 0; i < numColumns; i++) {
                if (i > 0)
                    System.out.print(", ");
                System.out.print(resultSet.getString(i + 1));
            }
            System.out.println();
        }
    }
}