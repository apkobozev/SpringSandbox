package com.ak.sbtest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak.sbtest.data.entity.Room;
import com.ak.sbtest.data.repository.RoomRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class RoomController {

    private final RoomRepository roomRepository;

    @RequestMapping("/rooms")
    public Iterable<Room> getRooms() {
        return roomRepository.findAll();
    }
}
