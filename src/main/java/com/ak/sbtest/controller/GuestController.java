package com.ak.sbtest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak.sbtest.data.entity.Guest;
import com.ak.sbtest.data.repository.GuestRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class GuestController {
    
    private final GuestRepository guestRepository;
    
    @RequestMapping(path = "/guests")
    public Iterable<Guest> getGuests() {
        return guestRepository.findAll();
    }
}
