package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IHotelService;

@SpringBootApplication
public class Pa2U2P5EcApplication implements CommandLineRunner {

	@Autowired
	private ICiudadanoService ciudadanoService;

	@Autowired
	private IEmpleadoService empleadoService;
	

	private IHotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EcApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		//Insertar ciudadano:
		/*Ciudadano ciudadano = new Ciudadano();
		ciudadano.setNombre("Gabriel");
		this.ciudadanoService.registrar(ciudadano);
		
		//Insertar empleado:
				//Empleado empleado = new Empleado();
				//empleado.setCiudadano(ciudadano);

		this.ciudadanoService.buscar(2);
		System.out.println(ciudadano);
		
		
		Empleado empl = new Empleado();
		empl.setSalario(new BigDecimal(10));
		empl.setFechaIngreso(LocalDate.now());*/
		
	
		Hotel hotel = new Hotel();
		hotel.setDireccion("av siempre viva");
		hotel.setNombre("JM HOTEL");
		//hote.setHabitaciones(null);

		Habitacion habi1 = new Habitacion();
		habi1.setClase("MEDIA");
		habi1.setNumero("B2");
		habi1.setHotel(hotel);

		Habitacion habi2 = new Habitacion();
		habi2.setClase("VIP");
		habi2.setNumero("B2");
		habi2.setHotel(hotel);

		
		List<Habitacion> habitaciones = new ArrayList<>();
		habitaciones.add(habi1);
		habitaciones.add(habi2);

		
		hotel.setHabitaciones(habitaciones);
		this.hotelService.guardar(hotel);		

	
		
		
	}

}
