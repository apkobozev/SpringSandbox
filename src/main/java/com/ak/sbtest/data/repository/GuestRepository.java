package com.ak.sbtest.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.ak.sbtest.data.entity.Guest;

public interface GuestRepository extends CrudRepository<Guest, Long> {

}
