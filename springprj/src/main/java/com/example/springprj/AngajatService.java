package com.example.springprj;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AngajatService implements IAngajatService {
    private final AngajatiRepository angajatiRepository;

    public AngajatService(AngajatiRepository angajatiRepository) {
        this.angajatiRepository = angajatiRepository;
    }


    public List<Angajat> afiseazaAngajat() {
        return angajatiRepository.findAll();
    }

    @Override
    public void creeazaAngajat(Angajat angajat) {

        verificareRol(angajat);
        angajatiRepository.save(angajat);
    }

    private void verificareRol(Angajat angajat) {
        Optional<Angajat> angajatOptional = angajatiRepository.getAngajatByRole(angajat.getRole());
        if (angajatOptional.isPresent()) {
            throw new IllegalStateException(String.format("same Role %s we cannot afford salary", angajat.getRole()));
        }
    }

    @Override
    public void updateAngajat(Long id, Angajat angajat) {
        Angajat angajatDeModificat = angajatiRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(String.format("Acest id %s nu exista", id)));
        angajatDeModificat.setFirstname(angajat.getFirstname());
        angajatDeModificat.setAge(angajat.getAge());
        angajatDeModificat.setRole(angajat.getRole());
        angajatiRepository.save(angajatDeModificat);
    }

    @Override
    public void deleteAngajat(Long id) {
        boolean angExista = angajatiRepository.existsById(id);
        if (!angExista) {
            throw new IllegalStateException("nu avem angajat cu acest id");
        }
        angajatiRepository.deleteById(id);
    }


}

