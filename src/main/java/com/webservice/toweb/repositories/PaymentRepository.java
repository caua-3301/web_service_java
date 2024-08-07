package com.webservice.toweb.repositories;

import com.webservice.toweb.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {}
