package com.example.bilancioFamiliare.service;

import com.example.bilancioFamiliare.dao.DatoDao;
import com.example.bilancioFamiliare.model.Dato;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DatoServiceImpl implements DatoService {

    @Autowired
    private DatoDao datoDao;

    @Override
    public List<Dato> getDati() {
        return (List<Dato>) datoDao.findAll();
    }

    @Override
    public Dato getDatiById(int id) {

        Optional<Dato> optionalDato = datoDao.findById(id);

        if(optionalDato.isPresent())
            return optionalDato.get();
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public double getTotaleSaldo(List<Dato> dati) {

        double totaleE = 0;
        double totaleU = 0;

        for(Dato dato : dati) {
            if(dato.getImportoEntrata() > 0)
                totaleE += dato.getImportoEntrata();

            if(dato.getImportoUscita() > 0)
                totaleU += dato.getImportoUscita();
        }
        return totaleE - totaleU;
    }

    @Override
    public void cancellaDato(int id) {

        datoDao.deleteById(id);
    }

    @Override
    public void registraDato(Dato dato, LocalDate data, String descrizione, String importoEntrata, String importoUscita) {

        dato.setData(data);
        dato.setDescrizione(descrizione);
        dato.setImportoEntrata(Double.parseDouble(importoEntrata));
        dato.setImportoUscita(Double.parseDouble(importoUscita));

        datoDao.save(dato);
    }

}