package megasenautils;

/**
 * Classe referente a centralização de informações referentes ao sorteio da mega-sena da caixa
 * economica.
 * 
 * @author danielfreitasbs
 *
 */
public class CaixaEconomica {
  /**
   * URL Padrão onde está hospedado o arquivo '.zip' que contem todos os resultados da mega-sena.
   */
  public static String MEGA_SENA =
      "http://www1.caixa.gov" + ".br/loterias/_arquivos/loterias/D_megase.zip";

  /**
   * URL padrão do arquivo '.zip' hospedado localmente em pasta temporaria.
   */
  public static String MEGA_SENA_TEMP = "file://localhost/c:/tmp/D_megase.zip";

  /**
   * URL padrão do arquivo '.zip' hospedado localmente em pasta tools, de utilidades do projeto.
   */
  public static String MEGA_SENA_LOCAL = "file://localhost/home/fabio/kyrios/tools/D_megase.zip";
}
