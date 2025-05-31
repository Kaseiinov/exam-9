package kg.attractor.exam9.controller;

import kg.attractor.exam9.dto.FlightDto;
import kg.attractor.exam9.exceptions.InvalidUserException;
import kg.attractor.exam9.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final FlightService flightService;

    @GetMapping()
    public String index(@RequestParam(defaultValue = "0") int page, Model model)
    {
        int pageSize = 5;

        Page<FlightDto> flights = flightService.findAll(page, pageSize);
        model.addAttribute("flights", flights.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("hasNext", flights.hasNext());
        model.addAttribute("hasPrevious", flights.hasPrevious());
        model.addAttribute("totalPages", flights.getTotalPages());
        return "index";
    }

    @PostMapping("/flights/buy")
    public String buyTicket(Authentication auth, @RequestParam(required = false) String flightId, @RequestParam(required = false) String ticketId) throws InvalidUserException {
        flightService.buyTicket(auth.getName(), Long.parseLong(flightId), Long.parseLong(ticketId));
        return "redirect:/";
    }
}
