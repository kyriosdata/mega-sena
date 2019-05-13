/*
 * Copyright (c) 2018.
 *
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 *
 */

package gerador;

/**
 * Toda seqüência gerada pelo Gerador será processada por uma implementação 
 * de UsaSequencia.
 *
 *
 */
public interface UsaSequencia {
    public void usaSequencia(int jogo, int[] dzs);
}
