package com.magadiflo.examenes.app.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.magadiflo.commons.examenes.models.entity.Asignatura;
import com.magadiflo.commons.examenes.models.entity.Examen;
import com.magadiflo.commons.services.CommonServiceImpl;
import com.magadiflo.examenes.app.models.repository.IAsignaturaRepository;
import com.magadiflo.examenes.app.models.repository.IExamenRepository;

@Service
public class ExamenService extends CommonServiceImpl<Examen, IExamenRepository> implements IExamenService {

	private IAsignaturaRepository asignaturaRepository;

	public ExamenService(IExamenRepository repository, IAsignaturaRepository asignaturaRepository) {
		super(repository);
		this.asignaturaRepository = asignaturaRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String termino) {
		return this.repository.findByNombre(termino);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Asignatura> findAllAsignaturas() {
		return this.asignaturaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Long> findExamenesIdsConRespuestasByPreguntaIds(Iterable<Long> preguntaIds) {
		return this.repository.findExamenesIdsConRespuestasByPreguntaIds(preguntaIds);
	}

}
