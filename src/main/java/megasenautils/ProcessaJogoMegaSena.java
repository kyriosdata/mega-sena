package megasenautils;

/**
 *
 * @author kyrios
 */
public class ProcessaJogoMegaSena {
    private static int totalGeral = 0;
    private static int totalJogos = 0;

    public static void mediaSimples(short[] array) {
        int soma = somaDezenas(array);
        System.out.printf("%04d Media: %.2f\n", array[0], soma / 6.0);
    }

    public static void mediaTotal(short[] array) {
       totalGeral += somaDezenas(array);
       System.out.println("Media total: " + (totalGeral / 6.0));
    }

    private static int somaDezenas(short[] array) {
        int soma = 0;
        for (int i = 1; i < array.length; i++) {
            soma += array[i];
        }
        return soma;
    }
}
