package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IHabitacionRepository;
import com.uce.edu.repository.modelo.Habitacion;

import jakarta.persistence.EntityManager;

@Service
public class HabitacionServiceImpl implements IHabitacionService {

	@Autowired
	private IHabitacionRepository iHabitacionRepository;
	
	@Override
	public Habitacion buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iHabitacionRepository.seleccionarPorNumero(numero);
	}

}
