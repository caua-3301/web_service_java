package com.webservice.toweb.repositories;

import com.webservice.toweb.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatgoryRepository extends JpaRepository<Category, Long> { }
