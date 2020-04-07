package TP_SD.ejer7;

import java.rmi.RemoteException;
import java.util.Random;

public class Operaciones  implements RemoteI{

	
	public Operaciones() {
		
	}
	

	@Override
	public int[] restar(int[] v1, int[] v2) throws RemoteException {
		// TODO Auto-generated method stub
		int[] resultado = new int[3];
		for (int i = 0; i < v1.length; i++) {
			resultado[i] =v1[i] - v2[i];
		}
		return resultado;
	}

	@Override
	public int[] sumar(int[] v1, int[] v2) throws RemoteException {
		// TODO Auto-generated method stub
		
		int[] resultado = {0,0,0};
		for (int i = 0; i < v1.length; i++) {
			resultado[i] =v1[i] + v2[i];
		}
		return resultado;
	}

	@Override
	public int[] sumarError(int[] v1, int[] v2) throws RemoteException {
		// TODO Auto-generated method stub
		
		int[] resultado = new int[3];
		for (int i = 0; i < v1.length; i++) {
			resultado[i] =v1[i] + v2[i];
		}
		
		//Cambio de parametros ????
		System.out.println("Se cambiaron los valores del V1 para ver como actual los parametros enviados por el cliente");
		v1[0] = 0;
		v1[1] = 0;
		v1[2] = 0;
			System.out.println("V1:["+v1[0]+","+v1[1]+","+v1[2]+"]");
			
		
		return resultado;
	}

}
