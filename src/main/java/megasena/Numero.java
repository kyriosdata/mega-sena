package megasena;

/**
 * Representa um número que pode fazer parte de uma aposta.
 */
public enum Numero {

    N1(1),
    N2(2),
    N3(3);

    /**
     * Um jogo, ou seja, um número de 1 até 60, inclusive.
     */
    private int jogo;

    Numero(final int numero) {
        jogo = numero;
    }

    /**
     * Recupera o número do jogo.
     *
     * @return O número.
     */
    public int numero() {
        return jogo;
    }
}
