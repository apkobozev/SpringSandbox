package com.ak.sbtest.controller.web;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ak.sbtest.domain.RoomReservation;
import com.ak.sbtest.domain.service.RoomReservationService;
import com.ak.sbtest.utils.DateUtils;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/roomReservations")
@AllArgsConstructor
public class RoomReservationController {
    
    private final RoomReservationService roomReservationService;
    
    @GetMapping
    private String getReservation(@RequestParam(name = "date", required = false) String dateString, Model model) {
        Date date = DateUtils.createDateFromString(dateString);
        List<RoomReservation> roomReservations = roomReservationService.getRoomReservationForDate(date);
        model.addAttribute("roomReservations", roomReservations);
        return "reservations";
    }

}
