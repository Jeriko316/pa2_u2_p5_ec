package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;

@SpringBootApplication
public class Pa2U2P5EcApplication implements CommandLineRunner {

	@Autowired
	private ICiudadanoService ciudadanoService;

	@Autowired
	private IEmpleadoService empleadoService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EcApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		//Insertar ciudadano:
		Ciudadano ciudadano = new Ciudadano();
		ciudadano.setNombre("Gabriel");
		this.ciudadanoService.registrar(ciudadano);
		
		//Insertar empleado:
				//Empleado empleado = new Empleado();
				//empleado.setCiudadano(ciudadano);

		this.ciudadanoService.buscar(2);
		System.out.println(ciudadano);
		
	}

}
