package com.uce.edu.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado {

	@Id
	@SequenceGenerator(name = "seq_empleado", sequenceName = "seq_empleado", allocationSize=1)  //crear la secuencia
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empleado")
	@Column(name="empl_id")
	private Integer id;
	
	@Column(name="empl_salario")
	private BigDecimal salario;
	
	@Column(name="empl_fecha_ingreso")
	private LocalDate fechaIngreso;
	
	@OneToOne( cascade = CascadeType.ALL)
	@JoinColumn(name="empl_id_ciudadano")
	private Ciudadano ciudadano;
	
	

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	
	
	
	
}
