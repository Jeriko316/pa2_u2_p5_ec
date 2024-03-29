package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	@Override
	public Hotel seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Hotel> myCriteriaQuery = myCriteriaBuilder.createQuery(Hotel.class);
		
		Root<Hotel> myFrom = myCriteriaQuery.from(Hotel.class);
		
		Predicate condicionNombre = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
		
		myCriteriaQuery.select(myFrom).where(condicionNombre);
		
		TypedQuery<Hotel> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getSingleResult();
	}

	
	
}
