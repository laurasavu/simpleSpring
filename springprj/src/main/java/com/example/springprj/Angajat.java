package com.example.springprj;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="angajati")
@Getter
@Setter
@ToString

public class Angajat {
    @Id
    @SequenceGenerator(name="employeesequence",allocationSize = 1)
    @GeneratedValue(generator = "employeesequence",strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "Nume angajat")
    private String firstname;
    private int age;
    private String role;
    @Transient
    private Adress adress;
    public long getId() {
        return id;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }


    public Angajat() {
    }

    public Angajat(String firstName, int age, String role, Adress adress) {
        this.firstname = firstName;
        this.age = age;
        this.role = role;
        this.adress = adress;
    }



    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
