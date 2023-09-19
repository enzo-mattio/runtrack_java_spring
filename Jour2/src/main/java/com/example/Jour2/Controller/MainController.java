package com.example.Jour2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.AttributedString;


@Controller
public class MainController {

    @GetMapping("/view")
    public String afficherPageAccueil() {
        return "view";
    }

    @PostMapping("/traiterFormulaire")
    public String traiterFormulaire(
            @RequestParam("nom") String nom,
            @RequestParam("prenom") String prenom,
            @RequestParam("age") int age,
            Model model) {
        model.addAttribute("messageBienvenue", "");
        if (age < 0 || age > 120) {
            String messageErreur = "L'âge doit être compris entre 0 et 120.";
            model.addAttribute("messageErreur", messageErreur);
        }
        else {
            String messageBienvenue = "Bienvenue, " + prenom + " " + nom + " !";
            model.addAttribute("messageBienvenue", messageBienvenue);
        }


        return "view";
    }
}


