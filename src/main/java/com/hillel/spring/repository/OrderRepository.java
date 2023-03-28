package com.hillel.spring.repository;

import com.hillel.spring.model.Order;
import com.hillel.spring.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
@Repository
public class OrderRepository {
    Map<Integer, Order> orders;

    public Order getOrderById(Integer id) {
        return orders.get(id);
    }

    public List<Order> getAllOrders() {
        return orders.values().stream().toList();
    }

    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }

    @PostConstruct
    public void init() {
        Product paper = new Product(1, "paper", BigDecimal.valueOf(10));
        Product bread = new Product(2, "bread", BigDecimal.valueOf(20));
        Product cheese = new Product(3, "cheese", BigDecimal.valueOf(30));
        Product water = new Product(4, "water", BigDecimal.valueOf(10));

        List<Product> productList1 = new ArrayList<>();
        List<Product> productList2 = new ArrayList<>();
        productList1.add(paper);
        productList1.add(bread);
        productList2.add(cheese);
        productList2.add(water);

        Order order1 = new Order(1, LocalDate.now(), BigDecimal.valueOf(30), productList1);
        Order order2 = new Order(2, LocalDate.now(), BigDecimal.valueOf(40), productList2);
        addOrder(order1);
        addOrder(order2);
    }
}
