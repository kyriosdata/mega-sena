package gerador;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * SOLUÇÃO:
 *
 * (1) Este gerador gera todos os resultados possíveis da megasena e os armazena
 *     em arquivo para consulta posterior.
 *
 * (2) Gerar programas para excluir dos resultados possíveis (gerados no passo
 *     anterior) aqueles que atendem a algum critério de exclusão. A execução de
 *     cada programa deverá dar origem a um arquivo menor, resultante daquele de
 *     entrada menos os resultados que passaram nos critérios para exclusão.
 *
 * (3) Lista de critérios de seleção:
 *     - Muitas dezenas na mesma coluna ou linha
 *     - Há pelo menos três dezenas formando série aritmética
 *     - Há muitos pares ou ímpares
 *
 */
public class Gerador {
	int jogo = 0; // indica jogo gerado (numerados a partir de 1)

	UsaSequencia us = null;

	int szSeq = 0;

	int szDom = 0;

	int[] v = null;

	// Protege array v através de uma cópia
	// A cópia é visível externamente
	int[] copiaV = null;

	/**
	 * Cria gerador padrão. Embora todas as seqüências sejam geradas, nenhuma
	 * operação é estabelecida para cada seqüência.
	 *
	 * @param szSeq
	 * @param szDom
	 */
	public Gerador(int szSeq, int szDom) {
		this(new UsaSequencia() {
			public void usaSequencia(int jogo, int[] dzs) {
			};
		}, szSeq, szDom);
	}

	/**
	 * Cria gerador com sequência definida.
	 *
	 * @param us sequência
	 * @param szSeq
	 * @param szDom
	 */
	public Gerador(UsaSequencia us, int szSeq, int szDom) {
		super();
		this.us = us;
		this.szSeq = szSeq;
		this.szDom = szDom;
		v = new int[szSeq + 1];
		v[0] = 0;

		copiaV = new int[szSeq];
	}

	/**
	 * Faz uma cópia do array v para o array copiaV, que é externamente visível.
	 *
	 * @return copiaV
	 */
	private int[] copiaSequencia() {
		System.arraycopy(v, 1, copiaV, 0, copiaV.length);
		return copiaV;
	}

	/**
	 * Utiliza o método privado gera para gerar um jogo.
	 */
	public void gerador() {
		gera(1);
	}

	/**
	 * Gera um jogo.
	 *
	 * @param k número do jogo gerado
	 */
	private void gera(int k) {
		for (v[k] = v[k - 1] + 1; v[k] <= szDom; v[k]++) {
			if (k == szSeq) {
				us.usaSequencia(++jogo, copiaSequencia());
			} else {
				gera(k + 1);
			}
		}
		v[k]--;
	}

	/**
	 * Gera um jogo.
	 *
	 * @param k número do jogo gerado
	 * @param i
	 * @param f
	 */
	private void repita(int k, int i, int f) {
		// Versão alternativa para gera que não foi testada
		// Talvez seja mais legível que a anterior, embora
		// faça uso de mais memória.
		if (k == 16) {
			us.usaSequencia(++jogo, copiaSequencia());
		} else {
			for (int j = i; j <= f; j++) {
				v[k] = j;
				repita(k + 1, j + 1, f);
			}
		}
	}

	/**
	 * Gera identificador único para a dezena. Este identificador é
	 * suficiente para gerar a sequência de dezenas de tal forma que
	 * ou o identificador ou a sequência é suficiente para identificar
	 * seis dezenas.
	 *
	 * @param dzns dezena
	 * @return identificador único para a dezena
	 */
	public static int dezenas56ParaNumero(int[] dzns) {
		// Cálculo abaixo gera para jogos no formato (1,2,3,4,d5,d6)
		// o número correspondente do jogo para d5 e d6 válidos.
		// Precisa expandir para considerar d4 e assim sucessivamente.
		// Valor limite é 1540.
		int d5 = dzns[4];
		int d6 = dzns[5];

		int n = d5 - 5;
		int p = n > 0 ? ((109 - n) * n) / 2 + n : 0;
		return p + d6 - d5;
	}

	/**
	 * Método main que faz a execução do metódo gerador.
	 *
	 * @param args não utilizado
	 */
	public static void main(String[] args) {

		// Exibe todos os jogos possíveis da megasena
		UsaSequencia us = new UsaSequencia() {
			private PrintWriter pw;

			{
				try {
					pw = new PrintWriter("/tmp/jogos.txt");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}

			public void usaSequencia(int jogo, int[] dzs) {
				String dzns = String.format("%02d %02d %02d %02d %02d %02d", dzs[0], dzs[1], dzs[2],dzs[3], dzs[4], dzs[5]);
				pw.printf("%08d %s\n", jogo, dzns);
			}
		};

		// Contador contador = new Contador();
		new Gerador(us, 6, 60).gerador();
	}
}