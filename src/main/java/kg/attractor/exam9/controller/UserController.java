package kg.attractor.exam9.controller;


import jakarta.validation.Valid;
import kg.attractor.exam9.dto.FlightDto;
import kg.attractor.exam9.dto.UserDto;
import kg.attractor.exam9.service.FlightService;
import kg.attractor.exam9.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

@Controller
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final FlightService flightService;


    @GetMapping("profile")
    public String getProfile(@RequestParam(defaultValue = "0") int page, Model model , Authentication auth){
        int pageSize = 5;
        UserDto user = userService.getUserByEmail(auth.getName());
        Page<FlightDto> flights = flightService.findByUserRegistered(user.getEmail(), page, pageSize );
        model.addAttribute("user", user);
        model.addAttribute("flights", flights.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("hasNext", flights.hasNext());
        model.addAttribute("hasPrevious", flights.hasPrevious());
        model.addAttribute("totalPages", flights.getTotalPages());
        return "user/profile";

    }



}
