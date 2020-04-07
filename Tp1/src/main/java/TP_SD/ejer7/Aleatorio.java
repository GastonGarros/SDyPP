package TP_SD.ejer7;

import java.util.Random;

public class Aleatorio implements ITarea {
	
	
	
private Random random;


	public Aleatorio() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Object ejecutar() {
		// TODO Auto-generated method stub
		return random.nextInt(1000);
	}

}
