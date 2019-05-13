package preprocessador;

import java.util.List;

public class MediaTodasAsDezenas {
	public static void main(String[] args) throws Exception {
		List<megasena.preprocessador.Resultado> lista = megasena.preprocessador.MegaSenaService.montaListaResultados("/tmp/resultados.txt");
		double soma = 0d;		
		double menorMedia = Double.MAX_VALUE;
		double maiorMedia = Double.MIN_VALUE;
		
		for (megasena.preprocessador.Resultado resultado : lista) {
			double somaParcial = 0D;	
			for (int dezena : resultado.dezenas) {
				somaParcial += dezena;
			}
			menorMedia = menorMedia < somaParcial ? menorMedia : somaParcial;
			maiorMedia = maiorMedia > somaParcial ? maiorMedia : somaParcial;
			soma += somaParcial;
		}
			
		int contador = 0;
		for (megasena.preprocessador.Resultado resultado : lista) {
			int pares = 0;
			int impares = 0;
			for (int dezena : resultado.dezenas) {
				if (dezena % 2 == 0)
					pares++;
				else
					impares++;
			}
			if (pares <= 1 || pares >= 5)
				contador++;
		}
		
		System.out.println("Resultados com muitos ou poucos pares: " + contador);
		System.out.printf("Media total: %f", soma / (6.0 * lista.size()));
		System.out.printf("\nMenor media: %f", menorMedia / 6.0);
		System.out.printf("\nMaior m�dia: %f", maiorMedia / 6);
	}
}
