package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5EcApplication implements CommandLineRunner {

	//para buscar sin primary key   jpql java persiste query lenguaje
	//1.Query (JPQL es un lenguaje orientado de ojeto para consulta a la base de datos )
	//	1.1 Typer Query
	//	1.2 NamedQuery //centralizada garantizando la reutilizacion
	
	//2.NativE Query(sql puro) sacrifica el manejo orientado a objetos , mucho rendimiento sql nativo
	
	//3.Criteria API Query /// esta destinado para consultas sql dinamicos ya que el sql se construye utilizando metodos
	
	
	@Autowired
	private ILibroService iLibroService;
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
	@Autowired
	private IAlumnoService alumnoService;

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
		
		/*Libro2 libro = new Libro2();
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
		autorLibro1.setFecha(LocalDateTime.now());

		
		AutorLibro autorLibro2 = new AutorLibro();
		autorLibro2.setLibro2(libro);
		autorLibro2.setAutor2(autor2);
		autorLibro2.setFecha(LocalDateTime.now());
		
		
		List<AutorLibro> lista = new ArrayList<AutorLibro>();
		lista.add(autorLibro1);
		lista.add(autorLibro2);
		
		//libro.setAutoresLibros(lista);
		
		this.iLibroService.guardar(libro);
		Libro libroFinal = this.iLibroService.buscarPorNombre("Java");
		System.out.println(libroFinal);*/
		
		/*List<Libro> list = this.iLibroService.buscarPorFecha(LocalDateTime.of(2023, 1, 1, 7, 15));
		for(Libro libro : list) {
			System.out.println(libro);
		}
		
		System.out.println("TypedQuery");
		
		Libro li1 = this.iLibroService.buscarPorTitulo("java");
		System.out.println(li1);
		
		List<Libro> lista2 = this.iLibroService.buscarPorFechaPubli(LocalDateTime.of(2023, 1, 1, 7, 15));
		for(Libro libro : lista2) {
			System.out.println(libro);
		}
		
		System.out.println("NamedQuery");
		Libro li2 = this.iLibroService.buscarPorTituloNamed("programacion2");
		System.out.println(li2);
		
		System.out.println("named query");
		List <Libro>lista3 = this.iLibroService.buscarPorFechaPubliNamed(LocalDateTime.of(2023, 1, 1, 7, 15));
		
		
		for(Libro libro : lista3) {
			System.out.println(lista3);*/
	
		Empleado empleado = this.ciudadanoService.buscarPorCedula("0401213053");
		System.out.println(empleado);
		
		Ciudadano ciudadano =this.ciudadanoService.buscarPorCedulaCiu("0401213053");
		System.out.println(ciudadano);
		
		Empleado empl = this.ciudadanoService.buscarPorNombre("carlos");
		System.out.println(empl);
		
		System.out.println("///////////////////////////////////");
		System.out.println("///////////////////////////////////");

		List<Alumno> lista = this.alumnoService.buscarPorNombre("santiago");
		for (Alumno alumno : lista) {
			System.out.println("///////////////////////////////////");
			System.out.println(alumno);
		}
		
		//Ciudadano empl2 = this.ciudadanoService.buscarPorApellidoCiu("enriquez");
		//System.out.println(empl2);
		
		////////////////////////SQL DINAMICO -- CRITERIA API QUERY///////////////
		//Ciudadano ciu = this.ciudadanoService.buscarPorApellido("enriquez");
		//System.out.println(ciu);
		
		//Ciudadano ciu1 = this.ciudadanoService.buscarPorCriterial("erick","enriquez","1701213053");
		//System.out.println(ciu1);
		
		//System.out.println("Criteria API Query AND OR");
		//Ciudadano ciu4 = this.ciudadanoService.buscarPorCriterialAndOr("erick","enriquez","1701213053");
		//System.out.println(ciu1);
		

	}
	
		
}

