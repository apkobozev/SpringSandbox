package com.ak.sbtest.data.entity;

import java.sql.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "RESERVATION")
@Getter
@Setter
public class Reservation {
    
    @Id
    @Column(name = "RESERVATION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reservationId;
    
    @Column(name = "ROOM_ID")
    private long roomId;
    
    @Column(name = "GUEST_ID")
    private long guestId;
    
    @Column(name = "RES_DATE")
    private Date reservationDate;


}
