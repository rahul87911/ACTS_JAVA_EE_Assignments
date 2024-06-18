package com.exam.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.demo.exceptions.ConflictException;
import com.exam.demo.pojos.Reservation;
import com.exam.demo.pojos.Room;
import com.exam.demo.repo.ReservationRepo;
import com.exam.demo.repo.RoomRepo;


@Service
public class ReservationServiceImpl implements ReservationService {

	 @Autowired
	 private RoomRepo roomRepository;
	 @Autowired
	 private ReservationRepo reservationRepository;
	
	 
	@Override
	public Reservation createReservation(Reservation reservation) {
		 Room room = roomRepository.findById(reservation.getRoom().getId()).orElseThrow();
	        if (!room.isAvailability()) {
	            throw new ConflictException("Room is not available");
	        }
	        room.setAvailability(false);
	        return reservationRepository.save(reservation);
	}

	@Override
	public List<Room> getAvailableRooms() {
		return roomRepository.findByAvailability(true);
	}

	@Override
	public String cancelReservation(Long reservationId) {
		if(reservationRepository.existsById(reservationId))
		{
		    Reservation reservation = reservationRepository.findById(reservationId).orElseThrow();
		    Room room = reservation.getRoom();
		    
		    room.setAvailability(true);
		    roomRepository.save(room);
		    
		    reservationRepository.deleteById(reservationId);
		    return "cancelled";
		}else
			return "failed to cancel";
	}

	}


