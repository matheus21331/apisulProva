package provaApisul;

import java.io.FileNotFoundException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class Main {
	
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
	     ArrayList<Integer> todosElevadores = new ArrayList<>(5);
      ArrayList<Character> elevadorMaisUsado = new ArrayList<>();
      ArrayList<Integer> elevadoresNumero = new ArrayList<>(6);


	     for(int i = 0; i<6; i++) {
	    	 todosElevadores.add(0);
	     }

	      for(int i = 0; i<6; i++) {
	    	  elevadoresNumero.add(0);
		     }
		 try {

			 	Object obj = parser.parse(new FileReader( "C:\\Users\\mathe\\eclipse-workspace\\ApisulProva\\src\\provaApisul\\input.json" ));
	            JSONArray jsonarray = (JSONArray)obj;
	            ArrayList<Character> elevadores = new ArrayList<>(Arrays.asList(new Character[jsonarray.size()]));
	            Collections.fill(elevadores, null);

	            for (int i = 0; i < jsonarray.size(); i++) {
	                JSONObject jsonObject = (JSONObject)jsonarray.get(i);
	                String elevador=  jsonObject.get("elevador").toString();
	                switch (elevador) {
					case "A":
						
						elevadoresNumero.set(i,0);
						break;
					case "B":
						elevadoresNumero.set(i,1);
						break;
					
					case "C":
						elevadoresNumero.set(i,2);
						break;
					case "D":
						elevadoresNumero.set(i,3);
						break;
					case "E":
						elevadoresNumero.set(i,4);
						break;
					}
					
	                int quantidade = todosElevadores.get(i);
	                quantidade++;
	                todosElevadores.set(elevadoresNumero.get(i),quantidade);
	               
	            }
	        

		 }
	        catch(FileNotFoundException fe)
	        {
	            fe.printStackTrace();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
		
	}
}
