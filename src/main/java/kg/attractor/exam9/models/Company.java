package kg.attractor.exam9.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name = "companies")
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Boolean enabled;
    private String avatar;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<Flight> flightList;
}
