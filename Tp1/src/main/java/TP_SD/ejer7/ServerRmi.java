package TP_SD.ejer7;

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
			
			Control control = new Control();

			Registry serveRmi = LocateRegistry.createRegistry(9900);
			
			System.err.println("server RMI running");
			
			RemoteI serviceOperaciones = (RemoteI) UnicastRemoteObject.exportObject(control,8801);
			
			serveRmi.rebind("OperacionesMatematicas", serviceOperaciones);
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
