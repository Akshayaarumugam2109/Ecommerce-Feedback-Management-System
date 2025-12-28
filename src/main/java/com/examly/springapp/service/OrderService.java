package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Order;

public interface OrderService {

    Order addOrder(Order order);

    List<Order> getAllOrders();

    Order getOrderById(int id);
}
