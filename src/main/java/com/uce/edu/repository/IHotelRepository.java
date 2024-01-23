package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Hotel;

public interface IHotelRepository {

	public void insertar(Hotel hotel);
	
	public Hotel seleccionarPorNombre(String nombre);
}
