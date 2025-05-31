package kg.attractor.exam9.controller;

import jakarta.validation.Valid;
import kg.attractor.exam9.dto.CompanyDto;
import kg.attractor.exam9.service.CompanyService;
import kg.attractor.exam9.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final CompanyService companyService;

    @GetMapping("/admin/createCompany")
    public String getTemplate(Model model){
        model.addAttribute("companyDto", new CompanyDto());
        return "user/create";
    }

    @PostMapping("/admin/createCompany")
    public String createCompany(@Valid CompanyDto companyDto, BindingResult bindingResult, Model model){
        if(!bindingResult.hasErrors()){
            companyService.save(companyDto);

        }
        model.addAttribute("companyDto", companyDto);
        return "redirect:/admin/createCompany";
    }

}
