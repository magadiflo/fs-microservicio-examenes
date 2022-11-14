package com.magadiflo.examenes.app.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.magadiflo.commons.examenes.models.entity.Examen;

public interface IExamenRepository extends CrudRepository<Examen, Long> {

	@Query("SELECT e FROM Examen AS e WHERE e.nombre LIKE %?1%")
	List<Examen> findByNombre(String termino);

}
