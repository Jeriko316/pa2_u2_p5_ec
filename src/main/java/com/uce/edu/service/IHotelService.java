package com.uce.edu.service;

import com.uce.edu.repository.modelo.Hotel;

public interface IHotelService {

	public void guardar(Hotel hotel);
	
	public Hotel buscarPorNombre(String nombre);
	
}
