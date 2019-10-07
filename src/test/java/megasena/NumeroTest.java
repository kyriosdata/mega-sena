package megasena;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumeroTest {

    @Test
    void recuperaCorretamente() {
        assertEquals(1, Numero.N1.numero());
    }
}
