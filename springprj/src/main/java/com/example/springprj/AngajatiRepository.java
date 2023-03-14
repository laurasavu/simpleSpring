package com.example.springprj;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//repository este folosit pentru a interactiona cu baza de date
public interface AngajatiRepository extends JpaRepository<Angajat,Long> {

    Optional<Angajat> getAngajatByRole(String role);


}
