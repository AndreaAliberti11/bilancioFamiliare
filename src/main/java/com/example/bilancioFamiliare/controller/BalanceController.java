package com.example.bilancioFamiliare.controller;

import com.example.bilancioFamiliare.model.Dato;
import com.example.bilancioFamiliare.service.DatoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class BalanceController {

    @Autowired
    private DatoService datoService;

    @GetMapping
    public String getPage(Model model, HttpSession session) {

        List<Dato> dati = datoService.getDati();
        double saldoTotale = datoService.getTotaleSaldo(dati);
        model.addAttribute("dati", dati);
        model.addAttribute("saldoTotale", saldoTotale);
        return "balance";
    }

    @GetMapping("/elimina")
    public String eliminaDato(@RequestParam("id") int id) {

        datoService.cancellaDato(id);
        return "redirect:/";
    }

}