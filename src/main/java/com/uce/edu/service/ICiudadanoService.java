package com.uce.edu.service;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoService {
	
	public Ciudadano buscar(Integer id);

	public void registrar(Ciudadano ciudadano);
	
	public void eliminar(Integer id);
	
	public void actualizar(Ciudadano ciudadano);
	
	public Empleado buscarPorCedula(String cedula);
	
	public Ciudadano buscarPorCedulaCiu(String cedula);
	
	public Empleado buscarPorNombre(String nombre);
	
	public Ciudadano buscarPorApellidoCiu(String apellido);
	
	////sql dinamico
	
	public Ciudadano buscarPorApellido(String apellido);
	
	public Ciudadano buscarPorCriterial(String nombre , String apellido, String cedula);

	public Ciudadano buscarPorCriterialAndOr(String nombre, String apellido, String cedula);

}
