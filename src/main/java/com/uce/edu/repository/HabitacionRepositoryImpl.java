package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Habitacion;

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
public class HabitacionRepositoryImpl implements IHabitacionRepository{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Habitacion seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Habitacion> myCriteriaQuery = myCriteriaBuilder.createQuery(Habitacion.class);
		
		Root<Habitacion> myFrom = myCriteriaQuery.from(Habitacion.class);
		
		Predicate condicionNumero = myCriteriaBuilder.equal(myFrom.get("numero"), numero);
		
		myCriteriaQuery.select(myFrom).where(condicionNumero);
		
		TypedQuery<Habitacion> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

		
		return myTypedQuery.getSingleResult();
	}

}
