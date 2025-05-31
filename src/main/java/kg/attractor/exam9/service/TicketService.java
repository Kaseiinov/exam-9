package kg.attractor.exam9.service;

import kg.attractor.exam9.models.Ticket;

public interface TicketService {
    Ticket findTicketById(Long id);

    void save(Ticket ticket);
}
