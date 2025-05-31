package kg.attractor.exam9.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import kg.attractor.exam9.dto.UserDto;
import kg.attractor.exam9.exceptions.SuchEmailAlreadyExistsException;
import kg.attractor.exam9.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("register")
    public String register(Model model){
        model.addAttribute("userDto", new UserDto());
        return "auth/register";
    }

    @PostMapping("register")
    public String register(@Valid UserDto userDto, BindingResult bindingResult, Model model) throws SuchEmailAlreadyExistsException, RoleNotFoundException {
        if(!bindingResult.hasErrors()){
            userService.register(userDto);
            return "redirect:/auth/login";
        }
        model.addAttribute("userDto", userDto);
        return "auth/register";
    }

    @GetMapping("login")
    public String login(Model model){
        return "auth/login";
    }



}
