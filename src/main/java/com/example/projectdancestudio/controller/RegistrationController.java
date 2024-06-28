package com.example.projectdancestudio.controller;

import com.example.projectdancestudio.model.Client;
import com.example.projectdancestudio.service.ClientService;
import com.example.projectdancestudio.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/register")
public class RegistrationController {
    private final ClientService clientService;
    private final EmailService emailService;



    @GetMapping
    public String registerForm(){
        return "registerForm";
    }


    @PostMapping("/save")
    public String saveClient(Client client) {
        clientService.save(client);
        emailService.sendWelcomeEmail(client);
        return "redirect:/register";
    }

    @GetMapping("/all")
    public String getAllClient(Model model){
        model.addAttribute("clients", clientService.FindAddClient());
        return "allClient";
    }

    @GetMapping("/search")
    public String searchClientsByName(@RequestParam String name, Model model) {
        List<Client> clients = clientService.findClientsByName(name);
        model.addAttribute("clients", clients);
        model.addAttribute("searchKeyword", name); // передаем ключевое слово поиска для отображения на странице
        return "searchClients";
    }


}
