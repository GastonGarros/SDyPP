package TP_SD.ejer7;

import java.rmi.RemoteException;
import java.util.Random;

public class Control  implements RemoteI{

	
	public Control() {
		
	}

	@Override
	public Object run(ITarea t) throws RemoteException {
		// TODO Auto-generated method stub
		return t.ejecutar();
	}
	

}
