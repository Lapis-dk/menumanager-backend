package com.example.demo.controller;

import com.example.demo.model.Table;
import com.example.demo.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    private final TableRepository tableRepository;

    @Autowired
    public TableController(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    // Get all tables
    @GetMapping
    public List<Table> getAllTables() {
        return tableRepository.findAll();
    }

    // Get available tables
    @GetMapping("/available")
    public List<Table> getAvailableTables() {
        return tableRepository.findByOccupied(false);
    }

    // Add a new table
    @PostMapping
    public ResponseEntity<?> addTable(@RequestBody Table table) {
        // Check if table with the same ID already exists
        Optional<Table> existingTable = tableRepository.findById(table.getId());
        if (existingTable.isPresent()) {
            // Table with the same ID already exists, issue a warning
            return ResponseEntity.badRequest().body("Table with ID " + table.getId() + " already exists.");
        } else {
            // save the new table and return the result
            return ResponseEntity.ok(tableRepository.save(table));
        }
    }

    // Update an existing table
    @PutMapping("/{id}")
    public ResponseEntity<Table> updateTable(@PathVariable String id, @RequestBody Table updatedTable) {
        Optional<Table> existingTable = tableRepository.findById(id);
        if (existingTable.isPresent()) {
            Table table = existingTable.get();
            table.setCapacity(updatedTable.getCapacity()); // Update table capacity
            table.setOccupied(updatedTable.isOccupied());
            table.setPhoneNumber(updatedTable.getPhoneNumber());
            table.setOrderedMenuItems(updatedTable.getOrderedMenuItems());

            return ResponseEntity.ok(tableRepository.save(table));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a table by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable String id) {
        if (tableRepository.existsById(id)) {
            tableRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update ordered menu items for a specific table
    @PutMapping("/{id}/order")
    public ResponseEntity<Table> updateOrderedMenuItems(@PathVariable String id, @RequestBody List<String> orderedMenuItems) {
        Optional<Table> existingTable = tableRepository.findById(id);
        if (existingTable.isPresent()) {
            Table table = existingTable.get();
            table.setOrderedMenuItems(orderedMenuItems);
            return ResponseEntity.ok(tableRepository.save(table));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
