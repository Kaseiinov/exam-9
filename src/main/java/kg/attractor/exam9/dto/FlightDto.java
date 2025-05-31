package kg.attractor.exam9.dto;

import jakarta.persistence.*;
import kg.attractor.exam9.models.Company;
import kg.attractor.exam9.models.Ticket;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {
    private Long id;
    private LocalDateTime dateTimeDeparture;
    private LocalDateTime dateTimeArrival;
    private String cityDeparture;
    private String cityArrival;
    private String uniqNumber;
    private Long companyId;
    private Company company;
    private List<TicketDto> bissnessTickets;
    private List<TicketDto> economTickets;
    private Double bissnessPrice;
    private Double economyPrice;

}
