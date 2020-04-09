package TP_SD.ejer7;

import java.io.Serializable;
import java.util.Random;

public class Aleatorio implements ITarea ,Serializable{
	

	
private int random;


	public Aleatorio() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Object ejecutar() {
		// TODO Auto-generated method stub
		return new Random().nextInt(1000);
	}

}
