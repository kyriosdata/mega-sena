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

    static final String SRV = "http://www1.caixa.gov.br";
    static String endereco = SRV + "/loterias/_arquivos/loterias/D_megase.zip";

    public static void main(String[] args) {
        if (args.length != 0) {
            endereco = args[0];
        }

        int retorno = NetUtils.percorreUrl(endereco);
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
