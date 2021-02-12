/*
 * Copyright (c) 2018.
 *
 * Fabio Nogueira de Lucena
 * Fabrica de Software - Instituto de Informatica (UFG)
 *
 */

package gerador;
/**
 * Identifica se o jogo tem muitos pares ou impares, para saber se deve
 * ser eliminado ou nao.
*/
public class MuitosImparesOuPares implements Exclusao {
    /**
     * Descobre se o jogo deve ser eliminado/desqualificado
     * @param jogo O jogo de megasena a ser identificado
     * @param dezenas As dezenas do jogo onde serao identificado os pares
     * @return Retorna verdadeiro se o jogo tiver muitos impares ou muitos pares,
     * ou seja, se tem >= 5 pares ou impares, ou falso se não satisfazer isso.
    */
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
