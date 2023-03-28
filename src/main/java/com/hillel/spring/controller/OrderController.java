package com.hillel.spring.controller;

import com.hillel.spring.repository.OrderRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpServletRequest;
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
        model.addAttribute("all_order", orderRepository.getOrders().values());
        return "allOrders";
    }


}
