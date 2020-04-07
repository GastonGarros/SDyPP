package TP_SD.ejer5;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteI extends Remote {
	
	public String getTemperaute () throws RemoteException;
	public String getUbicacion () throws RemoteException;
	

}
