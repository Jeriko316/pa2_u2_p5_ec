package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}


	@Override
	public Ciudadano seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Ciudadano.class, id);
	}


	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Ciudadano ciud = this.seleccionar(id);
		this.entityManager.remove(ciud);
	}


	@Override
	public void actualizar(Ciudadano ciudadano) {
		this.entityManager.merge(ciudadano);
	}

}
