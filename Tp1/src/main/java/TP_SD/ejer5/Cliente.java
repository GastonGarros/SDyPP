package TP_SD.ejer5;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			Registry clienteRMI = LocateRegistry.getRegistry("127.0.0.1",9900);
			
			String[] serviceList = clienteRMI.list();

			System.out.println("Servicio disponibles");
			for (String s : serviceList) {

				System.out.println(s);
				
			}
			
			RemoteI ri = (RemoteI) clienteRMI.lookup(serviceList[0]);
		//	RemoteI r12 = (RemoteI) clienteRMI.lookup(serviceList[1]);
			
			System.out.println("La temperatura es " + ri.getTemperaute()+" °C en "+ ri.getUbicacion());
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
