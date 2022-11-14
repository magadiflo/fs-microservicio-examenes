package com.magadiflo.examenes.app.services;

import org.springframework.stereotype.Service;

import com.magadiflo.commons.services.CommonServiceImpl;
import com.magadiflo.examenes.app.models.entity.Examen;
import com.magadiflo.examenes.app.models.repository.IExamenRepository;

@Service
public class ExamenService extends CommonServiceImpl<Examen, IExamenRepository> implements IExamenService {

	public ExamenService(IExamenRepository repository) {
		super(repository);
	}
	

}
