package com.example.demo.service;

import com.example.demo.model.Table;
import com.example.demo.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableService {

    private final TableRepository tableRepository;

    @Autowired
    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public List<Table> getAllTables() {
        return tableRepository.findAll();
    }

    public Optional<Table> getTableById(String id) {
        return tableRepository.findById(id);
    }

    public Table saveTable(Table table) {
        return tableRepository.save(table);
    }

    public void deleteTable(String id) {
        tableRepository.deleteById(id);
    }

}
