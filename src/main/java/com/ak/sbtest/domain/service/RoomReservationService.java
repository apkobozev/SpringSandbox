package com.ak.sbtest.domain.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ak.sbtest.data.entity.Guest;
import com.ak.sbtest.data.entity.Reservation;
import com.ak.sbtest.data.entity.Room;
import com.ak.sbtest.data.repository.GuestRepository;
import com.ak.sbtest.data.repository.ReservationRepository;
import com.ak.sbtest.data.repository.RoomRepository;
import com.ak.sbtest.domain.RoomReservation;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoomReservationService {
    
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public List<RoomReservation> getRoomReservationForDate(Date date) {
        Iterable<Reservation> reservations = reservationRepository
                .findReservationByReservationDate(new java.sql.Date(date.getTime()));
        List<RoomReservation> result = new ArrayList<>();
        reservations.forEach(reservation -> {
            Room room = roomRepository.findById(reservation.getRoomId()).orElse(new Room());
            Guest guest = guestRepository.findById(reservation.getGuestId()).orElse(new Guest());
            result.add(RoomReservation.builder()
                    .roomId(room.getRoomId())
                    .roomName(room.getRoomName())
                    .roomNumber(room.getRoomNumber())
                    .firstName(guest.getFirstName())
                    .lastName(guest.getLastName())
                    .guestId(guest.getGuestId())
                    .date(date)
                    .build());
        });
        return result;
    }
    
}
