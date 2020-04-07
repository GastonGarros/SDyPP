package TP_SD.ejer4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class ServerThread implements Runnable{

	 Socket cliente;
	 PrintWriter canalSalida ;
	 BufferedReader canalEntrada ;
	ArrayList<Mensaje> lista= new ArrayList<Mensaje>();
	 Gson gson = new Gson();
	 ObjectMapper mapper = new ObjectMapper();
	 String msgCliente;
	 FileInputStream fl ;
	 FileOutputStream flsalida;
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
		String accion="" ;
		//mostramos el ciente que se conecto con el servidor ip y puerto
		System.out.println(	"Cliente recibido "+this.cliente.getInetAddress().getCanonicalHostName() + " : " + this.cliente.getPort());
		
		try {
			//leemos el mensaje del cliente con la accion a realizar
			
			//abrimos el archivo donde estan los mensajes
				boolean salir = false;
			while (!salir) {
					 accion = canalEntrada.readLine();
					switch(accion) {
					case "enviar": //el cliente envio un mensaje al servidor para almacenar
						//enviarMensaje();
						
						//descargamos los mensajes en memoria
						lista =recuperarMensaje("");
						flsalida = new  FileOutputStream("./test.json");
						
						//Leemos el obejto json del cliente
						
						msgCliente = canalEntrada.readLine();
						
						Mensaje msg = gson.fromJson(msgCliente, Mensaje.class);
						
						//Guardamos el objeto en la lista
						lista.add(msg);
						//grabamos el mensaje en el archivo
					//	 ObjectMapper mapper = new ObjectMapper();
						mapper.writerWithDefaultPrettyPrinter().writeValue(flsalida, lista);
						
						System.out.println("El mensaje del ciente '"+msg.getIdFrom() +"' para "+msg.getIdTo()+" fue guardado correctamente");
						
						flsalida.close();
						
						break;
					case "leer": //el cliente quiere leer un mensaje
					
						//leo el mensaje que viene del cliente con el nombre
						msgCliente = canalEntrada.readLine();
						System.out.println(msgCliente);
						//recuperamos la lista de mensajes del archivo
						lista = recuperarMensaje(msgCliente);
						String JSON = gson.toJson(lista);
						
					
						//la enviamos al cliente
						canalSalida.println(JSON);
						canalSalida.flush();
						//esperamos la confirmacion con ack
						String ackcliente = canalEntrada.readLine();
						if(ackcliente.equals("ACK")) {
							ArrayList<Mensaje> listborrar=lista;
							ArrayList<Mensaje> listComp=recuperarMensaje("");
							for(int i=0; i<listComp.size();i++) {
							
								for(Mensaje mb: listborrar) {
									if(listComp.get(i).getIdTo().equals(msgCliente)) {
										listComp.remove(i);
									}
									
								}
							
							
							
							}
							//en listacomp queda la lista a guardar con los item borrados	
							flsalida = new  FileOutputStream("./test.json");
							mapper.writerWithDefaultPrettyPrinter().writeValue(flsalida, listComp);
							System.out.println("El mensaje del ciente '"+msgCliente +" fueron borrados del la cola");
						}
						
						
						break;
					case "salir": 
						salir = true;
						this.cliente.close();
						
						break;
						
						
					}
					
			}		
			// mostramos el mensajes del cliente por consola
			//System.out.print("Mensaje del cliente: "+msgEntrada);
			
			//repetimos el mensaje al cliente
		//	canalSalida.println(accion);

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	
		
	}
	//Metodo que recupera los mesajes del archivo
	public ArrayList<Mensaje> recuperarMensaje(String usuario) throws JsonParseException, JsonMappingException, IOException {
		ArrayList<Mensaje> envCli = new ArrayList<Mensaje>();
		
		
	
			
				fl = new FileInputStream("./test.json");
				//recupero todos los leidos del historial
				lista= mapper.readValue(fl,  new TypeReference<ArrayList<Mensaje>>() { });
				//fl.close();
				
	
	
		
		
		
		
		if(usuario.equals("")) {
			//retorno la lista completa
			return lista;
		}else {
		
			//busco en la lista los usuarios con ese nombre 
			for (Mensaje m : lista) {
				if(m.getIdTo().equals(usuario)) {
					
					envCli.add(m);
				}
			}
			return envCli;
		}
		// TODO Auto-generated method stub
		
	}

/*	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
	}*/

}
