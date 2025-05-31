package kg.attractor.exam9.controller;


import jakarta.validation.Valid;
import kg.attractor.exam9.dto.UserDto;
import kg.attractor.exam9.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

@Controller
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("profile")
    public String getProfile(Model model ,Authentication auth){
        UserDto user = userService.getUserByEmail(auth.getName());
        model.addAttribute("user", user);
        return "user/profile";

    }



}
