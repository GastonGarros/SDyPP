package TP_SD.ejer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.omg.CORBA.portable.InputStream;

/**
 * Hello world!
 *
 */
public class Cliente 
{
    public static void main( String[] args )
    {
        System.out.println( "Bienvenido al cliente" );
        
        try {
			
        	Socket s = new Socket("127.0.0.1",9900);
			
			//creamos canal de entrada y salida
			BufferedReader canalEntrada = new  BufferedReader( new InputStreamReader(s.getInputStream()));
			PrintWriter canalSalida =  new PrintWriter(s.getOutputStream(), true);
			
			//capturamos el mensajes que se debe enviar al cliente
			System.err.println("Ingrese el texto para enviar al servidor");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String texto = br.readLine();
			
			//enviamos el texto al servidor
			canalSalida.println( texto);
			
			//capturmaos la repuesta del servidor y lo mostramos por consola
			String  msgRepuesta = canalEntrada.readLine();
			
			System.out.println("Repuesta del Servidor: " + msgRepuesta);
			
			//cerramos el cliente
			s.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }
}
