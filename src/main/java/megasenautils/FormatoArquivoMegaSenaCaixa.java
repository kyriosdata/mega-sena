/*
 * Copyright (c) 2018.
 *
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 *
 */

package megasenautils;

/**
 *
 * @author kyrios
 */
public class FormatoArquivoMegaSenaCaixa {

    static short[] jogo = new short[7];
    static int campos = 0;

    public static void processaLinha(String linha) {
        if (!linha.startsWith("<td>")) {
            return;
        }

        if (++campos == 19) {
            campos = 0;
            return;
        }
        if (campos == 2 || campos > 8) {
            return;
        }

        jogo[campos > 2 ? campos - 2 : campos - 1] = getValue(linha);
        if (campos == 8) {
            ProcessaJogoMegaSena.mediaSimples(jogo);
            ProcessaJogoMegaSena.mediaTotal(jogo);
        }
    }

    public static Short getValue(String linha) {
        return Short.parseShort(linha.substring(4, linha.indexOf("</td>")));
    }
}
