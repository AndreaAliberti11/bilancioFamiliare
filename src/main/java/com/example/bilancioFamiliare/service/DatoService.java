package com.example.bilancioFamiliare.service;

import com.example.bilancioFamiliare.model.Dato;
import jakarta.servlet.http.HttpSession;

import java.time.LocalDate;
import java.util.List;

public interface DatoService {

    List<Dato> getDati();

    Dato getDatiById(int id);

    double getTotaleSaldo(List<Dato> dati);

    void cancellaDato(int id);

    void registraDato(Dato dato, LocalDate data, String descrizione, String importoEntrata, String importoUscita);
}