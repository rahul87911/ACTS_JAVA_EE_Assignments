package com.exam.demo.service;

import java.util.List;

import com.exam.demo.pojos.Reservation;
import com.exam.demo.pojos.Room;

public interface ReservationService {

	public Reservation createReservation(Reservation reservation);
	
	public List<Room> getAvailableRooms();
	   
    public String cancelReservation(Long reservationId);   
}
