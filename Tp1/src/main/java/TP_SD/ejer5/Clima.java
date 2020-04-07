package TP_SD.ejer5;

import java.rmi.RemoteException;
import java.util.Random;

public class Clima  implements RemoteI{
private String ubicacion;
private float temperatura;
	public Clima(String ubicacion) {
		// TODO Auto-generated constructor stub
		Random r = new Random();
	this.temperatura= r.nextFloat() + r.nextInt(40);
	this.ubicacion = ubicacion;
	
	}
	
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public float getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}
	@Override
	public String getTemperaute() throws RemoteException {
		// TODO Auto-generated method stub
		return String.valueOf(this.temperatura);
	}

	@Override
	public String getUbicacion() throws RemoteException {
		// TODO Auto-generated method stub
		return this.ubicacion;
	}

}
