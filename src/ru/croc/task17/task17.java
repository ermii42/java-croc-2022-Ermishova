package ru.croc.task17;

import java.io.*;
import java.sql.*;


public class task17 {
    private static final String connectionUrl = "jdbc:h2:tcp://localhost/~/test";
    ;
    private static final String CREATE_TABLE_QUERY = "DROP TABLE IF EXISTS store; CREATE TABLE store ("
            + "id INTEGER PRIMARY KEY AUTO_INCREMENT, "
            + "orderNumber INTEGER, "
            + "login TEXT, "
            + "vendorCode TEXT, "
            + "productName TEXT, "
            + "price INTEGER)";
    private static final String INSERT_PERSON_QUERY = "INSERT INTO store (id, orderNumber, login, vendorCode, productName, price) VALUES (?, ?, ?, ?, ?, ?)";

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        int k = 0;
        Class.forName("org.h2.Driver");
        String user = "sa";
        String password = "sa";

        // open connection as an auto-closeable resource
        try (Connection connection = DriverManager.getConnection(connectionUrl, user, password)) {

            // create and run statement
            try (Statement stmt = connection.createStatement()) {
                stmt.execute(CREATE_TABLE_QUERY);
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
                 PreparedStatement stmt = connection.prepareStatement(INSERT_PERSON_QUERY)) {
                String[] record;
                String line;
                while ((line = reader.readLine()) != null) {
                    record = line.split(",");
                    k++;
                    stmt.setInt(1, k);
                    stmt.setInt(2, Integer.parseInt(record[0]));
                    stmt.setString(3, record[1]);
                    stmt.setString(4, record[2]);
                    stmt.setString(5, record[3]);
                    stmt.setInt(6, Integer.parseInt(record[4]));
                    stmt.executeUpdate();
                }
            } catch (IOException exc) {
                exc.printStackTrace();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM store");
            printResultSet(resultSet);
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
