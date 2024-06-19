package com.ticketing.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ticketing.dto.TicketUpdateRequest;
import com.ticketing.eintities.Ticket;
import com.ticketing.service.TicketService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@Valid @RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.createTicket(ticket);
        return ResponseEntity.status(201).body(createdTicket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id,
                                               @Valid @RequestBody TicketUpdateRequest updateRequest) {
        Ticket updatedTicket = ticketService.updateTicket(id, updateRequest);
        return ResponseEntity.ok(updatedTicket);
    }

    @GetMapping("/open")
    public ResponseEntity<List<Ticket>> getAllOpenTickets() {
        List<Ticket> tickets = ticketService.getAllOpenTickets();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket ticket = ticketService.getTicketById(id);
        return ResponseEntity.ok(ticket);
    }
}

