/*
 * Copyright (c) 2018.
 *
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 *
 */

package megasena;

import java.net.*;
import java.io.*;

public class URLReader {
	private static final String URL_MS = "http://www1.caixa.gov.br" + "/loterias/_arquivos/loterias/" + "D_megase.zip";

	public static void main(String[] args) throws Exception {

		CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
		URL yahoo = new URL(URL_MS);
		BufferedInputStream bis = new BufferedInputStream(yahoo.openStream());

		FileOutputStream fos = new FileOutputStream("saida.dat");
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		int rawByte = -1;

		while ((rawByte = bis.read()) != -1) {
			bos.write(rawByte);
		}

		bos.flush();
		fos.close();
		bis.close();
		bos.close();
	}
}
