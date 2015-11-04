package com.icarus.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.Date;

import com.icarus.rmi.Constants;
import com.icarus.rmi.WeatherData;
import com.icarus.rmi.WeatherService;

public class WeatherServiceImpl extends UnicastRemoteObject implements WeatherService {

	private static final long serialVersionUID = 949529999910054229L;

	protected WeatherServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public synchronized WeatherData getWeather(Date date, String location) throws RemoteException {
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		
		// Sunday, Monday
		if (dayOfWeek == 1 || dayOfWeek == 2) {
			if (location.equals(Constants.LOCATION_CHICAGO)) {
				// Rain
				return new WeatherData(date, location, Constants.WEATHER_RAIN);
			}
		}
		return new WeatherData(date, location, Constants.WEATHER_SUNNY);
	}

}
