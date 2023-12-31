package com.uce.edu.service;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;

public interface ICiudadanoService {
	
	public Ciudadano buscar(Integer id);

	public void registrar(Ciudadano ciudadano);
	
	public void eliminar(Integer id);
	
	public void actualizar(Ciudadano ciudadano);
}
