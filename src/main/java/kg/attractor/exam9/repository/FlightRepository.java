package kg.attractor.exam9.repository;

import kg.attractor.exam9.models.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {


    Page<Flight> findAllByCityDepartureContainingAndCityArrivalContainingAndDateTimeDepartureBetween(String cityDeparture, String cityArrival, LocalDateTime dateTimeDepartureAfter, LocalDateTime dateTimeDepartureBefore, Pageable pageable);
}
