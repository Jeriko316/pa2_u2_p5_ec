package com.uce.edu;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5EcApplication implements CommandLineRunner {

	@Autowired
	private ILibroService libroService;

	@Autowired
	private IAutorService autorService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EcApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
	/*Libro libro = new Libro();
	libro.setTitulo("java");
	libro.setFechaPublicacion(LocalDateTime.now());
	
	Autor autor1 = new Autor();
	autor1.setNacionalidad("ecuatoriano");
	autor1.setNombre("pepito perez");
	
	Autor autor2= new Autor();
	autor2.setNacionalidad("ecuatoriano");
	autor2.setNombre("daniel teran");
	
	Set<Autor> autores = new HashSet<Autor>();
	autores.add(autor1);
	autores.add(autor2);
	
	libro.setAutores(autores);
	
	Set<Libro> libros = new HashSet<>();
	libros.add(libro);
	
	autor1.setLibros(libros);
	autor2.setLibros(libros);
	
	this.iLibroService.guardar(libro);*/
		
		Libro libro = new Libro();
		libro.setTitulo("Java");
		libro.setFechaPublicacion(LocalDateTime.now());

		Autor autor1 = new Autor();
		autor1.setNombre("pepito perez");
		autor1.setNacionalidad("colombiano");

		Autor autor2 = new Autor();
		autor2.setNombre("carlos suntaxi");
		autor2.setNacionalidad("Ecuatoriano");

		Set<Autor> autores = new HashSet<Autor>();
		autores.add(autor1);
		autores.add(autor2);
		libro.setAutores(autores);

		Set<Libro> libros = new HashSet<Libro>();
		libros.add(libro);
		autor1.setLibros(libros);
		autor2.setLibros(libros);

		this.libroService.guardar(libro);

		// Insertar2:
		Libro libro1 = new Libro();
		libro1.setTitulo("mate1");
		libro1.setFechaPublicacion(LocalDateTime.now());

		Autor a1 = new Autor();
		a1.setNombre("rocio cali");
		a1.setNacionalidad("argentina");

		Autor a2 = new Autor();
		autor2.setNombre("carlos moreira");
		autor2.setNacionalidad("peruano");

		Set<Autor> autores1 = new HashSet<Autor>();
		autores1.add(a1);
		autores1.add(a2);
		libro1.setAutores(autores1);

		Set<Libro> libros1 = new HashSet<Libro>();
		libros1.add(libro1);
		a1.setLibros(libros1);
		a2.setLibros(libros1);

		this.libroService.guardar(libro1);

		Libro l1 = this.libroService.buscar(14);
		l1.setTitulo("mates discretas");
		this.libroService.actualizar(l1);
		System.out.println(l1);

		this.libroService.eliminar(18);

		Autor au3 = this.autorService.buscar(9);
		au3.setNacionalidad("uruguaya");
		this.autorService.actualizar(au3);
		System.out.println(au3);
		
		this.autorService.eliminar(20);
		this.libroService.eliminar(22);
	}
		
	}

