package com.example.hotel_management.models;

import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;

@Entity
//@Getter
//@Setter
@Table(name = "rooms")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    @Column(unique = true, nullable = false)
    private int roomNumber;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private int floorNumber;

    @Column(nullable = false)
    private int capacity;

    // Manual getters and setters

    // Setters
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getCapacity() {
        return capacity;
    }
}