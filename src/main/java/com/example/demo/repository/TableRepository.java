package com.example.demo.repository;

import com.example.demo.model.Table;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TableRepository extends MongoRepository<Table, String> {
    // You can define additional custom queries here if needed
    List<Table> findByOccupied(boolean occupied);


}
