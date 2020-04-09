package TP_SD.ejer7;

import java.io.Serializable;

public class Primo implements ITarea,Serializable {

	int primo;
	public Primo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object ejecutar() {
		// TODO Auto-generated method stub
		
		
		
		int c = 2;
		  boolean pri=true;
		  while ((pri) && (c!=this.primo)){
		    if (this.primo % c == 0)
		      pri = false;
		    c++;
		  }
		  return pri;
		
	}
	public void setPrimo(int p) {
		this.primo = p;
	}

}
