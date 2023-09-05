package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Estudiante;
public interface EstudianteService {
	
    public List<Estudiante> findEstudianteAll();
    public Estudiante createEstudiante(Estudiante estudiante);
    public Estudiante updateEstudiante(Estudiante estudiante);
    public void deleteEstudiante(Long id);
    public Optional<Estudiante> getEstudiante(Long id);
}