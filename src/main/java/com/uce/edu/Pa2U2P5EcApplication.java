package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor2;
import com.uce.edu.repository.modelo.AutorLibro;
import com.uce.edu.repository.modelo.Libro2;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5EcApplication implements CommandLineRunner {

	@Autowired
	private ILibroService iLibroService;

	//@Autowired
	//private IAutorService iAutorService;
	
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
		
		Libro2 libro = new Libro2();
		libro.setTitulo("Java2");
		libro.setFechaPublicacion(LocalDateTime.now());

		Autor2 autor1 = new Autor2();
		autor1.setNombre("pepito perez2");
		autor1.setNacionalidad("colombiano2");

		Autor2 autor2 = new Autor2();
		autor2.setNombre("carlos suntaxi2");
		autor2.setNacionalidad("Ecuatoriano2");

		List<Autor2> autores = new ArrayList<Autor2>();
		autores.add(autor1);
		autores.add(autor2);
		
		AutorLibro autorLibro1 = new AutorLibro();
		autorLibro1.setLibro2(libro);
		autorLibro1.setAutor2(autor1);
		
		AutorLibro autorLibro2 = new AutorLibro();
		autorLibro2.setLibro2(libro);
		autorLibro2.setAutor2(autor2);
		
		
		List<AutorLibro> lista = new ArrayList<>();
		lista.add(autorLibro1);
		lista.add(autorLibro2);
		
		libro.setAutoresLibros(lista);
		
		//this.iLibroService.guardar(libro);
		//Libro libro = this.iLibroService.buscarPorNombre("JAVA");
		//System.out.println(libroFinal);
	}
		
	}

