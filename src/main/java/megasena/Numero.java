package megasena;

/**
 * Representa um número que pode fazer parte de uma aposta.
 */
public enum Numero {

    N1(1),
    N2(2),
    N3(3),
    N4(4),
    N5(5),
    N6(6),
    N7(7),
    N8(8),
    N9(9),
    N10(10),
    N11(11),
    N12(12),
    N13(13),
    N14(14),
    N15(15),
    N16(16),
    N17(17),
    N18(18),
    N19(19),
    N20(20),
    N21(21),
    N22(22),
    N23(23),
    N24(24),
    N25(25),
    N26(26),
    N27(27),
    N28(28),
    N29(29),
    N30(30),
    N31(31),
    N32(32),
    N33(33),
    N34(34),
    N35(35),
    N36(36),
    N37(37),
    N38(38),
    N39(39),
    N40(40),
    N41(41),
    N42(42),
    N43(43),
    N44(44),
    N45(45),
    N46(46),
    N47(47),
    N48(48),
    N49(49),
    N50(50),
    N51(51),
    N52(52),
    N53(53),
    N54(54),
    N55(55),
    N56(56),
    N57(57),
    N58(58),
    N59(59),
    N60(60);

    /**
     * Um jogo, ou seja, um número de 1 até 60, inclusive.
     */
    private int jogo;

    Numero(final int numero) {
        jogo = numero;
    }

    /**
     * Recupera o número do jogo.
     *
     * @return O número.
     */
    public int numero() {
        return jogo;
    }
}
