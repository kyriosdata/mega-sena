package megasena;

import megasena.ProcessaMegaSenaHTML;

// TODO: Criar classe que implementa IProcessaSorteio
// TODO: Acrescentar servicos de leitura de resultados.
// TODO: Integrar descompressao do arquivo.

/**
 * Esta classe tem como finalidade ilustrar o emprego de
 * ProcessaMegaSenaHTML, que tem por objetivo processar uma arquivo
 * HTML fornecido pela CEF contendo resultados da Mega Sena. Cada
 * resultado (sorteio) é depositado em uma instáncia da classe Sorteio
 * e exibido na saída padrão.
 *
 * @author Administrator e
 * <a href="https://github.com/newtonjose">newtonjose</a>
 * @version 1.1
 */
public class MegaSena implements IProcessaSorteio {
    /**
     * Método que implementa o processamento de um sorteiro de forma
     * inteligente.
     * @param s Tipo megasena.Sorteio.
     */
    public void processaSorteio(megasena.Sorteio s) {
        System.out.println(s);
    }

    /**
     * Método main implementa a instanciação das classes MegaSena e
     * ProcessaMegaSenaHTML e o HTML da página MegaSena.
     * @param args Array de parâmetros do tipo String.
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        MegaSena ms = new MegaSena();
        ProcessaMegaSenaHTML pms = new ProcessaMegaSenaHTML();
        pms.processaHTML(args[0],ms);
    }
}
