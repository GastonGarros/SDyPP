package TP_SD.ejer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable{

	 Socket cliente;
	 PrintWriter canalSalida ;
	 BufferedReader canalEntrada ;
	public ServerThread(Socket cl) {
		
		this.cliente = cl;
		
		try {
			// creamos los canales de entrada y salida del servidor
			canalEntrada = new BufferedReader (new InputStreamReader (this.cliente.getInputStream()));

			canalSalida = new PrintWriter (this.cliente.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		// TODO Auto-generated constructor stub
	}
	public void run() {
		// TODO Auto-generated method stub
		
		//mostramos el ciente que se conecto con el servidor ip y puerto
		System.out.println(	"Cliente recibido "+this.cliente.getInetAddress().getCanonicalHostName() + " : " + this.cliente.getPort());
		
		
		try {
			//leemos el mensaje del cliente
			String msgEntrada = canalEntrada.readLine();
			// mostramos el mensajes del cliente por consola
			System.out.print("Mensaje del cliente: "+msgEntrada);
			
			//repetimos el mensaje al cliente
			canalSalida.println(msgEntrada);

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	
		
	}

/*	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
	}*/

}
