package com.example.demo.repository;

import com.example.demo.model.MenuItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuItemRepository extends MongoRepository<MenuItem, String> {
    // You can define additional custom queries here if needed
}
