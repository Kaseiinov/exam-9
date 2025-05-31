package kg.attractor.exam9.dto;

import jakarta.persistence.*;
import kg.attractor.exam9.models.Flight;
import kg.attractor.exam9.models.User;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {
    private Long id;
    private Double price;
    private String status;
    private String type;
    private String place;
    private Long userId;
    private Long flightId;

}
