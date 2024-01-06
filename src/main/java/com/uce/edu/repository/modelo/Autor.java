package com.uce.edu.repository.modelo;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name= "autor")
public class Autor {
	
	@Id
	@Column(name = "auto_id")
	@SequenceGenerator(name = "seq_autor", sequenceName = "seq_autor", allocationSize=1)  //crear la secuencia
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_autor")
	private Integer id;
	
	@Column(name="auto_nombre")
	private String nombre;
	
	@Column(name="auto_nacionalidad")
	private String nacionalidad;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="libro_autor",
	joinColumns=@JoinColumn(name="auli_id_autor"),//tabla secuandari //esta linea y la de abajo es para las claves foraneas para la tabla de rompimiento
	inverseJoinColumns = @JoinColumn(name="auli_id_libro")) //tabla principal //es para especificar la tabla de rompimiento
	private Set<Libro> libros;
	//getters and seters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}


	
	
}
