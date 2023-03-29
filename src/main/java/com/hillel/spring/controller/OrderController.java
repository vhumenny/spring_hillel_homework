package com.hillel.spring.controller;

import com.hillel.spring.model.Order;
import com.hillel.spring.repository.OrderRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping("/")
    public String getInfo() {
        return "index";
    }

    @RequestMapping("/orderId")
    public String showOrderById(HttpServletRequest request, Model model) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        model.addAttribute("order", orderRepository.getOrderById(id));
        return "orderId";
    }

    @RequestMapping("/allOrders")
    public String showAllOrders(Model model) {
        model.addAttribute("all_orders", orderRepository.getAllOrders());
        return "allOrders";
    }


}
