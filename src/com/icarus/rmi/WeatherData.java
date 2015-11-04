package com.icarus.rmi;

import java.io.Serializable;
import java.util.Date;

public class WeatherData implements Serializable {

	private static final long serialVersionUID = 3692050149987496413L;
	
	private Date date;
	private String location;
	private String weather;
	
	public WeatherData(Date date, String location, String weather) {
		this.date = date;
		this.location = location;
		this.weather = weather;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

}
