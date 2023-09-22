package com.example.demo.controller.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Estudiante;
import com.example.demo.service.EstudianteService;
import static com.example.demo.commons.GlobalConstans.API_ESTUDIANTES;
import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

@RestController
@RequestMapping(API_ESTUDIANTES)
public class EstudianteController {
	@Autowired
	private EstudianteService service;
	
	@GetMapping
	public ResponseEntity<List<Estudiante>> listar() {
		try {
		      List<Estudiante> prods = service.findEstudianteAll();
		      if (prods.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(prods, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@Valid @RequestBody Estudiante estudiante){
        try {
            Estudiante _prod = service.createEstudiante(estudiante);
            return new ResponseEntity<Estudiante>(_prod, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Estudiante> getEstudianteById(@PathVariable("id") Long id){
		Optional<Estudiante> estData = service.getEstudiante(id);
	    if (estData.isPresent()) {
	      return new ResponseEntity<Estudiante>(estData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Estudiante> deleteEstudiante(@PathVariable("id") Long id){
		try {
			service.deleteEstudiante(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEstudiante(@PathVariable("id") Long id, @Valid @RequestBody Estudiante estudiante){
		Optional<Estudiante> estData = service.getEstudiante(id);
	      if (estData.isPresent()) {
	        Estudiante dbestudiante = estData.get();
	        dbestudiante.setNombres(estudiante.getNombres());
			dbestudiante.setApellidos(estudiante.getApellidos());
			dbestudiante.setDireccion(estudiante.getDireccion());
			dbestudiante.setEdad(estudiante.getEdad());
			dbestudiante.setCiudad(estudiante.getCiudad());
			dbestudiante.setPais(estudiante.getPais());
			dbestudiante.setCarrera(estudiante.getCarrera());
	        return new ResponseEntity<Estudiante>(service.updateEstudiante(dbestudiante), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}