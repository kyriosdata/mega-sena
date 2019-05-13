/*
 * Copyright (c) 2018.
 *
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 *
 */

package megasena;

import megasena.ProcessaMegaSenaHTML;

// TODO: Criar classe que implementa IProcessaSorteio
// TODO: Acrescentar servicos de leitura de resultados.
// TODO: Integrar descompressao do arquivo.

/** Esta classe tem como finalidade ilustrar o emprego de 
 * ProcessaMegaSenaHTML, que tem por objetivo processar uma arquivo
 * HTML fornecido pela CEF contendo resultados da Mega Sena. Cada
 * resultado (sorteio) � depositado em uma inst�ncia da classe Sorteio
 * e exibido na sa�da padr�o. 
 * 
 * @author Administrator
 * 
 */
public class MegaSena implements IProcessaSorteio {
    
    public void processaSorteio(megasena.Sorteio s) {
        System.out.println(s);
    }
    
    public static void main(String[] args) throws Exception {
        MegaSena ms = new MegaSena();
        ProcessaMegaSenaHTML pms = new ProcessaMegaSenaHTML();
        pms.processaHTML(args[0],ms);
    }
}
