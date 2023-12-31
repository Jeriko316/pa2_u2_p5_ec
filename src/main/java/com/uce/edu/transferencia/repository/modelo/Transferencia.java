package com.uce.edu.transferencia.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class Transferencia {
	
	private String numero;
	private LocalDateTime fecha;
	private BigDecimal monto;
	private CuentaBancaria cuentaOrigen;
	private CuentaBancaria cuentaDestino;
	private Integer contador;
	
	
	public Integer getContador() {
		return contador;
	}
	public void setContador(Integer contador) {
		this.contador = contador;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public CuentaBancaria getCuentaOrigen() {
		return cuentaOrigen;
	}
	public void setCuentaOrigen(CuentaBancaria cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}
	public CuentaBancaria getCuentaDestino() {
		return cuentaDestino;
	}
	public void setCuentaDestino(CuentaBancaria cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "Transferencia [numero=" + numero + ", fecha=" + fecha + ", monto=" + monto + ", cuentaOrigen="
				+ cuentaOrigen + ", cuentaDestino=" + cuentaDestino + "numero de transferencia: "+ "]";
	}
	
	
}
