package com.example.bilancioFamiliare.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "dati")
public class Dato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private LocalDate data;

    @Column
    private String descrizione;

    @Column
    private double importoEntrata;

    @Column
    private double importoUscita;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getImportoEntrata() {
        return importoEntrata;
    }

    public void setImportoEntrata(double importoEntrata) {
        this.importoEntrata = importoEntrata;
    }

    public double getImportoUscita() {
        return importoUscita;
    }

    public void setImportoUscita(double importoUscita) {
        this.importoUscita = importoUscita;
    }

}