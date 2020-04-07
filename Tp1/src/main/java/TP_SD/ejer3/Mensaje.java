package TP_SD.ejer3;

public class Mensaje {

	String idFrom;
	String idTo;
	String msg;
	

	public String getIdFrom() {
		return idFrom;
	}

	public void setIdFrom(String idFrom) {
		this.idFrom = idFrom;
	}

	public String getIdTo() {
		return idTo;
	}

	public void setIdTo(String idTo) {
		this.idTo = idTo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Mensaje() {
		
	}
	public Mensaje(String idFrom, String idTo, String msg) {
		super();
		this.idFrom = idFrom;
		this.idTo = idTo;
		this.msg = msg;
	}

}
