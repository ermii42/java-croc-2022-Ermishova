package ru.croc.task18;

import java.sql.*;

public class Product {
    private int id;
    private String vendorCode;
    private String productName;
    private int price;

    public Product(int id, String vendorCode, String productName, int price) {
        this.id = id;
        this.vendorCode = vendorCode;
        this.productName = productName;
        this.price = price;
    }

    public Product(ResultSet resultSet) throws SQLException {
        resultSet.next();
        id = resultSet.getInt(1);
        vendorCode = resultSet.getString(2);
        productName = resultSet.getString(3);
        price = resultSet.getInt(4);
    }

    public int getId() {
        return id;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", vendorCode='" + vendorCode + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
