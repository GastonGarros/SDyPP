package TP_SD.ejer7;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteI extends Remote {
	
	public Object run (ITarea t) throws RemoteException;
	
	

}
