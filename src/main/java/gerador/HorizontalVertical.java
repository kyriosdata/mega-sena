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
 * Identifica jogo onde há pelo menos quatro dezenas em uma horizontal ou pelo
 * menos quatro dezenas na vertical. Por exemplo, um jogo com os valores 1, 2, 4
 * e 9 será excluído, pois estas quatro dezenas estão na mesma linha horizontal.
 * A noção de horizontal e vertical é baseada na distribuição dos números na cartela.
 * 
 * @author Fábio Nogueira de Lucena
 */
public class HorizontalVertical implements Exclusao {
    int[] contador = new int[10];
    /**
     * Método que recebe como parâmetro uma dezena e retorna o valor horizontal.
     * 
     * @param dezena Dezena recebida para obter valor horizontal.
     * 
     * @return Retorna valor horizontal.
     */
    public int getValorHorizontal(int dezena) {
        if (dezena % 10 == 0) {
            return dezena / 10 - 1;
        } else {
            return (dezena - (dezena % 10)) / 10;
        }
    }

    /**
     * Método que analisa as dezenas de um jogo, confere se possui mais de quatro
     * dezenas na horizontal ou vertical, e se possuir, o jogo será excluído.
     * 
     * @param jogo Jogo que será analisado.
     * @param dezenas Dezenas do jogo que serão avaliadas.
     * 
     * @return Retorna {@code true} caso o jogo deva ser excluído,
     * e retorna {@code false} caso o jogo não deva ser excluído.
     */
    public boolean exclui(int jogo, int[] dezenas) {
        
        // Analisa vertical
        Arrays.fill(contador, 0);
        contador[dezenas[0] % 10]++;
        contador[dezenas[1] % 10]++;
        contador[dezenas[2] % 10]++;
        contador[dezenas[3] % 10]++;
        contador[dezenas[4] % 10]++;
        contador[dezenas[5] % 10]++;

        for (int i = 0; i < 10; i++) {
            if (contador[i] > 3) {
                return true;
            }
        }

        // Analisa horizontal (linhas da cartela)
        Arrays.fill(contador, 0);
        
        contador[getValorHorizontal(dezenas[0])]++;
        contador[getValorHorizontal(dezenas[1])]++;
        contador[getValorHorizontal(dezenas[2])]++;
        contador[getValorHorizontal(dezenas[3])]++;
        contador[getValorHorizontal(dezenas[4])]++;
        contador[getValorHorizontal(dezenas[5])]++;

        for (int i = 0; i < 6; i++) {
            if (contador[i] > 3) {
                return true;
            }
        }
        
        return false;
    }
}