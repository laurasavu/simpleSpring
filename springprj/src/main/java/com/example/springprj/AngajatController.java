package com.example.springprj;

import jakarta.persistence.PostUpdate;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController-rest controler  annotation returns the json from the method not HTML or JSP.
@Controller
@RequestMapping(path="/api/v1/angajat")
public class AngajatController {

private final AngajatService angajatService;

    public AngajatController(AngajatService angajatService) {
        this.angajatService = angajatService;
    }

    @GetMapping("/afiseazaAngajat")
    public String getAngajati(Model model){
         List<Angajat>getAngajati =angajatService.afiseazaAngajat();
         model.addAttribute("getAngajati",getAngajati);
        return "afiseazaAngajat";

    }
    @GetMapping("/angajat/new")
    public String createAngajatForm(Model model) {


        Angajat angajat=new Angajat();
        model.addAttribute("angajat", angajat);
        return "create_angajat";

    }
    @PostMapping("/angajati")
    public String postAngajat(@ModelAttribute("angajat") Angajat angajat){
        angajatService.creeazaAngajat(angajat);
        return "redirect:/api/v1/angajat/afiseazaAngajat";

    }
    @PutMapping(path ="{id}")
    public void updateAngajat(@PathVariable Long id, @RequestBody  Angajat angajat){
    angajatService.updateAngajat(id,angajat);
    }
    @DeleteMapping(path ="{id}")
    public void deleteAngajat(@PathVariable Long id){
        angajatService.deleteAngajat(id);
    }


}
