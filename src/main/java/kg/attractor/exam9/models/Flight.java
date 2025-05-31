package kg.attractor.exam9.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Table(name = "flights")
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_time_dep")
    private LocalDateTime dateTimeDeparture;
    @Column(name = "date_time_arrive")
    private LocalDateTime dateTimeArrival;
    @Column(name = "city_dep")
    private String cityDeparture;
    @Column(name = "city_arrive")
    private String cityArrival;
    @Column(name = "uniq_number")
    private String uniqNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flight")
    private List<Ticket> tickets;
}
