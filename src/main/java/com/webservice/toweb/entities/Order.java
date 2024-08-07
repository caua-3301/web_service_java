package com.webservice.toweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webservice.toweb.enums.OrderSatatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    private Integer orderSatatus;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> orderItemSet = new HashSet<>();

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    private User client;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order() {}

    public Order(Long id, Instant moment, User client, OrderSatatus orderSatatus) {
        this.id = id;
        this.moment = moment;
        this.client = client;
        setOrderSatatus(orderSatatus);
    }

    public Double getTotal() {
        double total = 0;

        for (OrderItem item: orderItemSet) {
            total += item.getSubTotal();
        }

        return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", moment=" + moment +
                ", orderSatatus=" + orderSatatus +
                ", client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public OrderSatatus getOrderSatatus() {
        return OrderSatatus.valueOf(orderSatatus);
    }

    public void setOrderSatatus(OrderSatatus orderSatatus) {
        this.orderSatatus = orderSatatus.getCode();
    }

    public Set<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
