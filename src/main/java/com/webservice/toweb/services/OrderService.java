package com.webservice.toweb.services;

import com.webservice.toweb.entities.Order;
import com.webservice.toweb.entities.User;
import com.webservice.toweb.repositories.Orderrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private Orderrepository orderrepository;

    @Autowired
    public OrderService(Orderrepository orderrepository) {
        this.orderrepository = orderrepository;
    }

    public List<Order> findAll() {
        return orderrepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> order = orderrepository.findById(id);

        return order.get();
    }
}
