package megasena;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 * Representa um conjunto de 6 a 15 números, cada um deles de 1 até 60,
 * inclusive.
 */
public class Aposta {
    /**
     * Total mínimo de números que podem fazer parte de uma aposta.
     */
    public static final int MINIMO_NUMEROS = 6;

    /**
     * Número máximo de números que podem fazer parte de uma aposta.
     */
    public static final int MAXIMO_NUMEROS = 15;

    /**
     * Conjunto de números que fazem parte da aposta.
     */
    private Set<Numero> numeros;

    private Aposta(final Set<Numero> jogos) {
        numeros = Collections.unmodifiableSet(jogos);
    }

    /**
     * Recupera o conjunto de números.
     *
     * @return O conjunto de números da aposta.
     */
    public Set<Numero> numeros() {
        return numeros;
    }

    /**
     * Assegura criação paulatina e correta de uma instância de Aposta.
     */
    public static class Builder {

        private Set<Numero> numeros = EnumSet.noneOf(Numero.class);

        /**
         * Adiciona um número à aposta em construção.
         * @param numero O número.
         * @return A instância do próprio "builder".
         */
        public Builder adiciona(final Numero numero) {
            if (numeros.size() == MAXIMO_NUMEROS) {
                throw new IllegalArgumentException("no máximo 15 números");
            }

            numeros.add(numero);
            return this;
        }

        /**
         * Monta a instância de Aposta com os números acrescentados.
         *
         * @return Uma instância de {@link Aposta}.
         *
         * @throws IllegalArgumentException Se a quantidade de números é
         * inválida para a composição de uma aposta.
         */
        public Aposta build() {
            if (numeros.size() < MINIMO_NUMEROS) {
                throw new IllegalArgumentException("pelo menos 6 números");
            }

            return new Aposta(numeros);
        }
    }
}
