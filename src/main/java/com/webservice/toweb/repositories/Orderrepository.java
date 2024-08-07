package com.webservice.toweb.repositories;

import com.webservice.toweb.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Orderrepository extends JpaRepository<Order, Long> { }
