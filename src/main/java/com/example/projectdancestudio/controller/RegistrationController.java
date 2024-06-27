package com.example.projectdancestudio.controller;

import com.example.projectdancestudio.model.Client;
import com.example.projectdancestudio.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class RegistrationController {
    private final ClientService clientService;



    @GetMapping("/")
    public String registerForm(){
        return "registerForm";
    }
    @PostMapping("/save")
    public String saveClient(Client client){
      clientService.save(client);
      return "redirect:/";
    }

}
