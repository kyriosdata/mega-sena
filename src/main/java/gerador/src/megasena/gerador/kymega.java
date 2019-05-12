package megasena.gerador;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipInputStream;

/**
 * Obtém resultados da mega sena de CAIXA (constante) e gera arquivo
 * resultados.ser, contendo uma lista serializada dos resultados.
 * 
 * @author fabio
 * 
 */
public class kymega {
	public static final String CAIXA3 = "http://www1.caixa.gov.br/loterias/_arquivos/loterias/D_megase.zip";

	public static final String CAIXA2 = "file://localhost/c:/tmp/D_megase.zip";

	public static final String CAIXA = "file://localhost/home/fabio/kyrios/tools/D_megase.zip";

	public static String getResultadosComoString() {
		ZipInputStream zis = null;
		try {
			URL url = new URL(CAIXA3);
			zis = new ZipInputStream(url.openStream());
			zis.getNextEntry(); // Vai para D_MEGA.HTM
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedInputStream bis = new BufferedInputStream(zis);
		StringBuilder sb = new StringBuilder();
		byte[] entrada = new byte[1024];

		try {
			int nbytes = -1;
			while ((nbytes = bis.read(entrada, 0, 1024)) != -1) {
				sb.append(new String(entrada, 0, nbytes));
			}
			zis.close();
			bis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

	public static void main(String... args) {
		eliminadores.add(new NumerosFormamSerieAritmetica());
		eliminadores.add(new DezenasEmMetadeSuperiorOuInferior());
		eliminadores.add(new FinaisEmMetadeSuperiorOuInferior());
		eliminadores.add(new TodasDezenasParesOuImpares());
		eliminadores.add(new PeloMenos5DezenasEmUnicaLinha());
		eliminadores.add(new PeloMenos4DezenasEmUnicaColuna());
		eliminadores.add(new TodasDezenasEmMenosDe3Colunas());

		int total = 0;
		for (int d1 = 1; d1 <= 55; d1++) {
			System.out.print('.');
			for (int d2 = d1 + 1; d2 <= 56; d2++) {
				for (int d3 = d2 + 1; d3 <= 57; d3++) {
					for (int d4 = d3 + 1; d4 <= 58; d4++) {
						for (int d5 = d4 + 1; d5 <= 59; d5++) {
							for (int d6 = d5 + 1; d6 <= 60; d6++) {
								if (!excluiDezenas(d1, d2, d3, d4, d5, d6)) {
									total++;
								} else {
									// System.out.println(d1 + " " + d2 + " " +
									// d3
									// + " " + d4 + " " + d5 + " " + d6);
								}
							}
						}
					}
				}
			}
		}
		System.out.println(total);
	}

	private static List<Eliminador> eliminadores = new ArrayList<Eliminador>();

	public static boolean excluiDezenas(int d1, int d2, int d3, int d4, int d5,
			int d6) {
		for (Eliminador ex : eliminadores) {
			if (ex.exclui(d1, d2, d3, d4, d5, d6)) {
				return true;
			}
		}
		return false;
	}

	public static void main2(String... args) {
		if (args.length < 1) {
			System.out.println("Copyright (c) 2006 Kyriosdata");
		}

		String dados = getResultadosComoString();
		List<ResultadoMegaSena> lista = obtemResultadosDeString(dados);
		for (ResultadoMegaSena r : lista)
			System.out.println(r);

		serialize(lista, "resultados.ser");
	}

	public static boolean serialize(Object obj, String arquivo) {
		File f = new File(arquivo);
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public static List<ResultadoMegaSena> obtemResultadosDeString(String dados) {
		Pattern p = Pattern.compile("<td>.*?</td>");
		Matcher m = p.matcher(dados);
		ResultadoMegaSena r;
		List<ResultadoMegaSena> lista = new ArrayList<ResultadoMegaSena>();

		while (m.find()) {

			r = new ResultadoMegaSena();

			// Concurso
			r.setConcurso(getMatch(m));

			// Data
			m.find();
			r.setData(getMatch(m));

			// Dezenas
			m.find();
			r.setDezena(getMatch(m), 1);
			m.find();
			r.setDezena(getMatch(m), 2);
			m.find();
			r.setDezena(getMatch(m), 3);
			m.find();
			r.setDezena(getMatch(m), 4);
			m.find();
			r.setDezena(getMatch(m), 5);
			m.find();
			r.setDezena(getMatch(m), 6);

			// Ganhadores/rateio sena
			m.find();
			r.setGanhadoresSena(getMatch(m));
			m.find();
			r.setRateioSena(getMatch(m));

			// Ganhadores/rateio quina
			m.find();
			r.setGanhadoresQuina(getMatch(m));
			m.find();
			r.setRateioQuina(getMatch(m));

			// Ganhadores/rateio quadra
			m.find();
			r.setGanhadoresQuadra(getMatch(m));
			m.find();
			r.setRateioQuadra(getMatch(m));

			// Acumulado/valor acumulado
			m.find();
			r.setAcumulado(getMatch(m));
			m.find();
			r.setValorAcumulado(getMatch(m));

			lista.add(r);
		}

		return lista;
	}

	private static String getMatch(Matcher m) {
		String retorno = m.group();
		return retorno.substring(4, retorno.length() - 5);
	}
}

/**
 * Interface a ser implementada por qualquer algoritmo de exclusão de jogo.
 */
interface Eliminador {
	boolean exclui(int d1, int d2, int d3, int d4, int d5, int d6);
}

/**
 * Exclui dezenas onde todas formam uma série aritmética. Ou seja, a diferença
 * entre dezenas consecutivas é uma constante.
 */
class NumerosFormamSerieAritmetica implements Eliminador {

	public boolean exclui(int d1, int d2, int d3, int d4, int d5, int d6) {
		int razao = d2 - d1;
		if ((d3 - d2) != razao)
			return false;
		if ((d4 - d3) != razao)
			return false;
		if ((d5 - d4) != razao)
			return false;
		if ((d6 - d5) != razao)
			return false;
		return true;
	}
}

/**
 * Todas as dezenas são menores que 31 ou todas são maiores que 30. Ou seja,
 * tudo na "metade posterior" ou tudo na "metade inferior".
 */
class DezenasEmMetadeSuperiorOuInferior implements Eliminador {
	public boolean exclui(int d1, int d2, int d3, int d4, int d5, int d6) {
		if (d6 <= 30 || d1 >= 31) {
			return true;
		} else {
			return false;
		}
	}
}

class FinaisEmMetadeSuperiorOuInferior implements Eliminador {

	public boolean exclui(int d1, int d2, int d3, int d4, int d5, int d6) {
		if ((d1 % 10 < 5) && (d2 % 10 < 5) && (d3 % 10 < 5) && (d4 % 10 < 5)
				&& (d5 % 10 < 5) && (d6 % 10 < 5))
			return true;
		else {
			if ((d1 % 10 > 4) && (d2 % 10 > 4) && (d3 % 10 > 4)
					&& (d4 % 10 > 4) && (d5 % 10 > 4) && (d6 % 10 > 4)) {
				return true;
			}
		}
		return false;
	}
}

class TodasDezenasParesOuImpares implements Eliminador {

	public boolean exclui(int d1, int d2, int d3, int d4, int d5, int d6) {
		if ((d1 % 2 == 0) && (d2 % 2 == 0) && (d3 % 2 == 0) && (d4 % 2 == 0)
				&& (d5 % 2 == 0) && (d6 % 2 == 0))
			return true;
		else {
			if ((d1 % 2 == 1) && (d2 % 2 == 1) && (d3 % 2 == 1)
					&& (d4 % 2 == 1) && (d5 % 2 == 1) && (d6 % 2 == 1)) {
				return true;
			}
		}
		return false;
	}
}

class PeloMenos5DezenasEmUnicaLinha implements Eliminador {
	public int linha(int dezena) {
		if (dezena % 10 == 0)
			dezena--;
		return dezena / 10;
	}

	public boolean exclui(int d1, int d2, int d3, int d4, int d5, int d6) {
		if ((linha(d1) == linha(d5)) || (linha(d2) == linha(d6)))
			return true;
		else
			return false;
	}
}

class PeloMenos4DezenasEmUnicaColuna implements Eliminador {

	public boolean exclui(int d1, int d2, int d3, int d4, int d5, int d6) {
		int colunas[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		colunas[d1 % 10]++;
		colunas[d2 % 10]++;
		colunas[d3 % 10]++;
		colunas[d4 % 10]++;
		colunas[d5 % 10]++;
		colunas[d6 % 10]++;
		
		for (int total : colunas) {
			if (total > 3)
				return true;
		}
		return false;
	}
}

class TodasDezenasEmMenosDe3Colunas implements Eliminador {

	public boolean exclui(int d1, int d2, int d3, int d4, int d5, int d6) {
		int colunas[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		colunas[d1 % 10]++;
		colunas[d2 % 10]++;
		colunas[d3 % 10]++;
		colunas[d4 % 10]++;
		colunas[d5 % 10]++;
		colunas[d6 % 10]++;
		
		int totaisPorColuna[] = { 0, 0, 0, 0, 0, 0, 0 };
		for (int total : colunas) {
			totaisPorColuna[total]++;
		}
		
		if (totaisPorColuna[0] >= 8)
			return true;
		else
			return false;
	}
}