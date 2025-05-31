package kg.attractor.exam9.service.impl;

import kg.attractor.exam9.dto.FlightDto;
import kg.attractor.exam9.dto.TicketDto;
import kg.attractor.exam9.models.Flight;
import kg.attractor.exam9.models.Ticket;
import kg.attractor.exam9.repository.FlightRepository;
import kg.attractor.exam9.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    @Override
    public Page<FlightDto> findAll(int page, int pagSize){
        Pageable pageable = PageRequest.of(page, pagSize);
        Page<Flight> flights = flightRepository.findAll(pageable);
        return flightsPageBuilder(flights, pageable);
    }

    @Override
    public Page<FlightDto> findFillteredFlights(int page, int pageSize, String departure, String destination, LocalDate date){
        Pageable pageable = PageRequest.of(page, pageSize);
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);
        Page<Flight> flights;
        if(departure == null || departure.isEmpty() && destination == null || destination.isEmpty()){
            flights = flightRepository.findAll(pageable);
        }else{
            flights = flightRepository.findAllByCityDepartureContainingAndCityArrivalContainingAndDateTimeDepartureBetween(departure, destination, startOfDay, endOfDay, pageable);

        }
        return flightsPageBuilder(flights, pageable);
    }

    public Page<FlightDto> flightsPageBuilder(Page<Flight> flights, Pageable pageable) {
        List<FlightDto> flightDtoList = flights.stream()
                .map(e -> FlightDto.builder()
                        .id(e.getId())
                        .dateTimeDeparture(e.getDateTimeDeparture())
                        .dateTimeArrival(e.getDateTimeArrival())
                        .cityDeparture(e.getCityDeparture())
                        .cityArrival(e.getCityArrival())
                        .uniqNumber(e.getUniqNumber())
                        .companyId(e.getCompany().getId())
                        .economTickets(e.getTickets()
                                .stream()
                                .filter(t -> "ECONOMY".equals(t.getType()) && Boolean.TRUE.equals(t.getStatus()))
                                .map(t -> TicketDto.builder()
                                        .id(t.getId())
                                        .price(t.getPrice())
                                        .status(t.getStatus() != null ? t.getStatus().toString() : "false")
                                        .type(t.getType())
                                        .place(t.getPlace() != null ? t.getPlace().toString() : null)
                                        .userId(t.getUser() != null ? t.getUser().getId() : null)
                                        .flightId(t.getFlight() != null ? t.getFlight().getId() : null)
                                        .build()
                                )
                                .toList()
                        )

                        .bissnessTickets(
                                e.getTickets()
                                        .stream()
                                        .filter(t -> "BUSINESS".equals(t.getType()) && Boolean.TRUE.equals(t.getStatus()))
                                        .map(t -> TicketDto.builder()
                                                .id(t.getId())
                                                .price(t.getPrice())
                                                .status(t.getStatus() != null ? t.getStatus().toString() : "false")
                                                .type(t.getType())
                                                .place(t.getPlace() != null ? t.getPlace().toString() : null)
                                                .userId(t.getUser() != null ? t.getUser().getId() : null)
                                                .flightId(t.getFlight() != null ? t.getFlight().getId() : null)
                                                .build()
                                        )
                                        .toList()
                        )


                        .bissnessPrice(
                                e.getTickets().stream()
                                        .filter(t -> "BUSINESS".equals(t.getType()))
                                        .findFirst()
                                        .map(Ticket::getPrice)
                                        .orElse(null)
                        )
                        .economyPrice(
                                e.getTickets().stream()
                                        .filter(t -> "ECONOMY".equals(t.getType()))
                                        .findFirst()
                                        .map(Ticket::getPrice)
                                        .orElse(null)

                        )
                        .build())
                .toList();

        return new PageImpl<>(flightDtoList, pageable, flights.getTotalElements());
    }
}
