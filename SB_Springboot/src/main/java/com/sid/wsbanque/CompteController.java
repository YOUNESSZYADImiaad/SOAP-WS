package com.sid.wsbanque;

import com.sid.wsbanque.entities.Compte;
import com.sid.wsbanque.web.CompteSoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompteController {
    @Autowired
    private CompteSoapService compteSoapService;

    @GetMapping("/list")
    public List<Compte> list(Model model) {
        List<Compte> comptes = compteSoapService.compteList();
        model.addAttribute("comptes", comptes);
        return comptes;
    }

    @GetMapping("/getone/{id}")
    public Compte view(@PathVariable("id") Long id, Model model) {
        Compte compte = compteSoapService.getcompte(id);
        model.addAttribute("compte", compte);
        return compte;
    }

    @PostMapping("/convert")
    public float convert(@RequestParam("montant") float balance, Model model) {
        float convertedBalance = compteSoapService.Convert(balance);
        model.addAttribute("montant", balance);
        model.addAttribute("result", convertedBalance);
        return convertedBalance;
    }
}
