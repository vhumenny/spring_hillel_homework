package com.hillel.spring.dao;

import com.hillel.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    private final JdbcTemplate jdbcTemplate;
    public static final String INSERT_QUERY = "INSERT INTO products(name, price) VALUES (?, ?)";
    public static final String DELETE_QUERY = "DELETE FROM products WHERE id = ?";
    public static final String GET_PRODUCT_BY_ID_QUERY = "SELECT * FROM products WHERE id= ?";
    public static final String GET_ALL_PRODUCTS_QUERY = "SELECT * FROM products";

    private final RowMapper<Product> productRowMapper = (resultSet, rowNum) -> {
        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getBigDecimal("price"));
        return product;
    };

    @Autowired
    public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void delete(Integer id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public void save(Product product) {
        jdbcTemplate.update(INSERT_QUERY, product.getName(), product.getPrice());
    }

    public Product findById(Integer id) {
        return jdbcTemplate.queryForObject(GET_PRODUCT_BY_ID_QUERY, productRowMapper, id);
    }

    public List<Product> findAllProducts() {
        return jdbcTemplate.query(GET_ALL_PRODUCTS_QUERY, productRowMapper);
    }

}
