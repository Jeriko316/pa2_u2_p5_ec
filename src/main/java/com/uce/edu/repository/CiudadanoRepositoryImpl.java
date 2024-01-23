package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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


	@Override
	public Empleado seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Empleado> myQuery = this.entityManager.createQuery("SELECT e FROM Empleado e WHERE e.ciudadano.cedula = :cedula",Empleado.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}


	@Override
	public Ciudadano seleccionarPorCedulaCiu(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_cedula = :cedula", Ciudadano.class);
		myQuery.setParameter("cedula", cedula);
		return (Ciudadano) myQuery.getSingleResult();
	}


	@Override
	public Empleado seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Empleado> myQuery = this.entityManager.createQuery("SELECT e FROM Empleado e WHERE e.ciudadano.nombre = :nombre",Empleado.class);
		myQuery.setParameter("nombre", nombre);
		return myQuery.getSingleResult();
	}


	@Override
	public Ciudadano seleccionarPorApellidoCiu(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM Ciudadano c WHERE c.ciud_apellido = :apellido", Ciudadano.class);
		myQuery.setParameter("apellido", apellido);
		return (Ciudadano) myQuery.getSingleResult();
	}

//////sql dinamicos 
	@Override
	public Ciudadano seleccionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		// Como seria el sql orientado a objetos -> SELECT c FROM Ciudadano c WHERE c.apellido = : variable 
		
		//0. Creamos una instancia de la interfaz CriteriaBuilder apartir de un Entity Manger que interaccion con la base de datos
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		
		//1. Determinamos el tipo de retorno que va a tener mi Consulta
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);
		
		//2. Construir el SQL 
		 //2.1 Determinamos el FROM (Rout)
		  //Nota: No necesariamente el FROM es igual al tipo de retorno 
		  // SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre = : dato
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);  //es como hicieronamos FROM Ciudadano
		
		 //2.2 Contruir las condiciones (WHERE) del SQL 
		 //Nota: En Criteri API Query las condiciones se las conoce como Predicate
		 //c.apellido = : variable
		Predicate condicionApellido = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);
		
		//3. Contruimos el SQL final
		 myCriteriaQuery.select(myFrom).where(condicionApellido);
		 
		 //4. Ejecutamos la Consulta con un TypedQuery
		 TypedQuery <Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		
	    return myTypedQuery.getSingleResult();
	}


	@Override
	public Ciudadano seleccionarPorCriterial(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		//0. Creamos una instancia de la interfaz CriteriaBuilder apartir de un Entity Manger que interaccion con la base de datos
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		
		
		//1. Determinamos el tipo de retorno que va a tener mi Consulta
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);
		
		//2. Construir el SQL 
		 //2.1 Determinamos el FROM (Rout)
		  //Nota: No necesariamente el FROM es igual al tipo de retorno 
		  // SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre = : dato
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);  //es como hicieronamos FROM Ciudadano
		
		 //2.2 Contruir las condiciones (WHERE) del SQL 
		 //Nota: En Criteri API Query las condiciones se las conoce como Predicate
		 //c.apellido = : variable
		//String digitosProvincia = cedula.startsWith("17");
		//System.out.println(digitosProvincia);
		Predicate condicionGenerica = null;
		
		if(cedula.startsWith("17")) {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);

		}else if(cedula.startsWith("05")) {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);

		}else {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("cedula"), cedula);

		}

		//3. Contruimos el SQL final
		 myCriteriaQuery.select(myFrom).where(condicionGenerica);
		 
		 //4. Ejecutamos la Consulta con un TypedQuery
		 TypedQuery <Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		
		return myTypedQuery.getSingleResult();
	}

	
	@Override
	public Ciudadano seleccionarPorCriterialAndOr(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		//0. Creamos una instancia de la interfaz CriteriaBuilder apartir de un Entity Manger que interaccion con la base de datos
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		
		
		//1. Determinamos el tipo de retorno que va a tener mi Consulta
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);
		
		//2. Construir el SQL 
		 //2.1 Determinamos el FROM (Rout)
		  //Nota: No necesariamente el FROM es igual al tipo de retorno 
		  // SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre = : dato
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);  //es como hicieronamos FROM Ciudadano
		
		 //2.2 Contruir las condiciones (WHERE) del SQL 
		 //Nota: En Criteri API Query las condiciones se las conoce como Predicate
		 //c.apellido = : variable
		//String digitosProvincia = cedula.startsWith("17");
		//System.out.println(digitosProvincia);
		Predicate condicionTotal = null;
		
		//c.nombre = :nombre
		Predicate condicionNombre = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
		
		//c.apellido = :apellido
		Predicate condicionApellido = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);
		
		if(cedula.startsWith("17")) {
			//c.nombre = :nombre or c.apellido = :apellido

			condicionTotal = myCriteriaBuilder.or(condicionNombre, condicionApellido);

		}else if(cedula.startsWith("05")) {
			//c.nombre = :nombre and c.apellido =:apellido
			condicionTotal = myCriteriaBuilder.and(condicionNombre, condicionApellido);
		}

		//3. Contruimos el SQL final
		 myCriteriaQuery.select(myFrom).where(condicionTotal);
		 
		 //4. Ejecutamos la Consulta con un TypedQuery
		 TypedQuery <Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		
		return myTypedQuery.getSingleResult();
	}

}
