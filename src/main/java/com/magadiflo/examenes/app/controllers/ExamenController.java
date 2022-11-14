package com.magadiflo.examenes.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magadiflo.commons.controllers.CommonController;
import com.magadiflo.examenes.app.models.entity.Examen;
import com.magadiflo.examenes.app.services.IExamenService;

@RestController
public class ExamenController extends CommonController<Examen, IExamenService> {

	public ExamenController(IExamenService service) {
		super(service);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id) {
		return null;
	}

}
