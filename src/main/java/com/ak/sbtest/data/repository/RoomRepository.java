package com.ak.sbtest.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ak.sbtest.data.entity.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{

}
