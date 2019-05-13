/*
 * Copyright (c) 2018.
 *
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 *
 */

package gerador;

public class MuitosImparesOuPares implements Exclusao {
	public boolean exclui(int jogo, int[] dezenas) {
		int pares = 0;
		for (int dezena : dezenas) {
			if (dezena % 2 == 0)
				pares++;
		}
		if (pares <= 1 || pares >= 5)
			return true;
		
		return false;
	}
}
