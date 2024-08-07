package com.webservice.toweb.repositories;

import com.webservice.toweb.entities.OrderItem;
import com.webservice.toweb.entities.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRespository extends JpaRepository<OrderItem, OrderItemPk> {}
