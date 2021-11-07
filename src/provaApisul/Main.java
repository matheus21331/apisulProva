package provaApisul;

import java.text.DecimalFormat;

public class Main {
	
	public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("##.##");

		ElevadorService service = new ElevadorService();
		System.out.println("Andar ou andares menos utilizados: " + service.andarMenosUtilizado() );
		System.out.println("Elevador ou elevadores mais utilzado: " + service.elevadorMaisFrequentado() + ", e o turno que mais usou esse elevador foi: "+ service.periodoMaiorFluxoElevadorMaisFrequentado());
		System.out.println("Elevador ou elevadores menos utilzado: " + service.elevadorMenosFrequentado() + ", e o turno que menos usou esse elevador foi: "+ service.periodoMenorFluxoElevadorMenosFrequentado());
		System.out.println("Percentual elevador A: " + df.format(service.percentualDeUsoElevadorA())+"%");
		System.out.println("Percentual elevador B: " + df.format(service.percentualDeUsoElevadorB())+"%");
		System.out.println("Percentual elevador C: " + df.format(service.percentualDeUsoElevadorC())+"%");
		System.out.println("Percentual elevador D: " + df.format(service.percentualDeUsoElevadorD())+"%");
		System.out.println("Percentual elevador E: " + df.format(service.percentualDeUsoElevadorE())+"%");
		System.out.println("Turno com mais utilização dos elevadores: " + service.periodoMaiorUtilizacaoConjuntoElevadores());
	

	}
}
