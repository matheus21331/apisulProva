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
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class Main {
	
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		Map< String, Integer> elevadoresQuantidade = new HashMap<String, Integer>();
		List<Character> elevadorMaisUsado = new ArrayList<>();

	  
		 try {

			 	Object obj = parser.parse(new FileReader( "C:\\Users\\mathe\\eclipse-workspace\\ApisulProva\\src\\provaApisul\\input.json" ));
	            JSONArray jsonarray = (JSONArray)obj;
	     
	            int quantidadeA = 0;
	            int quantidadeB = 0;
	            int quantidadeC = 0;
	            int quantidadeD = 0;
	            int quantidadeE = 0;
	            for (int i = 0; i < jsonarray.size(); i++) {

	                JSONObject jsonObject = (JSONObject)jsonarray.get(i);
	                String elevador=  jsonObject.get("elevador").toString();

	                switch (elevador) {
						case "A":
							quantidadeA++;
							elevadoresQuantidade.put(elevador, quantidadeA);
							break;
						case "B":
							quantidadeB++;
							elevadoresQuantidade.put(elevador, quantidadeB);
							break;
						
						case "C":
							quantidadeC++;
							elevadoresQuantidade.put(elevador, quantidadeC);
							break;
						case "D":
							quantidadeD++;
							elevadoresQuantidade.put(elevador, quantidadeD);
							break;
						case "E":
							quantidadeE++;
							elevadoresQuantidade.put(elevador, quantidadeE);
							break;					
						}
	               
	               
	            }
                int currentMaxValuevalue = Integer.MIN_VALUE;
                for (Entry<String, Integer> entry : elevadoresQuantidade.entrySet()){
                    if (entry.getValue() > currentMaxValuevalue){
                    	elevadorMaisUsado.clear();
                    	elevadorMaisUsado.add(entry.getKey().charAt(0));
                        currentMaxValuevalue = entry.getValue();
                    } else if (entry.getValue() == currentMaxValuevalue){
                    	elevadorMaisUsado.add(entry.getKey().charAt(0));
                    }            
                }
                System.out.println(elevadorMaisUsado);
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
