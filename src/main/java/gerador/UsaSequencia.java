/*
 * Copyright (c) 2018.
 *
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 *
 */

package gerador;

/**
 * Toda sequência gerada pelo Gerador será processada por uma implementação de
 * UsaSequencia.
 *
 *
 */
public interface UsaSequencia {

    /**
     *
     * @param jogo
     * @param dzs
     */
    public void usaSequencia(int jogo, int[] dzs);
}
