package kg.attractor.exam9.repository;

import kg.attractor.exam9.models.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {


    Page<Flight> findAllByCityDepartureContainingAndCityArrivalContainingAndDateTimeDepartureBetween(String cityDeparture, String cityArrival, LocalDateTime dateTimeDepartureAfter, LocalDateTime dateTimeDepartureBefore, Pageable pageable);


    @Query(value = "SELECT f.* FROM flights f " +
            "JOIN tickets t ON t.flight_id = f.id " +
            "JOIN users u ON u.id = t.user_id " +
            "WHERE u.email = :ticketsUserEmail",
            nativeQuery = true
    )
    Page<Flight> findAllByTickets_User_Email(String ticketsUserEmail, Pageable pageable);
}
