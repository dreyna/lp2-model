package com.example.demo.controller.general;

import static com.example.demo.commons.GlobalConstans.API_CARRERAS;

import java.util.List;
import java.util.Optional;

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

import com.example.demo.entity.Carrera;
import com.example.demo.service.CarreraService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(API_CARRERAS)
public class CarreraController {
	@Autowired
	private CarreraService carreraService;
	@GetMapping
	public ResponseEntity<List<Carrera>> listar() {
		try {
		      List<Carrera> car = carreraService.findCarreraAll();
		      if (car.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(car, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PostMapping
    public ResponseEntity<Carrera> crearCarrera(@Valid @RequestBody Carrera carrera){
        try {
            Carrera _car = carreraService.createCarrera(carrera);
            return new ResponseEntity<Carrera>(_car, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Carrera> getCarreraById(@PathVariable("id") Long id){
		Optional<Carrera> carData = carreraService.getCarrera(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Carrera>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Carrera> deleteCarrerae(@PathVariable("id") Long id){
		try {
			carreraService.deleteCarrera(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCarrera(@PathVariable("id") Long id, @Valid @RequestBody Carrera carrera){
		Optional<Carrera> carData = carreraService.getCarrera(id);
	      if (carData.isPresent()) {
	        Carrera dbcarrera = carData.get();
	        dbcarrera.setNombre(carrera.getNombre());
	        dbcarrera.setEstado(carrera.getEstado());
	        return new ResponseEntity<Carrera>(carreraService.updateCarrera(dbcarrera), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
}
}
