package com.exam.demo.repo;

import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import com.exam.demo.pojos.Reservation;
import com.exam.demo.pojos.Room;


public interface ReservationRepo extends JpaRepository<Reservation, Long> {
	Reservation findByRoomAndCheckInDateAndCheckOutDate(Room room, Date checkInDate, Date checkOutDate);
}
