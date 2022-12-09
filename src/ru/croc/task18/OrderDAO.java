package ru.croc.task18;

import java.sql.*;
import java.util.List;

public class OrderDAO {
    private final Connection connection;
    private static final String INSERT_PERSON_QUERY_ORDER = "INSERT INTO order1 (orderNumber, login, vendorCode) VALUES (?, ?, ?)";

    public OrderDAO(Connection connection) {
        this.connection = connection;
    }

    public Order createOrder(String userLogin, List<Product> products) throws SQLException {
        int queue;
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT MAX(orderNumber) FROM order1");
        resultSet.next();
        queue = resultSet.getInt(1) + 1;
        PreparedStatement stmt1 = connection.prepareStatement(INSERT_PERSON_QUERY_ORDER);
        for (Product product : products) {
            stmt1.setInt(1, queue);
            stmt1.setString(2, userLogin);
            stmt1.setString(3, product.getVendorCode());
            stmt1.executeUpdate();
        }
        stmt = connection.createStatement();
        resultSet = stmt.executeQuery(String.format("SELECT * FROM order1 o WHERE o.orderNumber = '%s'", queue));
        return new Order(resultSet);
    }
}
