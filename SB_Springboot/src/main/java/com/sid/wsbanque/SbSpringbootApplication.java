package com.sid.wsbanque;

import com.sid.wsbanque.entities.Client;
import com.sid.wsbanque.entities.Compte;
import com.sid.wsbanque.repositories.ClientRepository;
import com.sid.wsbanque.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class SbSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbSpringbootApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository, RepositoryRestConfiguration repositoryRestConfiguration, ClientRepository clientRepository) {
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Compte.class);
            Client c1 = clientRepository.save(new Client(null, "YOUNESS", null));
            Client c2 = clientRepository.save(new Client(null, "MOHAMMED", null));

            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), c1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), c2));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), c1));
            compteRepository.findAll().forEach(compte -> {
                System.out.println(compte.getSolde());

            });

        };

    }
}
