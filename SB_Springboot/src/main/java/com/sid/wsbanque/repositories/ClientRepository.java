package com.sid.wsbanque.repositories;

import com.sid.wsbanque.entities.Client;
import com.sid.wsbanque.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {
}
