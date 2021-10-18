package com.ak.sbtest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak.sbtest.data.entity.Reservation;
import com.ak.sbtest.data.repository.ReservationRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ReservationController {

    private final ReservationRepository reservationRepository;
    
    @RequestMapping(path = "/reservations")
    public Iterable<Reservation> getReservations() {
        return reservationRepository.findAll();
    }
}
