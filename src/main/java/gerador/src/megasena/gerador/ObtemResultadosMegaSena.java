package megasena.gerador;

import java.io.IOException;
import java.net.URL;
import java.util.zip.ZipInputStream;

public class ObtemResultadosMegaSena {
	final static String URL = "http://www1.caixa.gov" +
			".br/loterias/_arquivos/loterias/D_megase.zip";
	
	public static ZipInputStream zipInputStream(String url) throws IOException {
		URL refUrl = new URL(url);
		return new ZipInputStream(refUrl.openStream());
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(zipInputStream(URL) != null ? "OK" : "ERRO");
	}
}