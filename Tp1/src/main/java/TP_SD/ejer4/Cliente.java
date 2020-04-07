package TP_SD.ejer4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


/**
 * Hello world!
 *
 */
public class Cliente 
{
	 static ObjectMapper mapper = new ObjectMapper();
	static PrintWriter canalSalida ;
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));;
	static BufferedReader canalEntrada;
	static String texto;
	static String NombreCliente="";
	static Gson gson = new Gson();
	
    public static void main( String[] args )
    {
        System.out.println( "Bienvenido al cliente" );
        System.out.println("Ingrese su nombre:");
		try {
			NombreCliente =  br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
            try {
			
        	Socket s = new Socket("127.0.0.1",9900);
			
			//creamos canal de entrada y salida
			canalEntrada = new  BufferedReader( new InputStreamReader(s.getInputStream()));
			canalSalida =  new PrintWriter(s.getOutputStream(), true);
			
			boolean salir = false;
			int opt;
			
			while(!salir) {
				
				//capturamos el mensajes que se debe enviar al cliente
				System.out.println("Ingrese la opcion que desea realizar");
				System.out.println("1- Leer mensajes");
				System.out.println("2- enviar mensajes");
				System.out.println("3- Salir\n\n");
				
				
				texto = br.readLine();
			
				opt = Integer.parseInt(texto);
				switch(opt) {
				case 1: 
					ArrayList<Mensaje> me =recuperarMensaje();
					
				//imprmimo la lista de mensajes
					if(!me.isEmpty()) {
						for(Mensaje m :me) {
					
				
						System.out.println("Mensaje de "+m.getIdFrom());
						System.out.println("	Mensaje:"+m.getMsg()+"\n");
					
						}
						System.out.println("confirmar la recepcion de mensajes con 'ok' y presionar enter");
						String b =br.readLine(); 
						while(!b.equals("ok")) {
							System.out.println("Error en confirmacion por favor confirme con 'ok'");
							b=br.readLine();
						}
						canalSalida.println("ACK");
					}	else {
						System.out.println("Usted no tiene ningun mensaje pendiente");
					}
					break;
				case 2: 
					enviarMensaje();
					break;
				case 3: 
					salir = true;
					canalSalida.println("salir");
					
					//cerramos el cliente
					s.close();
					
					break;
				}
				
				
			}
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }

	private static ArrayList<Mensaje> recuperarMensaje() {
		
		canalSalida.println( "leer");
		//canalSalida.flush();
		canalSalida.println(NombreCliente);
		//canalSalida.flush();
		Mensaje msg = new Mensaje();
		ArrayList<Mensaje> lista = null ;
		try {
			
			
			
			//leemos el mensajes del servidor
		String msgServer = canalEntrada.readLine();
			

				
		lista = mapper.readValue(msgServer,  new TypeReference<ArrayList<Mensaje>>() { });
		
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return lista;
	}
	

	private static void enviarMensaje() {
		
		//enviamos al server la opcion de mensaje nuevo
		canalSalida.println( "enviar");
		Mensaje msg = new Mensaje();
		
		try {
			System.err.println("Ingrese a quien se dirige el mensaje:");
			msg.setIdTo(br.readLine());
			
			msg.setIdFrom(NombreCliente);
			System.err.println("Ingrese el mensaje:");
			msg.setMsg(br.readLine());
			//convierto el mensaje a json
			String JSON = gson.toJson(msg);
			
			canalSalida.println(JSON);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		
	}
}
