package com.icarus.rmi.server;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.icarus.rmi.WeatherService;

public class Server {

	private static final int port = 1099;
	private static Registry registry;

	// Tạo 1 bộ Registry tại server
	public static void startRegistry() throws RemoteException {
		registry = LocateRegistry.createRegistry(port);
	}

	public static void registryObject(String name, Remote remoteObj)
			throws AccessException, RemoteException, AlreadyBoundException {
		// Đăng ký đối tượng vào bộ đăng ký
		// Nó được gắn với tên nào đó
		// Client sẽ tìm kiếm trong bộ đăng ký với tên này để có thể gọi đối
		// tượng
		registry.bind(name, remoteObj);
		System.out.println("Registered: " + name + " -> " + remoteObj.getClass().getName() + "[" + remoteObj + "]");
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("Server starting...");
		startRegistry();
		registryObject(WeatherService.class.getSimpleName(), new WeatherServiceImpl());
		
		// Server đã được start và đang lắng nghe các request từ client
		System.out.println("Server started!");
	}

}
