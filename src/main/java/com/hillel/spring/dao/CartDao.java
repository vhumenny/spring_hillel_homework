package com.hillel.spring.dao;

import com.hillel.spring.model.Cart;
import com.hillel.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDao {
    private final JdbcTemplate jdbcTemplate;
    public static final String DELETE_QUERY = "DELETE FROM carts WHERE id = ?";
    public static final String ADD_CART_QUERY = "INSERT INTO carts (id) VALUES (?)";
    public static final String ADD_PRODUCT_IN_CART_QUERY = "INSERT INTO product_cart (product_id,cart_id) VALUES (?,?)";
    public static final String FIND_BY_ID_QUERY = "SELECT * FROM carts, product_cart " +
                                                  "WHERE carts.id = product_cart.cart_id AND carts.id = ? ";

    private final RowMapper<Product> productRowMapper = (resultSet, rowNum) -> {
        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getBigDecimal("price"));
        return product;
    };

    @Autowired
    public CartDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void delete(Integer id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Integer addCart(Cart cart) {
        jdbcTemplate.update(ADD_CART_QUERY, cart.getId());
        return cart.getId();
    }

    public Product addProductInCart(Product product, Integer cartId) {
        jdbcTemplate.update(ADD_PRODUCT_IN_CART_QUERY, product.getId(), cartId);
        return product;
    }

    public Cart findById(Integer id) {
        Cart cart = new Cart();
        List<Product> products = jdbcTemplate.query(FIND_BY_ID_QUERY, productRowMapper, id);
        cart.setProducts(products);
        return cart;
    }


}
