/*
 * Copyright (c) 2018.
 *
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 *
 */

package gerador;


import java.util.Arrays;

/**
 * Elimina jogo onde há pelo menos três diferenças entre
 * dezenas consecutivas cujos valores são iguais.
 * 
 * @author Fábio Nogueira de Lucena
 */
public class SerieAritmetica implements Exclusao {
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