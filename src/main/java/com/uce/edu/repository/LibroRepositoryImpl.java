package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LibroRepositoryImpl implements ILibroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro);
	}

	@Override
	public Libro seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Libro.class, id);
	}

	@Override
	public void actualizar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.merge(libro);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(id);
	}

	@Override
	public void insertar(Libro2 libro2) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro2);
	}

	@Override
	public Libro seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		// SQL Select * from libro l WHERE l.libr_titulo= ?
		// JPQL:SELECT l FROM Libro l WHERE l.titulo = : variable
		Query myQuery = this.entityManager.createQuery("SELECT l FROM Libro l  WHERE l.titulo = : variable");
		myQuery.setParameter("variable", nombre);
		return (Libro) myQuery.getSingleResult(); // GET SINGLE RESULTADO SOOLO DA UN SOLO RESULTADO SINO DA ERROR
	}

	@Override
	public List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		// sql: SELECT * FROM libro l Where l.libr_fecha_publicacion >= ?
		// JPQL: SELECT l from libro l Where l.fechaPublicacion >= : fecha
		Query myQuery2 = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.fechaPublicacion >= : fecha");
		myQuery2.setParameter("fecha", fechaPublicacion);
		return (List<Libro>) myQuery2.getResultList();
	}

	@Override
	public Libro seleccionarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery3 = this.entityManager.createQuery("SELECT l FROM Libro l  WHERE l.titulo = : titulo", Libro.class);
		myQuery3.setParameter("titulo", titulo);
		return myQuery3.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFecha(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery4 = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.fechaPublicacion >= : fecha",Libro.class);
		myQuery4.setParameter("fecha", fechaPublicacion);
		return myQuery4.getResultList();
	}

	@Override
	public Libro seleccionarPorTituloNamed(String titulo) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery=this.entityManager.createNamedQuery("Libro.queryBuscarPorTitulo", Libro.class);
		myQuery.setParameter("titulo", titulo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Libro> SeleccionarPorFechaNamed(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery = this.entityManager.createNamedQuery("Libro.queryBuscarPorFecha",Libro.class);
		myQuery.setParameter("fecha", fechaPublicacion);
		return myQuery.getResultList();
	}

}
