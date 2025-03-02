package com.example.hotel_management.repository;

import com.example.hotel_management.models.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Rooms, Long> {
    List<Rooms> findByType(String type);
    List<Rooms> findByStatus(String status);
    List<Rooms> findByPriceBetween(double minPrice, double maxPrice);
    List<Rooms> findByRoomNumber(int roomNumber);
}