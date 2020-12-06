////////////////////////////////////////////////////////////////////
// [ANTONIO] [OSELE] [1186951]
////////////////////////////////////////////////////////////////////


package it.unipd.tos.model;

import java.time.LocalDate;

public class User {

    private String id;
    private String nome;
    private String cognome;
    private LocalDate nascita;

    public User(String id, String nome, String cognome, LocalDate nascita) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.nascita = nascita;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getNascita() {
        return nascita;
    }

}
