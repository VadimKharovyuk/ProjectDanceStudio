package com.example.projectdancestudio.service;

import com.example.projectdancestudio.model.Client;
import com.example.projectdancestudio.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;




    public Client save(Client client){
       return clientRepository.save(client);
    }
}
