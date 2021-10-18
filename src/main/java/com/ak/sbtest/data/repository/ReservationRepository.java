package com.ak.sbtest.data.repository;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;

import com.ak.sbtest.data.entity.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Iterable<Reservation> findReservationByReservationDate(Date date);
}
