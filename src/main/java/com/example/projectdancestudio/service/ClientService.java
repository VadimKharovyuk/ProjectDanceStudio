package com.example.projectdancestudio.service;

import com.example.projectdancestudio.model.Client;
import com.example.projectdancestudio.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;


    public Client save(Client client){
       return clientRepository.save(client);
    }

    public List<Client> FindAddClient(){
        return clientRepository.findAll();
    }

    public List<Client> findClientsByName(String name) {
        return clientRepository.findByNameContainingIgnoreCase(name); // Используйте метод репозитория для поиска клиентов по имени
    }
}
