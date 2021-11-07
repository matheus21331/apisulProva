package provaApisul;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ElevadorService implements IElevadorService{
	public JSONArray jsonArray() {
		 JSONParser parser = new JSONParser();
		 JSONArray jsonarray = null;
		 try {
			 Object obj = parser.parse(new FileReader( "C:\\Users\\mathe\\eclipse-workspace\\ApisulProva\\src\\provaApisul\\input.json" ));

	            jsonarray = (JSONArray)obj;
	            	         

		 }
	        catch(FileNotFoundException fe)
	        {
	            fe.printStackTrace();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
		return jsonarray;
		
	}
	
	public Map<String, Integer> quantidadeElevadores(JSONArray jsonarray) {
		
		Map< String, Integer> elevadoresQuantidade = new HashMap<String, Integer>();

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
		return elevadoresQuantidade;
		
	}
	public  Map<String, Integer> usoTurno(JSONArray jsonarray) {
		Map< String, Integer> quantidadeUsoTurno = new HashMap<String, Integer>();

		  int quantidadeM = 0;
		  int quantidadeN = 0;
	      int quantidadeP = 0;
	   
	      for (int i = 0; i < jsonarray.size(); i++) {

	          JSONObject jsonObject = (JSONObject)jsonarray.get(i);
	          String elevador=  jsonObject.get("turno").toString();

	          switch (elevador) {
					case "M":
						quantidadeM++;
						quantidadeUsoTurno.put(elevador, quantidadeM);
						break;
					case "N":
						quantidadeN++;
						quantidadeUsoTurno.put(elevador, quantidadeN);
						break;
					
					case "V":
						quantidadeP++;
						quantidadeUsoTurno.put(elevador, quantidadeP);
						break;
						
					}
	         
	             
	          }
			return quantidadeUsoTurno;
		
	}
		public List<Character> turnoMaisUtilizado(Map< String, Integer> quantidadeUsoTurno) {
			List<Character> turnoMaisUsado = new ArrayList<>();

			int currentMaxValuevalue = Integer.MIN_VALUE;
			for (Entry<String, Integer> entry : quantidadeUsoTurno.entrySet()){
				if (entry.getValue() > currentMaxValuevalue){
            	  turnoMaisUsado.clear();
            	  turnoMaisUsado.add(entry.getKey().charAt(0));
                  currentMaxValuevalue = entry.getValue();
				} else if (entry.getValue() == currentMaxValuevalue){
            	  turnoMaisUsado.add(entry.getKey().charAt(0));
				}            
			
			}	
			return turnoMaisUsado;	
		}

	public float percentualUsoElevador(int quantitadeAndar, int totalEntradas) {
		float calculoPercentual = (float) ((float)(quantitadeAndar*100)/totalEntradas);
		return  calculoPercentual;
	}
	
	@Override
	public List<Integer> andarMenosUtilizado() {
	     ArrayList<Integer> todosAndares = new ArrayList<>(16);
	     ArrayList<Integer> andarMenosUsado = new ArrayList<>();
	     for(int i = 0; i<16; i++) {
	    	 todosAndares.add(0);
	     }

		
	            for (int i = 0; i <  jsonArray().size(); i++) {
	                JSONObject jsonObject = (JSONObject)jsonArray().get(i);
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
	           

		
 		return andarMenosUsado;

	}

	@Override
	public List<Character> elevadorMaisFrequentado() {
		List<Character> elevadorMaisUsado = new ArrayList<>();
 
        int currentMaxValuevalue = Integer.MIN_VALUE;
        for (Entry<String, Integer> entry : quantidadeElevadores(jsonArray()).entrySet()){
            if (entry.getValue() > currentMaxValuevalue){
            	elevadorMaisUsado.clear();
            	elevadorMaisUsado.add(entry.getKey().charAt(0));
                currentMaxValuevalue = entry.getValue();
            } else if (entry.getValue() == currentMaxValuevalue){
            	elevadorMaisUsado.add(entry.getKey().charAt(0));
            }            
        }
    
		 return elevadorMaisUsado;

	}

	@Override
	public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {
		List<Character> turnoMaisUsado = new ArrayList<>();
		List<String> turnosFrequentados = new ArrayList<>();
		Map< String, Integer> quantidadeTurnos = new HashMap<String, Integer>();

	
	            for(int i = 0; i < jsonArray().size(); i++ ) {
	  	          	JSONObject jsonObject = (JSONObject)jsonArray().get(i);
	  	          	String elevadorMomento = jsonObject.get("elevador").toString();
	  	          	String turnoMomento = jsonObject.get("turno").toString();
	  	          	
		  	          		if(elevadorMomento.equals(elevadorMaisFrequentado().get(0).toString())) {
			  	          		turnosFrequentados.add(turnoMomento);
		            		}
	  	          		
		  	          	
	  	          	}
	  	          
	            
	            int turnoM = 0;
	  		  int turnoN = 0;
	  	      int turnoV = 0;
	  	   
	  	      for (int i = 0; i < turnosFrequentados.size(); i++) {

	  	         
	  	          String turno=  turnosFrequentados.get(i);

	  	          switch (turno) {
	  					case "M":
	  						turnoM++;
	  						quantidadeTurnos.put(turno, turnoM);
	  						break;
	  					case "N":
	  						turnoN++;
	  						quantidadeTurnos.put(turno, turnoN);
	  						break;
	  					
	  					case "V":
	  						turnoV++;
	  						quantidadeTurnos.put(turno, turnoV);
	  						break;
	  						
	  					}
	  	          }
              int currentMaxValuevalue = Integer.MIN_VALUE;
              for (Entry<String, Integer> entry : quantidadeTurnos.entrySet()){
                  if (entry.getValue() > currentMaxValuevalue){
                	  turnoMaisUsado.clear();
                	  turnoMaisUsado.add(entry.getKey().charAt(0));
                      currentMaxValuevalue = entry.getValue();
                  } else if (entry.getValue() == currentMaxValuevalue){
                	  turnoMaisUsado.add(entry.getKey().charAt(0));
                  }            
              }
	     
		return turnoMaisUsado;
		
	
	}

	@Override
	public List<Character> elevadorMenosFrequentado() {
		List<Character> elevadorMenosUsado = new ArrayList<>();

	        
                int currentMaxValuevalue = Integer.MAX_VALUE;
                for (Entry<String, Integer> entry :  quantidadeElevadores(jsonArray()).entrySet()){
                    if (entry.getValue() < currentMaxValuevalue){
                    	elevadorMenosUsado.clear();
                    	elevadorMenosUsado.add(entry.getKey().charAt(0));
                        currentMaxValuevalue = entry.getValue();
                    } else if (entry.getValue() == currentMaxValuevalue){
                    	elevadorMenosUsado.add(entry.getKey().charAt(0));
                    }            
                }
		 	
		 return elevadorMenosUsado;
	}

	@Override
	public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {
		List<Character> turnoMenosUsado = new ArrayList<>();
		List<String> turnosFrequentados = new ArrayList<>();
		Map< String, Integer> quantidadeTurnos = new HashMap<String, Integer>();

	
	            for(int i = 0; i < jsonArray().size(); i++ ) {
	            	JSONObject jsonObject = (JSONObject)jsonArray().get(i);
	  	          	String elevadorMomento = jsonObject.get("elevador").toString();
	  	          	String turnoMomento = jsonObject.get("turno").toString();
	  	          	
		  	          		if(elevadorMomento.equals(elevadorMenosFrequentado().get(0).toString())) {
			  	          		turnosFrequentados.add(turnoMomento);
		            		}
	  	          		
		  	          	
	  	          	}
	  	          
	            
	            int turnoM = 0;
	  		  int turnoN = 0;
	  	      int turnoV = 0;
	  	   
	  	      for (int i = 0; i < turnosFrequentados.size(); i++) {

	  	         
	  	          String turno=  turnosFrequentados.get(i);

	  	          switch (turno) {
	  					case "M":
	  						turnoM++;
	  						quantidadeTurnos.put(turno, turnoM);
	  						break;
	  					case "N":
	  						turnoN++;
	  						quantidadeTurnos.put(turno, turnoN);
	  						break;
	  					
	  					case "V":
	  						turnoV++;
	  						quantidadeTurnos.put(turno, turnoV);
	  						break;
	  						
	  					}
	  	          }
              int currentMaxValuevalue = Integer.MAX_VALUE;
              for (Entry<String, Integer> entry : quantidadeTurnos.entrySet()){
                  if (entry.getValue() < currentMaxValuevalue){
                	  turnoMenosUsado.clear();
                	  turnoMenosUsado.add(entry.getKey().charAt(0));
                      currentMaxValuevalue = entry.getValue();
                  } else if (entry.getValue() == currentMaxValuevalue){
                	  turnoMenosUsado.add(entry.getKey().charAt(0));
                  }                 
              }
	     
		return turnoMenosUsado;
	}

	@Override
	public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {
		List<Character> turnoMaiorFluxo = new ArrayList<>();		
	    turnoMaiorFluxo =  turnoMaisUtilizado(usoTurno(jsonArray()));
	    	 	
		return turnoMaiorFluxo;
	}

	@Override
	public float percentualDeUsoElevadorA() {
	    float percentualA = percentualUsoElevador(quantidadeElevadores(jsonArray()).get("A"),jsonArray().size());
	    	
		return percentualA;
	}

	@Override
	public float percentualDeUsoElevadorB() {
		float percentualB = percentualUsoElevador(quantidadeElevadores(jsonArray()).get("B"),jsonArray().size());
	    
		return percentualB;
	}

	@Override
	public float percentualDeUsoElevadorC() {
	    float percentualC = percentualUsoElevador(quantidadeElevadores(jsonArray()).get("C"),jsonArray().size());
	    	
		
		 return percentualC;
	}

	@Override
	public float percentualDeUsoElevadorD() {	
		 float percentualD = percentualUsoElevador(quantidadeElevadores(jsonArray()).get("D"),jsonArray().size());
	    	
		 return percentualD;
	}

	@Override
	public float percentualDeUsoElevadorE() {
		float percentualE = percentualUsoElevador(quantidadeElevadores(jsonArray()).get("E"),jsonArray().size());
	    	 	
		return percentualE;
	}

}
