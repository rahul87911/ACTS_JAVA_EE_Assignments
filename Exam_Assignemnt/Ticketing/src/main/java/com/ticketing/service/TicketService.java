package com.ticketing.service;

import java.util.List;

import com.ticketing.dto.TicketUpdateRequest;
import com.ticketing.eintities.Ticket;

public interface TicketService {

	Ticket createTicket(Ticket ticket);

	Ticket updateTicket(Long id, TicketUpdateRequest updateRequest);

	List<Ticket> getAllOpenTickets();

	Ticket getTicketById(Long id);

}