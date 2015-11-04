package com.icarus.rmi.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

import com.icarus.rmi.Constants;
import com.icarus.rmi.WeatherData;
import com.icarus.rmi.WeatherService;

public class Client {
	
	private static final String HOST = "localhost";
	private static final int PORT = 1099;
	private static Registry registry;
	
	public static void main(String[] args) throws Exception {
		
		// Tìm kiếm registry theo host, port chỉ định
		registry = LocateRegistry.getRegistry(HOST, PORT);
		
		// Tìm kiếm WeatherService trong registry
		WeatherService service = (WeatherService) registry.lookup(WeatherService.class.getSimpleName());
		
		Date today = new Date();
		
		// Lấy thời tiết Chicago
		WeatherData chicagoWeather = service.getWeather(today, Constants.LOCATION_CHICAGO);
		System.out.println("Chicago weather today: " + chicagoWeather.getWeather());
		
		// Lấy thời tiết Hà nội
		WeatherData hanoiWeather = service.getWeather(today, Constants.LOCATION_HANOI);
		System.out.println("Hanoi weather today: " + hanoiWeather.getWeather());
		
	}

}
