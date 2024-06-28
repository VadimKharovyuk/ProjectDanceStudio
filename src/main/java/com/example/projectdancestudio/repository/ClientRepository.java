package com.example.projectdancestudio.repository;

import com.example.projectdancestudio.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    List<Client> findByNameContainingIgnoreCase(String name);

}
