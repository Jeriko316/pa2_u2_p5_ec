package com.uce.edu.service;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro;

public interface IAutorService {

	public Autor buscar(Integer id);
	
	public void guardar(Autor autor);
	
	public void actualizar(Autor autor);
	
	public void eliminar(Integer id);
	
}
