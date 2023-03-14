package com.example.springprj;

import java.util.List;

public interface IAngajatService {
   List<Angajat> afiseazaAngajat();
   void creeazaAngajat(Angajat angajat);
   void updateAngajat(Long id, Angajat angajat);
   void deleteAngajat(Long id);

}
