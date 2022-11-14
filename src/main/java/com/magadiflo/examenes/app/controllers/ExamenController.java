package com.magadiflo.examenes.app.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magadiflo.commons.controllers.CommonController;
import com.magadiflo.commons.examenes.models.entity.Examen;
import com.magadiflo.examenes.app.services.IExamenService;

@RestController
public class ExamenController extends CommonController<Examen, IExamenService> {

	public ExamenController(IExamenService service) {
		super(service);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id) {
		Optional<Examen> examenOptional = this.service.findById(id);
		if (examenOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Examen examenBD = examenOptional.get();
		examenBD.setNombre(examen.getNombre());

		// Eliminamos las preguntas que no vienen en el JSON pero que sí están en la BD.
		// Significa que esas preguntas fueron eliminadas por el cliente desde el
		// frontend, por lo tanto, hay que actualizarlas, es decir eliminarlas de la BD
		examenBD.getPreguntas().stream().filter(pregBD -> !examen.getPreguntas().contains(pregBD))
				.forEach(examenBD::removePregunta);

		// Agregar las nuevas preguntas y modificar las existentes, las que no se
		// tocaron se dejan tal cual
		examenBD.setPreguntas(examen.getPreguntas());

		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(examenBD));
	}

	@GetMapping(path = "/filtrar/{termino}")
	public ResponseEntity<?> filtrar(@PathVariable String termino) {
		return ResponseEntity.ok(this.service.findByNombre(termino));
	}

}
