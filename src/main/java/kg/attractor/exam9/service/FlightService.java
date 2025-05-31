package kg.attractor.exam9.service;

import kg.attractor.exam9.dto.FlightDto;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public interface FlightService {
    Page<FlightDto> findAll(int page, int pagSize);

    Page<FlightDto> findFillteredFlights(int page, int pageSize, String departure, String destination, LocalDate date);
}
