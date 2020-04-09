package TP_SD.ejer7;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {

			Scanner sc = new Scanner(System.in);
			Primo p = new Primo();
			Aleatorio a = new Aleatorio();
			
			Registry clienteRMI = LocateRegistry.getRegistry("127.0.0.1",9900);
			
			String[] serviceList = clienteRMI.list();

			System.out.println("Servicio disponibles");
			for (String s : serviceList) {

				System.out.println(s);
				
			}
			
			RemoteI ri = (RemoteI) clienteRMI.lookup(serviceList[0]);
			
			System.out.println("El numero aleatorio ejecutado en el servidor es: "+ri.run(a).toString());
			
			
			System.out.println("Ingrese un numero para comprobar si es primo");
			int p1 = sc.nextInt();
			p.setPrimo(p1);
			
			if((boolean) ri.run(p)) {
				System.out.println("El numero "+p1+" es primo");
			}else {
				System.out.println("El numero "+p1+" no es primo");
			}
			
		//	Object resultado = ri.restar(v1, v2);
			
			
			
			
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
