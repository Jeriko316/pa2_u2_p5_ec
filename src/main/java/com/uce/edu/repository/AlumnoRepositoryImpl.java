package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Alumno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AlumnoRepositoryImpl implements IAlumnoRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Alumno seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Alumno.class, id);
	}

	@Override
	public void insertar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.entityManager.persist(alumno);
	}

	@Override
	public void actualizar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.entityManager.merge(alumno);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Alumno alum = this.seleccionar(id);
		this.entityManager.remove(alum);
	}

	
}
