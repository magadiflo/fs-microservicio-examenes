package com.magadiflo.examenes.app.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.magadiflo.examenes.app.models.entity.Examen;

public interface IExamenRepository extends CrudRepository<Examen, Long> {

}
