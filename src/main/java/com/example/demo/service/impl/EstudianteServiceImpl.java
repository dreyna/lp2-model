package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Estudiante;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.service.EstudianteService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EstudianteServiceImpl implements EstudianteService{
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Override
	public List<Estudiante> findEstudianteAll() {
		return estudianteRepository.findAll();
	}
	@Override
	public Estudiante createEstudiante(Estudiante estudiante) {
		return estudianteRepository.saveAndFlush(estudiante);
	}
	@Override
	public Estudiante updateEstudiante(Estudiante estudiante) {
		
		return estudianteRepository.save(estudiante);
	}
	@Override
	public void deleteEstudiante(Long id) {
		estudianteRepository.deleteById(id);
	}
	@Override
	public Optional<Estudiante> getEstudiante(Long id) {
		return estudianteRepository.findById(id);
	}
}