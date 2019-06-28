/*
 * Copyright (c) 2018.
 *
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 *
 */

package megasenautils;

/**
 * Possui forte dependência para o formato do arquivo HTML, inclusive ordem dos
 * elementos fornecidos no arquivo .zip.
 *
 * TODO Isolar processamento de linha (além de jogo)
 * TODO Separar aplicação (interface com o usuário) dos serviços.
 *
 * @author X
 * @version 0.1
 */
public class InterfaceUsuario {

    public static void main(String[] args) {
        if (args.length != 0) {
            CaixaEconomica.MEGA_SENA = args[0];
        }

        int retorno = NetUtils.percorreUrl(CaixaEconomica.MEGA_SENA);
        if (retorno == 1) {
            System.out.println("URL invalida. Verifique o formato...");
        } else if (retorno == 2) {
            System.out.println("Verifique conexao com a internet e tente no...");
        } else if (retorno == 3) {
            System.out.println("Codigo de erro: 3. Fale com o administrador.");
        } else {
            System.out.println("OK. Legal, funcionou!!!!!");
        }
    }
}
