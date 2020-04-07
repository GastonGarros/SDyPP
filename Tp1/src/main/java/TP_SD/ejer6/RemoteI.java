package TP_SD.ejer6;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteI extends Remote {
	
	public int[] restar (int[] v1, int[] v2) throws RemoteException;
	public int[] sumar (int[] v1, int[] v2) throws RemoteException;
	public int[] sumarError (int[] v1, int[] v2) throws RemoteException;
	

}
