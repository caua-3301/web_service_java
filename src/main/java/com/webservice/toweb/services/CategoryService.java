package com.webservice.toweb.services;

import com.webservice.toweb.entities.Category;
import com.webservice.toweb.repositories.CatgoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CatgoryRepository catgoryRepository;

    @Autowired
    public CategoryService(CatgoryRepository catgoryRepository) {
        this.catgoryRepository = catgoryRepository;
    }

    public List<Category> findAll() {
        return catgoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> category = catgoryRepository.findById(id);

        return category.orElse(null);
    }
}
