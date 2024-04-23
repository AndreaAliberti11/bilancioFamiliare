package com.example.bilancioFamiliare.dao;
import com.example.bilancioFamiliare.model.Dato;
import org.springframework.data.repository.CrudRepository;

public interface DatoDao extends CrudRepository<Dato, Integer> {
}
