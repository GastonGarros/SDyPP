package TP_SD.ejer4;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	static FileOutputStream fl ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.err.println("Bienvenido al servidor");
		Socket cl;
		
		try {
			//creamos el servidor abriedo un soket
			ServerSocket ss = new ServerSocket(9900);
		//	 fl = new FileOutputStream("./test.json",true);
			while(true){
				
				
				//aceptamos el cliente 
				
				cl= ss.accept();

				///////////////////////////////////////////////////////////////////////////////////////
				
					//creamos el thread 
					//1° creamos una instancia del server hijo que atendera al cliente
					
					ServerThread HThread = new ServerThread(cl);
					
					//2° asiganamos el nuevo servidor a la clase thereas
					
					Thread Th = new Thread(HThread);
					
					//3° ejecutamos el thread
					
					Th.start();
					
				
				}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
