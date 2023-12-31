package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IAlumnoRepository;
import com.uce.edu.repository.IEmpleadoRepository;
import com.uce.edu.repository.modelo.Empleado;

@Service
public class EmpleadoService implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepository iEmpleadoRepository;

	@Override
	public void registrar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.iEmpleadoRepository.insertar(empleado);
	}

	@Override
	public Empleado buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iEmpleadoRepository.seleccionar(id);

	}

	@Override
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.iEmpleadoRepository.actualizar(empleado);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iEmpleadoRepository.eliminar(id);
	}
	
}
