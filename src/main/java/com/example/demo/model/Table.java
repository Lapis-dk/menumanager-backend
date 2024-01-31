package com.example.demo.model;
//h
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "tables")
public class Table {
    @Id
    private String id; // Using id as the table number
    private int capacity;
    private boolean occupied;
    private String phoneNumber;
    private List<String> orderedMenuItems;

    // Constructors

    public Table() {
    }

    public Table(String tableName, boolean occupied, String phoneNumber, List<String> orderedMenuItems) {
        this.occupied = occupied;
        this.phoneNumber = phoneNumber;
        this.capacity=capacity;
        this.orderedMenuItems=orderedMenuItems;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public int getCapacity() {
        return capacity;
    }


    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getOrderedMenuItems() {
        return orderedMenuItems;
    }

    public void setOrderedMenuItems(List<String> orderedMenuItems) {
        this.orderedMenuItems = orderedMenuItems;
    }
}
