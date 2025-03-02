package com.example.hotel_management.controllers;

import com.example.hotel_management.models.Rooms;
import com.example.hotel_management.repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoomsController {

    private final RoomRepository roomRepository;

    public RoomsController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    // POST /rooms/create - Create a new room
    @PostMapping("/rooms/create-room")
    public ResponseEntity<Rooms> createRoom(@RequestBody Rooms room) {
        Rooms savedRoom = roomRepository.save(room);
        return new ResponseEntity<>(savedRoom, HttpStatus.CREATED);
    }

    // GET /rooms/all-rooms - Get all rooms
    @GetMapping("/rooms/all-rooms")
    public ResponseEntity<List<Rooms>> getAllRooms() {
        List<Rooms> rooms = roomRepository.findAll();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    // PUT /rooms/edit - Edit room details
    @PutMapping("/rooms/edit/{id}")
    public ResponseEntity<Rooms> editRoom(@PathVariable Long id, @RequestBody Rooms updatedRoom) {
        Optional<Rooms> existingRoomOptional = roomRepository.findById(id);

        if (existingRoomOptional.isPresent()) {
            Rooms existingRoom = existingRoomOptional.get();

            // Update the room details with the provided data
            existingRoom.setRoomNumber(updatedRoom.getRoomNumber());
            existingRoom.setPrice(updatedRoom.getPrice());
            existingRoom.setStatus(updatedRoom.getStatus());
            existingRoom.setType(updatedRoom.getType());
            existingRoom.setFloorNumber(updatedRoom.getFloorNumber());
            existingRoom.setCapacity(updatedRoom.getCapacity());

            // Save the updated room
            Rooms savedRoom = roomRepository.save(existingRoom);
            return new ResponseEntity<>(savedRoom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Room not found
        }
    }
}
