package com.magadiflo.examenes.app.services;

import java.util.List;

import com.magadiflo.commons.examenes.models.entity.Asignatura;
import com.magadiflo.commons.examenes.models.entity.Examen;
import com.magadiflo.commons.services.ICommonService;

public interface IExamenService extends ICommonService<Examen> {

	List<Examen> findByNombre(String termino);

	Iterable<Asignatura> findAllAsignaturas();

}
