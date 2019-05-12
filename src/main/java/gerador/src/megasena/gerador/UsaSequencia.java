package megasena.gerador;

/**
 * Toda seqüência gerada pelo Gerador será processada por uma implementação 
 * de UsaSequencia.
 * 
 * @author lucena
 *
 */
public interface UsaSequencia {
    public void usaSequencia(int jogo, int[] dzs);
}
