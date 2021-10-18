package com.ak.sbtest.controller.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ak.sbtest.domain.RoomReservation;
import com.ak.sbtest.domain.service.RoomReservationService;
import com.ak.sbtest.utils.DateUtils;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/reservations")
@AllArgsConstructor
public class ReservationWebController {

    private final RoomReservationService roomReservationService;

    @GetMapping
    public List<RoomReservation> getRoomReservations(@RequestParam(name = "date", required = false) String dateString) {
        return roomReservationService.getRoomReservationForDate(DateUtils.createDateFromString(dateString));
    }

}
