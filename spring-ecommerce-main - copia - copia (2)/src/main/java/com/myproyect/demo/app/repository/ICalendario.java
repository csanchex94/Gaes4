package com.myproyect.demo.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myproyect.demo.app.data.Calendario;

@Repository
public interface ICalendario extends CrudRepository<Calendario, Integer>{

}
