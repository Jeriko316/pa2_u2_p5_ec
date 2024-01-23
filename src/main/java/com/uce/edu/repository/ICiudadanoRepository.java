package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoRepository {

	public Ciudadano seleccionar(Integer id);
	
	public void insertar(Ciudadano ciudadano);
	
	public void actualizar(Ciudadano ciudadano);
	
	public void eliminar(Integer id);
	
	public Empleado seleccionarPorCedula(String cedula);
	
	public Ciudadano seleccionarPorCedulaCiu(String cedula);
	
	public Empleado seleccionarPorNombre(String nombre);
	
	public Ciudadano seleccionarPorApellidoCiu(String apellido);
	
	//sql dinamicos
	public Ciudadano seleccionarPorApellido(String apellido);
	
	//Funcionalidad que cuando sea el ciudadano de Pichincha busque por nombre
	//Funcionalidad cuando sea de cotopaxi lo busque por apellido
	//Funcionalidad cuando no se ni de cotopaxi ni pichincha lo busque por cedula
	public Ciudadano seleccionarPorCriterial(String nombre , String apellido, String cedula);
	
	public Ciudadano seleccionarPorCriterialAndOr(String nombre, String apellido, String cedula);

	//DEBER
	public Ciudadano seleccionarPorNombreCriterial(String nombre);
	
	public Ciudadano seleccionarPorCedulaCriterial(String cedula);
}
