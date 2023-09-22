package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Carrera;
import com.example.demo.repository.CarreraRepository;
import com.example.demo.service.CarreraService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CarreraServiceImpl implements CarreraService{
	@Autowired
	private CarreraRepository carreraRepository;
	@Override
	public List<Carrera> findCarreraAll() {
		// TODO Auto-generated method stub
		return carreraRepository.findAll();
	}

	@Override
	public Carrera createCarrera(Carrera c) {
		// TODO Auto-generated method stub
		return carreraRepository.save(c);
	}

	@Override
	public Carrera updateCarrera(Carrera c) {
		// TODO Auto-generated method stub
		return carreraRepository.save(c);
	}

	@Override
	public void deleteCarrera(Long id) {
		// TODO Auto-generated method stub
		carreraRepository.deleteById(id);
	}

	@Override
	public Optional<Carrera> getCarrera(Long id) {
		// TODO Auto-generated method stub
		return carreraRepository.findById(id);
	}

}
