package com.icarus.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface WeatherService extends Remote {
	
	// Method lấy về đối tưọng thông tin thời tiết
	// Tham số truyền vào ngày và địa điểm
	public WeatherData getWeather(Date date, String location) throws RemoteException;

}
