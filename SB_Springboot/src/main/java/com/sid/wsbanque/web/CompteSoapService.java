package com.sid.wsbanque.web;

import com.sid.wsbanque.entities.Compte;
import com.sid.wsbanque.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@Component
@WebService(serviceName = "BanqueWS")
public class CompteSoapService {
    @Autowired
    private CompteRepository compteRepository;

    @WebMethod
    public List<Compte> compteList() {

        return compteRepository.findAll();
    }

    @WebMethod
    public Compte getcompte(@WebParam(name = "id") Long id) {

        return compteRepository.findById(id).get();
    }

    @WebMethod
    public float Convert(@WebParam(name = "montant") float balance) {
        float conversionRate = 10.815f;
        float convertedBalance = balance * conversionRate;
        convertedBalance = Math.round(convertedBalance * 100.0f) / 100.0f;
        return convertedBalance;
    }
}
