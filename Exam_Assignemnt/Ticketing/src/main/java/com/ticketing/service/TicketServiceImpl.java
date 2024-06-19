package com.ticketing.service;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketing.dto.TicketUpdateRequest;
import com.ticketing.eintities.Status;
import com.ticketing.eintities.Ticket;
import com.ticketing.exceptions.ResourceNotFoundException;
import com.ticketing.repositories.TicketRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
	public Ticket createTicket(Ticket ticket) {
        ticket.setCreateDateTime(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    @Override
	public Ticket updateTicket(Long id, TicketUpdateRequest updateRequest) {
        Ticket ticket = ticketRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Ticket not found for this id :: " + id));

        if (updateRequest.getStatus() != null) {
            ticket.setStatus(updateRequest.getStatus());
        }
        if (updateRequest.getResolutionDetails() != null) {
            ticket.setResolutionDetails(updateRequest.getResolutionDetails());
        }
        if (updateRequest.getResolutionDateTime() != null) {
            ticket.setResolutionDateTime(updateRequest.getResolutionDateTime());
        }

        return ticketRepository.save(ticket);
    }

    @Override
	public List<Ticket> getAllOpenTickets() {
        return ticketRepository.findByStatus(Status.OPEN);
    }

    @Override
	public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Ticket not found for this id :: " + id));
    }
}
