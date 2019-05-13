package megasena.gerador;


import java.util.Arrays;

/**
 * Elimina jogo onde h� pelo menos tr�s diferen�as entre
 * dezenas consecutivas cujos valores s�o iguais.
 * 
 * @author F�bio Nogueira de Lucena
 */
public class SerieAritmetica implements megasena.gerador.Exclusao {
	byte[] diferencas = null;
	
	public SerieAritmetica() {
		diferencas = new byte[60];
	}

	public boolean exclui(int jogo, int[] dezenas) {
		Arrays.fill(diferencas, (byte) 0);

		diferencas[dezenas[1] - dezenas[0]]++;
		diferencas[dezenas[2] - dezenas[1]]++;
		diferencas[dezenas[3] - dezenas[2]]++;
		diferencas[dezenas[4] - dezenas[3]]++;
		diferencas[dezenas[5] - dezenas[4]]++;

		for (int i = 0; i < diferencas.length; i++) {
			if (diferencas[i] > 2) {
				return true;
			}
		}
		return false;
	}
}