/*
 * Copyright (c) 2018.
 *
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 *
 */

package gerador;

import java.util.Arrays;

public class TodosOsNumerosEmFaixas implements Exclusao {

	/**
	 * O método verifica se as dezenas de um jogo estão todas em um mesmo intervalo:
	 * de 1 ao 20, de 21 ao 40 ou de 41 ao 60.
	 *
	 * @param jogo Jogo que terá suas dezenas analisadas.
	 * @param dezenas Vetor com as dezenas do jogo que serão analisadas.
	 *
	 * @return Verdadeiro caso as dezenas estejam todas em um mesmo intervalo, falso caso
	 * não estejam.
	 */

	public boolean exclui(int jogo, int[] dezenas) {
		Arrays.sort(dezenas);
		if (dezenas[5] <= 20 || dezenas[0] >= 41)
			return true;
		if (dezenas[5] <= 40 && dezenas[0] >= 21)
			return true;
		return false;
	}	
}
