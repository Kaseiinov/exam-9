package kg.attractor.exam9.service.impl;

import kg.attractor.exam9.models.Ticket;
import kg.attractor.exam9.repository.TicketRepository;
import kg.attractor.exam9.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Override
    public Ticket findTicketById(Long id){
        return ticketRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Ticket ticket){
        ticketRepository.save(ticket);
    }
}
