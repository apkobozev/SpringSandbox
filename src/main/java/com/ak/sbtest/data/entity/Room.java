package com.ak.sbtest.data.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ROOM")
@Getter
@Setter
public class Room {

    @Id
    @Column(name = "ROOM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roomId;
    
    @Column(name = "NAME")
    private String roomName;
    
    @Column(name = "ROOM_NUMBER")
    private String roomNumber;
    
    @Column(name = "BED_INFO")
    private String bedInfo;
    
}
