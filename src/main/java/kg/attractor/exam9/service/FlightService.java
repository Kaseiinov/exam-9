package kg.attractor.exam9.service;

import kg.attractor.exam9.dto.FlightDto;
import kg.attractor.exam9.exceptions.InvalidUserException;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public interface FlightService {
    Page<FlightDto> findByUserRegistered(String email, int page, int pagSize);

    void buyTicket(String email, Long flightId, Long ticketId) throws InvalidUserException;

    Page<FlightDto> findAll(int page, int pagSize);

    Page<FlightDto> findFillteredFlights(int page, int pageSize, String departure, String destination, LocalDate date);
}
