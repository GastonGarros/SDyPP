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
			Registry clienteRMI = LocateRegistry.getRegistry("127.0.0.1",9900);
			
			String[] serviceList = clienteRMI.list();

			System.out.println("Servicio disponibles");
			for (String s : serviceList) {

				System.out.println(s);
				
			}
			
			RemoteI ri = (RemoteI) clienteRMI.lookup(serviceList[0]);
		 
			//creamos los vectores
			int[] v1= new int[3];
			int[] v2 = new int[3]; 
			
			//cargamos los vectores
			Scanner sc = new Scanner(System.in);
			System.out.println("Ingrese los valores del vector 1:");
			for (int i = 0; i < v1.length; i++) {
				System.out.println("V1["+i+"]");
				v1[i]=sc.nextInt();
			}


			System.out.println("Ingrese los valores del vector 2:");
			for (int i = 0; i < v2.length; i++) {
				System.out.println("V2["+i+"]");
				v2[i]=sc.nextInt();
			}
	
			//vector de resultados
			sc.close();
			int[] resultado = {0,0,0};
			resultado = ri.sumar(v1, v2);
			
			System.out.println("Resultado de la suma de los vectores: ["+resultado[0]+","+resultado[1]+","+resultado[2] +"]");
			
			resultado = ri.restar(v1, v2);
			
			System.out.println("Resultado de la resta de los vectores: ["+resultado[0]+","+resultado[1]+","+resultado[2] +"]");
			resultado = ri.sumarError(v1, v2);
			
			System.out.println("Resultado de la suma con error de los vectores: ["+resultado[0]+","+resultado[1]+","+resultado[2] +"]");
			System.out.println("Error introducido en el server V1 deberia tener todos ceros si los parametros son pasados por referencia de lo contrario son enviados por valor\n V1:["+v1[0]+","+v1[1]+","+v1[2]+"]");

			
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
