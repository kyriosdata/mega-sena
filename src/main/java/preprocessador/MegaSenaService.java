/*
 * Copyright (c) 2018.
 *
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 *
 */

package preprocessador;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipInputStream;

public class MegaSenaService {
	public static final String CAIXA3 = "http://www1.caixa.gov.br/loterias/_arquivos/loterias/D_megase.zip";

	public static final String CAIXA2 = "file://localhost/c:/tmp/D_megase.zip";

	public static final String CAIXA = "file://localhost/home/fabio/kyrios/tools/D_megase.zip";

	/**
	 * Obt�m resultados da caixa e os deposita no arquivo fornecido no formato txt.
	 * 
	 * @param arquivo
	 * @throws Exception
	 */
	public static void persisteResultadosEm(String arquivo) throws Exception {
		ZipInputStream zis = null;
		try {
			URL url = new URL(CAIXA3);
			zis = new ZipInputStream(url.openStream());
			zis.getNextEntry(); // Vai para D_MEGA.HTM
		} catch (IOException e) {
			e.printStackTrace();
		}

		InputStreamReader isr = new InputStreamReader(zis);
		BufferedReader br = new BufferedReader(isr);
		Pattern pattern = Pattern.compile("<td>.*?</td>");
		Matcher matcher = null;
		String linha = null;
		StringBuilder sb = new StringBuilder();
		int ncampos = 0;
		String fmt = null;
		while ((linha = br.readLine()) != null) {
			matcher = pattern.matcher(linha);
			while (matcher.find()) {
				fmt = matcher.group()
						.substring(4, matcher.group().length() - 5);
				sb.append(formataCampo(fmt, ++ncampos));
				sb.append(' ');
				if (ncampos == 16) {
					ncampos = 0;
					sb.append('\n');
				}
			}
		}

		PrintWriter pw = new PrintWriter(arquivo);
		pw.write(sb.toString());
		pw.close();
	}

	static String formataCampo(String campo, int ordem) throws Exception {
		switch (ordem) {
		case 1:
			return String.format("%4d", Integer.parseInt(campo));
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
			return campo;
		case 11:
		case 13:
		case 9:
			return String.format("%5d", Integer.parseInt(campo));
		case 12:
		case 14:
		case 16:
		case 10: {
			NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt",
					"BR"));
			Number value = nf.parse(campo);
			String valor = nf.format(value.doubleValue());
			return String.format("%15s", valor);
		}
		default:
			return campo;
		}
	}

	public static List<preprocessador.Resultado> montaListaResultados(String arquivo) throws Exception {
		List<preprocessador.Resultado> lista = new ArrayList<preprocessador.Resultado>();
		Scanner sc = new Scanner(new File(arquivo));
		preprocessador.Resultado resultado = null;
		while (sc.hasNext()) {
			resultado = new preprocessador.Resultado();
			resultado.jogo = Integer.parseInt(sc.next());
			sc.next();
			resultado.dezenas[0] = Integer.parseInt(sc.next());
			resultado.dezenas[1] = Integer.parseInt(sc.next());
			resultado.dezenas[2] = Integer.parseInt(sc.next());
			resultado.dezenas[3] = Integer.parseInt(sc.next());
			resultado.dezenas[4] = Integer.parseInt(sc.next());
			resultado.dezenas[5] = Integer.parseInt(sc.next());
			for (int i = 0; i < 8; i++) sc.next();
			lista.add(resultado);
		}
		return lista;
	}
	
	static void acrescentaValor(Map<Integer,Integer> mapa, Integer key) {
		Integer valor = mapa.get(key);
		if (valor == null) {
			mapa.put(key, 1);
		} else {
			mapa.put(key, valor + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		List<preprocessador.Resultado> lista = montaListaResultados("/tmp/resultados.txt");
		System.out.println(lista.size());
		Map<Integer,Integer> mapa = new HashMap<Integer,Integer>();
		for (preprocessador.Resultado r : lista) {
			acrescentaValor(mapa, r.dezenas[0]);
			acrescentaValor(mapa, r.dezenas[1]);
			acrescentaValor(mapa, r.dezenas[2]);
			acrescentaValor(mapa, r.dezenas[3]);
			acrescentaValor(mapa, r.dezenas[4]);
			acrescentaValor(mapa, r.dezenas[5]);
		}
		
		Set<Integer> dezenas = new TreeSet<Integer>(mapa.keySet());		
		Map<Integer,Set<Integer>> m = new TreeMap<Integer,Set<Integer>>();

		for (Integer dezena : dezenas) {
			Set<Integer> set = m.get(mapa.get(dezena));
			if (set == null) {
				set = new HashSet<Integer>();				
			}
			set.add(dezena);
			m.put(mapa.get(dezena), set);
		}
		
		for (Integer ocorrencia : m.keySet())
			System.out.println(ocorrencia + " " + m.get(ocorrencia));
	}
}