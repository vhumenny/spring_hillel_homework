package com.hillel.spring.controller;

import com.hillel.spring.repository.OrderRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping()
    public String getInfo(Model model) {
        model.addAttribute("id", new Object());
        return "orders";
    }

    @RequestMapping("/{id}")
    public String showOrderById( @PathVariable("id")  Integer id, Model model) {
        model.addAttribute("order", orderRepository.getOrderById(id));
        return "order-by-id";
    }

    @RequestMapping("/allOrders")
    public String showAllOrders(Model model) {
        model.addAttribute("orders", orderRepository.getOrders().values());
        System.out.println(orderRepository.getOrders().values());
        return "all-orders";
    }


}
