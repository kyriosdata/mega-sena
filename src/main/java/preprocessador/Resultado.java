package preprocessador;

public class Resultado {
	public int jogo;
	public int[] dezenas = new int[6];
	public String toString() {
		String saida = "";
		for (int dez : dezenas)
			saida += String.format(" %2d",dez);
		return String.format("%3d%s", jogo);		
	}
}
