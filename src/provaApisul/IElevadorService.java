package provaApisul;

import java.util.List;

import org.json.simple.JSONArray;


public interface IElevadorService {
	/** Deve retornar uma List contendo o(s) andar(es) menos utilizado(s). */
	List<Integer> andarMenosUtilizado();
	
	/** Deve retornar uma List contendo o(s) elevador(es) mais frequentado(s). */
	List<Character> elevadorMaisFrequentado();
	
	/** Deve retornar uma List contendo o per�odo de maior fluxo de cada um dos elevadores mais frequentados (se houver mais de um). */
	List<Character> periodoMaiorFluxoElevadorMaisFrequentado();
	
	/** Deve retornar uma List contendo o(s) elevador(es) menos frequentado(s). */
	List<Character> elevadorMenosFrequentado();
	
	/** Deve retornar uma List contendo o per�odo de menor fluxo de cada um dos elevadores menos frequentados (se houver mais de um). */
	List<Character> periodoMenorFluxoElevadorMenosFrequentado();
	
	/** Deve retornar uma List contendo o(s) periodo(s) de maior utiliza��o do conjunto de elevadores. */
	List<Character> periodoMaiorUtilizacaoConjuntoElevadores();
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador A em rela��o a todos os servi�os prestados. */
	float percentualDeUsoElevadorA();
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador B em rela��o a todos os servi�os prestados. */
	float percentualDeUsoElevadorB();
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador C em rela��o a todos os servi�os prestados. */
	float percentualDeUsoElevadorC();
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador D em rela��o a todos os servi�os prestados. */
	float percentualDeUsoElevadorD();
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador E em rela��o a todos os servi�os prestados. */
	float percentualDeUsoElevadorE();
}
