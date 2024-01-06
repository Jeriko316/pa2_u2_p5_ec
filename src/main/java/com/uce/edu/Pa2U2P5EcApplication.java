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
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5EcApplication implements CommandLineRunner {

	@Autowired
	private ILibroService iLibroService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EcApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
	Libro libro = new Libro();
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
	
	this.iLibroService.guardar(libro);
		
	}

}
