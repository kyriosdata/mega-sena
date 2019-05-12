package megasena.gerador;

import java.util.Arrays;

public class TodosOsNumerosEmFaixas implements Exclusao {

	public boolean exclui(int jogo, int[] dezenas) {
		Arrays.sort(dezenas);
		if (dezenas[5] <= 20 || dezenas[0] >= 41)
			return true;
		if (dezenas[5] <= 40 && dezenas[0] >= 21)
			return true;
		return false;
	}	
}
