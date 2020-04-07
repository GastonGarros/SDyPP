package TP_SD.ejer1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.err.println("Bienvenido al servidor");
		Socket cl;
		
		try {
			//creamos el servidor abriedo un soket
			ServerSocket ss = new ServerSocket(9900);
			
			while(true){
				//aceptamos el cliente 
				
				cl= ss.accept();
				
				//mostramos el ciente que se conecto con el servidor ip y puerto
				System.out.println(	"Cliente recibido "+cl.getInetAddress().getCanonicalHostName() + " : " + cl.getPort());
				
				// creamos los canales de entrada y salida del servidor
				BufferedReader canalEntrada = new BufferedReader (new InputStreamReader (cl.getInputStream()));
				PrintWriter canalSalida = new PrintWriter (cl.getOutputStream(), true);
				
				//leemos el mensaje del cliente
				String msgEntrada = canalEntrada.readLine();
				
				// mostramos el mensajes del cliente por consola
				System.out.print("Mensaje del cliente: "+msgEntrada);
				
				//repetimos el mensaje al cliente
				canalSalida.println(msgEntrada);
				
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("El servidor en ese puerto esta ocupado");
		}
		

	}

}
