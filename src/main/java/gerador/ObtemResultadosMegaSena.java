/*
 * Copyright (c) 2018.
 *
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 *
 */

package gerador;

import java.io.IOException;
import java.net.URL;
import java.util.zip.ZipInputStream;
import megasenautils.CaixaEconomica;

public class ObtemResultadosMegaSena {
	
	public static ZipInputStream zipInputStream(String url) throws IOException {
		URL refUrl = new URL(url);
		return new ZipInputStream(refUrl.openStream());
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(zipInputStream(CaixaEconomica.MEGA_SENA) != null ? "OK" : "ERRO");
	}
}