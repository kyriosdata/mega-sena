package megasena;

import org.junit.jupiter.api.Test;

import static megasena.Numero.N1;
import static megasena.Numero.N10;
import static megasena.Numero.N11;
import static megasena.Numero.N12;
import static megasena.Numero.N13;
import static megasena.Numero.N14;
import static megasena.Numero.N15;
import static megasena.Numero.N16;
import static megasena.Numero.N2;
import static megasena.Numero.N20;
import static megasena.Numero.N3;
import static megasena.Numero.N4;
import static megasena.Numero.N5;
import static megasena.Numero.N6;
import static megasena.Numero.N7;
import static megasena.Numero.N8;
import static megasena.Numero.N9;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApostaTest {

    @Test
    void peloMenosSeisNumeros() {
        Aposta.Builder builder = new Aposta.Builder();

        // Acrescenta apenas 5
        builder.adiciona(N2);
        builder.adiciona(N3);
        builder.adiciona(N4);
        builder.adiciona(N5);
        builder.adiciona(N6);

        assertThrows(IllegalArgumentException.class, builder::build);
    }

    @Test
    void naoPodeExcederLimiteDeQuinzeNumeros() {
        Aposta.Builder builder = new Aposta.Builder();

        // Acrescenta 15
        builder.adiciona(N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12);
        builder.adiciona(N13, N14, N15, N16);

        // Não pode acrescentar mais número.
        assertThrows(IllegalArgumentException.class,
                () -> builder.adiciona(N1));
    }

    @Test
    void montagemCorreta() {
        Aposta.Builder builder = new Aposta.Builder();
        Aposta aposta = builder.adiciona(N1, N2, N3, N4, N5, N6).build();

        assertTrue(aposta.contem(N4));
        assertFalse(aposta.contem(N20));
    }
}
