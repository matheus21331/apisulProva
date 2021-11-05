package provaApisul;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ElevadorService implements IElevadorService{

	@Override
	public List<Integer> andarMenosUtilizado() {
		 JSONParser parser = new JSONParser();
	     ArrayList<Integer> todosAndares = new ArrayList<>(16);
        ArrayList<Integer> andarMenosUsado = new ArrayList<>();


	     for(int i = 0; i<16; i++) {
	    	 todosAndares.add(0);
	     }

		 try {

			 	Object obj = parser.parse(new FileReader( "C:\\Users\\mathe\\eclipse-workspace\\ApisulProva\\src\\provaApisul\\input.json" ));
	            JSONArray jsonarray = (JSONArray)obj;
	           

	            for (int i = 0; i < jsonarray.size(); i++) {
	                JSONObject jsonObject = (JSONObject)jsonarray.get(i);
	                int andar= Integer.parseInt(jsonObject.get("andar").toString());
	                int quantidade = todosAndares.get(andar);
	                quantidade++;
	                todosAndares.set(andar,quantidade);
	               
	            }
	            int quantidade = 0;
	            while(andarMenosUsado.isEmpty()) {
	            	for(int i = 0; i < todosAndares.size(); i++) {
	            		if(todosAndares.get(i) == quantidade ) {
	            			andarMenosUsado.add(i);
	            			
	            		}	
	            	}
	            	quantidade++;
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
 		return andarMenosUsado;

	}

	@Override
	public List<Character> elevadorMaisFrequentado() {
		JSONParser parser = new JSONParser();
	     ArrayList<Character> todosElevadores = new ArrayList<>(5);
       ArrayList<Character> elevadorMaisUsado = new ArrayList<>();


	     for(int i = 0; i<5; i++) {
	    	 todosElevadores.add(null);
	     }

		 try {

			 	Object obj = parser.parse(new FileReader( "C:\\Users\\mathe\\eclipse-workspace\\ApisulProva\\src\\provaApisul\\input.json" ));
	            JSONArray jsonarray = (JSONArray)obj;
	            ArrayList<Character> elevadores = new ArrayList<>(Arrays.asList(new Character[jsonarray.size()]));
	            Collections.fill(elevadores, null);

	            for (int i = 0; i < jsonarray.size(); i++) {
	                JSONObject jsonObject = (JSONObject)jsonarray.get(i);
	                char elevador= (char) jsonObject.get("elevador");
	                
					
	                int quantidade = todosElevadores.get(i);
	                quantidade++;
	                todosElevadores.set(quantidade,elevador);
	               
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
		return elevadorMaisUsado;

	}

	@Override
	public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Character> elevadorMenosFrequentado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float percentualDeUsoElevadorA() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float percentualDeUsoElevadorB() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float percentualDeUsoElevadorC() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float percentualDeUsoElevadorD() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float percentualDeUsoElevadorE() {
		// TODO Auto-generated method stub
		return 0;
	}

}
