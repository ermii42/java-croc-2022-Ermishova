package ru.croc.task18;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class task18 {
    private static final String connectionUrl = "jdbc:h2:tcp://localhost/~/test";

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        String user = "sa";
        String password = "sa";

        // open connection as an auto-closeable resource
        try (Connection connection = DriverManager.getConnection(connectionUrl, user, password)) {
            testDao(connection);
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

    private static void testDao(Connection connection) throws SQLException {
        DAO dao = new DAO(connection);
        Product product = dao.findProduct("Т2");
        System.out.println(product);
        List<Product> lst = new ArrayList<>();
        lst.add(product);
        lst.add(product);
        Order order = dao.createOrder("Катя", lst);
        System.out.println(order);
        product = dao.updateProduct(new Product(1, "Т2", "камыш", 123));
        System.out.println(product);
        dao.deleteProduct("Т5");
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM order1 o JOIN product p ON o.vendorCode = p.vendorCode");
        printResultSet(resultSet);
    }
}
