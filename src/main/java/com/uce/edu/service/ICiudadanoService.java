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
}
