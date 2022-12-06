package ru.croc.task18;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Integer> id = new ArrayList<>();
    private int orderNumber;
    private String login;
    private final List<String> vendorCode = new ArrayList<>();

    public Order(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            id.add(resultSet.getInt(1));
            orderNumber = resultSet.getInt(2);
            login = resultSet.getString(3);
            vendorCode.add(resultSet.getString(4));
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", login='" + login + '\'' +
                ", vendorCode=" + vendorCode +
                '}';
    }
}
