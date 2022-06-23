package com.myproyect.demo.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myproyect.demo.app.data.Capacitaciones;

@Repository
public interface ICapacitaciones extends CrudRepository<Capacitaciones, Integer>{

}
