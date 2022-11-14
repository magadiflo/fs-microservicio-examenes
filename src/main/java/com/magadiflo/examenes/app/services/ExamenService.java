package com.magadiflo.examenes.app.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.magadiflo.commons.examenes.models.entity.Examen;
import com.magadiflo.commons.services.CommonServiceImpl;

import com.magadiflo.examenes.app.models.repository.IExamenRepository;

@Service
public class ExamenService extends CommonServiceImpl<Examen, IExamenRepository> implements IExamenService {

	public ExamenService(IExamenRepository repository) {
		super(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String termino) {
		return this.repository.findByNombre(termino);
	}

}
