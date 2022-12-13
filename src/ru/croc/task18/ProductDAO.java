package ru.croc.task18;

import org.h2.jdbc.JdbcSQLNonTransientException;

import java.sql.*;

public class ProductDAO {
    private final Connection connection;
    private static final String INSERT_PERSON_QUERY_PRODUCT = "INSERT INTO product (vendorCode, productName, price) VALUES (?, ?, ?)";

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public Product findProduct(String productCode) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(String.format("SELECT * FROM product p WHERE p.vendorCode = '%s'", productCode));
            return new Product(resultSet);
        } catch (JdbcSQLNonTransientException e) {
            return null;
        }
    }

    public Product createProduct(Product product) throws NotUniqueException, SQLException {
        Product p = findProduct(product.getVendorCode());
        if (p != null) {
            throw new NotUniqueException(product.getVendorCode());
        }
        try (PreparedStatement stmt1 = connection.prepareStatement(INSERT_PERSON_QUERY_PRODUCT)) {
            stmt1.setString(1, product.getVendorCode());
            stmt1.setString(2, product.getProductName());
            stmt1.setInt(3, product.getPrice());
            stmt1.executeUpdate();
        }
        return product;
    }

    public Product updateProduct(Product product) throws SQLException {
        try (PreparedStatement stmt1 = connection.prepareStatement("UPDATE product SET productName = ?, price = ? WHERE vendorCode = ?")) {
            stmt1.setString(1, product.getProductName());
            stmt1.setInt(2, product.getPrice());
            stmt1.setString(3, product.getVendorCode());
            stmt1.executeUpdate();
        }
        return product;
    }

    public void deleteProduct(String productCode) throws SQLException {
        try (PreparedStatement stmt1 = connection.prepareStatement("DELETE FROM product WHERE vendorCode = ?")) {
            stmt1.setString(1, productCode);
            stmt1.executeUpdate();
        }
        try (PreparedStatement stmt1 = connection.prepareStatement("DELETE FROM order1 WHERE vendorCode = ?")) {
            stmt1.setString(1, productCode);
            stmt1.executeUpdate();
        }
    }
}
