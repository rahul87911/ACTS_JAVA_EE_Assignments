package com.exam.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.demo.pojos.Room;

public interface RoomRepo extends JpaRepository<Room, Long> {
	List<Room> findByAvailability(boolean availability);
}
