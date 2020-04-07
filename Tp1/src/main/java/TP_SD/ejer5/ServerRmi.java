package TP_SD.ejer5;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

public class ServerRmi {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		
		try {
			
			Clima c = new Clima("Buenos Aires");

			Registry serveRmi = LocateRegistry.createRegistry(9900);
			
			System.err.println("server RMI running");
			
			RemoteI serviceClima = (RemoteI) UnicastRemoteObject.exportObject(c,8800);
			
			serveRmi.rebind("InfoClima", serviceClima);
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
