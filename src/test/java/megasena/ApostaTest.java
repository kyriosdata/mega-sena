package megasena;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ApostaTest {

    @Test
    void peloMenosSeisNumeros() {
        Aposta.Builder builder = new Aposta.Builder();

        // Acrescenta apenas 5
        builder.adiciona(Numero.N2);
        builder.adiciona(Numero.N3);
        builder.adiciona(Numero.N4);
        builder.adiciona(Numero.N5);
        builder.adiciona(Numero.N6);

        assertThrows(IllegalArgumentException.class, () -> builder.build());
    }

    @Test
    void naoPodeExcederLimiteDeQuinzeNumeros() {
        Aposta.Builder builder = new Aposta.Builder();

        // Acrescenta 15
        builder.adiciona(Numero.N2);
        builder.adiciona(Numero.N3);
        builder.adiciona(Numero.N4);
        builder.adiciona(Numero.N5);
        builder.adiciona(Numero.N6);
        builder.adiciona(Numero.N7);
        builder.adiciona(Numero.N8);
        builder.adiciona(Numero.N9);
        builder.adiciona(Numero.N10);
        builder.adiciona(Numero.N11);
        builder.adiciona(Numero.N12);
        builder.adiciona(Numero.N13);
        builder.adiciona(Numero.N14);
        builder.adiciona(Numero.N15);
        builder.adiciona(Numero.N16);

        // Não pode acrescentar mais número.
        assertThrows(IllegalArgumentException.class,
                () -> builder.adiciona(Numero.N1));
    }

    @Test
    void montagemCorreta() {
        Aposta.Builder builder = new Aposta.Builder();

    }
}
