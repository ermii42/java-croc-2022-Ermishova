package ru.croc.task17;

import java.io.*;
import java.sql.*;


public class task17 {
    private static final String connectionUrl = "jdbc:h2:tcp://localhost/~/test";
    private static final String CREATE_TABLE_QUERY_ORDER = "DROP TABLE IF EXISTS order1; CREATE TABLE order1 ("
            + "id INTEGER PRIMARY KEY AUTO_INCREMENT, "
            + "orderNumber INTEGER, "
            + "login TEXT, "
            + "vendorCode TEXT) ";
    private static final String CREATE_TABLE_QUERY_PRODUCT = "DROP TABLE IF EXISTS product; CREATE TABLE product ("
            + "id INTEGER PRIMARY KEY AUTO_INCREMENT, "
            + "vendorCode TEXT, "
            + "productName TEXT, "
            + "price INTEGER, "
            + "UNIQUE (vendorCode)) ";
    private static final String INSERT_PERSON_QUERY_ORDER = "INSERT INTO order1 (orderNumber, login, vendorCode) VALUES ( ?, ?, ?)";
    private static final String INSERT_PERSON_QUERY_PRODUCT = "INSERT INTO product ( vendorCode, productName, price) VALUES ( ?, ?, ?)";

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        String user = "sa";
        String password = "sa";

        // open connection as an auto-closeable resource
        try (Connection connection = DriverManager.getConnection(connectionUrl, user, password)) {
            createStatement(connection);
            try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
                 PreparedStatement stmt1 = connection.prepareStatement(INSERT_PERSON_QUERY_ORDER);
                 PreparedStatement stmt2 = connection.prepareStatement(INSERT_PERSON_QUERY_PRODUCT)) {
                String[] record;
                String line;
                while ((line = reader.readLine()) != null) {
                    record = line.split(",");
                    stmt1.setInt(1, Integer.parseInt(record[0]));
                    stmt1.setString(2, record[1]);
                    stmt1.setString(3, record[2]);
                    try {
                        stmt2.setString(1, record[2]);
                        stmt2.setString(2, record[3]);
                        stmt2.setInt(3, Integer.parseInt(record[4]));
                        stmt2.executeUpdate();
                    } catch (org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException ignored) {
                    }

                    stmt1.executeUpdate();
                }
            } catch (IOException | SQLException exc) {
                exc.printStackTrace();
            }
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM order1 o JOIN product p ON o.vendorCode = p.vendorCode");
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

    private static void createStatement(Connection connection) {
        // create and run statement
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(CREATE_TABLE_QUERY_ORDER);
            stmt.execute(CREATE_TABLE_QUERY_PRODUCT);
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
}
