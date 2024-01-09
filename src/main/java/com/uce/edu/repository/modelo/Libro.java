package com.uce.edu.repository.modelo;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="libro")
public class Libro {

	@Id
	@Column(name="libr_id")
	@SequenceGenerator(name = "seq_libro", sequenceName = "seq_libro", allocationSize=1)  //crear la secuencia
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_libro")
	private Integer id;
	
	@Column(name="libr_titulo")
	private String titulo;
	
	@Column(name="libr_fecha_publicacion")
	private LocalDateTime FechaPublicacion;

	@ManyToMany(mappedBy="libros", cascade = CascadeType.ALL) //a la final si en autor hacemos esto da igual xq ambas son padres
	private Set<Autor> autores;

	//steer and getters 
	
	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getFechaPublicacion() {
		return FechaPublicacion;
	}

	public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
		FechaPublicacion = fechaPublicacion;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", FechaPublicacion=" + FechaPublicacion + ", autores="
				+ "]";
	}
	
	
	
}
