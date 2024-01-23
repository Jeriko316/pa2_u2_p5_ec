package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICiudadanoRepository;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

@Service
public class CiudadanoService implements ICiudadanoService {

	@Autowired
	private ICiudadanoRepository iCiudadanoRepository;

	@Override
	public void registrar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepository.insertar(ciudadano);
	}

	@Override
	public Ciudadano buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepository.eliminar(id);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepository.actualizar(ciudadano);
	}

	@Override
	public Empleado buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorCedula(cedula);
		
	}

	@Override
	public Ciudadano buscarPorCedulaCiu(String cedula) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorCedulaCiu(cedula);
		 
	}

	@Override
	public Empleado buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorNombre(nombre);
		
	}

	@Override
	public Ciudadano buscarPorApellidoCiu(String apellido) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorCedulaCiu(apellido);
	}

	@Override
	public Ciudadano buscarPorNombreCrtireial(String nombre) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorNombreCriterial(nombre);
	}

	@Override
	public Ciudadano buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		
		
		return this.iCiudadanoRepository.seleccionarPorApellido(apellido);
	}

	@Override
	public Ciudadano buscarPorCriterial(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorCriterial(nombre, apellido, cedula);
	}

	@Override
	public Ciudadano buscarPorCriterialAndOr(String nombre, String apellido, String cedula) {
		 //TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorCriterialAndOr(nombre, apellido, cedula);
	}

	@Override
	public Ciudadano buscarPorCedulaCriterial(String cedula) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorCedulaCriterial(cedula);
	}
	
	
}
