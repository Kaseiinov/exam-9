package kg.attractor.exam9.dto;

import jakarta.persistence.*;
import kg.attractor.exam9.models.Company;
import kg.attractor.exam9.models.Ticket;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {
    private Long id;
    private String cityDeparture;
    private String cityArrival;
    private String uniqNumber;
    private Long companyId;

}
