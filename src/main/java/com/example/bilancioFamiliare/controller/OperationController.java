package com.example.bilancioFamiliare.controller;

import com.example.bilancioFamiliare.model.Dato;
import com.example.bilancioFamiliare.service.DatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    private DatoService datoService;

    private Dato dato;

    @GetMapping
    public String getPage(Model model, @RequestParam(name = "id", required = false) Integer id) {

        List<Dato> dati = datoService.getDati();
        dato = id == null ? new Dato() : datoService.getDatiById(id);
        model.addAttribute("dati", dati);
        model.addAttribute("dato", dato);
        return "operation";
    }

    @PostMapping
    public String getPost(@RequestParam("data")LocalDate data,
                          @RequestParam("descrizione") String descrizione,
                          @RequestParam("importoEntrata") String importoEntrata,
                          @RequestParam("importoUscita") String importoUscita) {

        datoService.registraDato(dato, data, descrizione, importoEntrata, importoUscita);
        return "redirect:/operation";
    }
}
