package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Carrera;



public interface CarreraService {
	public List<Carrera> findCarreraAll();
    public Carrera createCarrera(Carrera c);
    public Carrera updateCarrera(Carrera c);
    public void deleteCarrera(Long id);
    public Optional<Carrera> getCarrera(Long id);

}
