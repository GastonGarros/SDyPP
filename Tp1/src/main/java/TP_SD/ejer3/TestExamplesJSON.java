package TP_SD.ejer3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class TestExamplesJSON {
	public static final ObjectMapper JSON_MAPPER = new ObjectMapper();

	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException{
		
		JSONObject obj = new JSONObject();
		obj.put("nombre", "Fernando");
		obj.put("edad", new Integer(32));
	 
		JSONArray list = new JSONArray();
		list.add("Java");
		list.add("Ceylon");
		list.add("Python");
	  Mensaje msg = new Mensaje("alba", "Gaston", "Hola prondago");
		obj.put("lenguajes_favoritos", list);
		Mensaje msg1 = new Mensaje("Gaston", "Alba", "Hola ");
		 Gson gson = new Gson();String JSON = gson.toJson(msg);
		try{
			
			ObjectMapper mapper = new ObjectMapper();
			ArrayList<Mensaje> lm = new  ArrayList<Mensaje>();
			lm.add(msg1);
			lm.add(msg);
			
			String json = mapper.writerWithDefaultPrettyPrinter()
			                    .writeValueAsString(lm);
			
		
			
			System.err.print(json);
			FileOutputStream fl = new FileOutputStream("./test.json");
		//FileWriter file = new FileWriter("./test.json");
			
			mapper.writerWithDefaultPrettyPrinter().writeValue(fl, lm);
			
			
			
		
	//	JSON_MAPPER.writeValue(file, msg);
			
			
			/*FileWriter file = new FileWriter("./test.json",true);
			file.write(JSON);
			file.flush();
			file.close();
			*/
			
		}catch(Exception ex){
			System.out.println("Error: "+ex.toString());
		}
		finally{
			System.out.print(obj);
		}
		
	/*	
		
		JSONParser parser = new JSONParser();
		try{
			Object obj = parser.parse(new FileReader("./test.json"));
			 
			JSONObject jsonObject = (JSONObject) obj;
	 
			String nombre = (String) jsonObject.get("nombre");
			System.out.println("nombre:"+nombre);
	 
			long edad = (Long) jsonObject.get("edad");
			System.out.println("edad:"+edad);
	 
			// recorrer arreglo
			JSONArray leng= (JSONArray) jsonObject.get("lenguajes_favoritos");
			System.out.println("lenguajes_favoritos:");
			Iterator iterator =leng.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			
		}catch(Exception ex){
			System.err.println("Error: "+ex.toString());
		}finally{
			
		}*/
}

}

//--------------------------------------------------
//escribir
/*
JSONObject obj = new JSONObject();
		obj.put("nombre", "Fernando");
		obj.put("edad", new Integer(32));
	 
		JSONArray list = new JSONArray();
		list.add("Java");
		list.add("Ceylon");
		list.add("Python");
	 
		obj.put("lenguajes_favoritos", list);
		
		try{
			FileWriter file = new FileWriter("/src/temp/test.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();
			
			
		}catch(Exception ex){
			System.out.println("Error: "+ex.toString());
		}
		finally{
			System.out.print(obj);
		}
	*/
/*
test.json
{"nombre":"Ariel","edad":32,"lenguajes_favoritos":["Java","Ceylon","Python"]}
*/