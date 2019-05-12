package megasena.gerador;

import java.net.URL;
import java.util.zip.ZipInputStream;

public class ObtemResultadosMegaSena {
	final String url = "http://www1.caixa.gov.br/loterias/_arquivos/loterias/D_megase.zip";
	
	public static ZipInputStream zipInputStream() {
		URL refUrl = new URL(url);
		return refUrl.openStream();		
	}
	
	public static void main(String[] args) {
		System.out.println(zipInputStream() != null ? "OK" : "ERRO");
	}
}