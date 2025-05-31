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

    private final UserService userService;

//    @GetMapping("admin")
//    public String register(Model model){
//        model.addAttribute("adminDto", new AdminDto());
//        return "auth/register";
//    }

//    @PostMapping("admin")
//    public String register(@Valid AdminDto adminDto, BindingResult bindingResult, Model model) throws SuchEmailAlreadyExistsException, RoleNotFoundException {
//        if(!bindingResult.hasErrors()){
//            userService.register(adminDto);
//            return "redirect:/auth/login";
//        }
//        model.addAttribute("adminDto", adminDto);
//        return "auth/register";
//    }

}
