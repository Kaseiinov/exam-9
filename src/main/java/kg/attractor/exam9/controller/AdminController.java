package kg.attractor.exam9.controller;

import jakarta.validation.Valid;
import kg.attractor.exam9.dto.AdminDto;
import kg.attractor.exam9.dto.UserDto;
import kg.attractor.exam9.exceptions.SuchEmailAlreadyExistsException;
import kg.attractor.exam9.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.management.relation.RoleNotFoundException;

@Controller
@RequiredArgsConstructor
public class AdminController {

//    private final UserService userService;
//
//    @GetMapping("/admin/createCompany")
//    public String createCompany(Model model){
//
//    }

}
