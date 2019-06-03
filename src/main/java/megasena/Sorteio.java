/*
 * Copyright (c) 2018.
 *
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 *
 */

package megasena;

import java.text.DecimalFormat;
import java.util.List;

public class Sorteio {
    /**
     * Quantidade de elementos contidos na lista com os dados de sorteio.
     */
    public static final int NUMERO_ELEMENTOS = 16;

    short numero;

    String data;

    byte[] dezenas = new byte[6];

    int sena;

    String vSena;

    int quina;

    String vQuina;

    int quadra;

    String vQuadra;
    
    String acumulado;
    
    String valorAcumulado;

    /**
     * Obtem o valor do Sorteio em formato de texto.
     *
     * @return o valor do Sorteio em formato de texto.
     */
    public String toString() {
        DecimalFormat df4 = new DecimalFormat("000");
        DecimalFormat df2 = new DecimalFormat("00");
        
        String retorno = df4.format(numero) + "  ";
        for (int i = 0; i < 6; i++) {
            retorno = retorno + df2.format(dezenas[i]) + " ";
        }
        
        return retorno;
    }

    
    /**
     * Monta o Soteio com base na lista fornecida pela CEF.
     *
     * @param lista Os elementos desta lista são fornecidos na mesma ordem
     *        em que estão presentes no arquivo HTML disponibilizado pela CEF.
     *        Caso a ordem seja alterada, o código deste método também terá
     *        que ser alterado.
     * @return null, caso a lista não possua elementos suficientes para a
     *         construção de uma instância de Sorteio, ou a instância desejada.
     */
    public static Sorteio montaSorteio(List lista) {
        if (lista.size() < NUMERO_ELEMENTOS) { 
            return null; 
        }

        Sorteio s = new Sorteio();
        s.setNumero(Short.parseShort((String)lista.get(0)));
        s.setData((String)lista.get(1));

        byte[] dzns = new byte[6];
        for (int i = 0; i < 6; i++) {
            dzns[i] = Byte.parseByte((String)lista.get(2 + i));
        }
        s.setDezenas(dzns);

        s.setSena(Integer.parseInt((String)lista.get(8)));
        s.setVSena((String)lista.get(9));

        s.setQuina(Integer.parseInt((String)lista.get(10)));
        s.setVQuina((String)lista.get(11));

        s.setQuadra(Integer.parseInt((String)lista.get(12)));
        s.setVQuadra((String)lista.get(13));
        
        s.setAcumulado((String)lista.get(14));
        s.setValorAcumulado((String)lista.get(15));

        return s;
    }

    /**
     * Obtém o valor de data.
     *
     * @return Retorna a data.
     */
    public String getData() {
        return data;
    }

    /**
     * Substitui o valor de data.
     *
     * @param data Data a ser inserida.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Obtém o valor de dezenas.
     *
     * @return Retorna as dezenas.
     */
    public byte[] getDezenas() {
        return dezenas;
    }

    /**
     * Substitui o valor de dezenas.
     *
     * @param dezenas As dezenas a serem inseridas.
     */
    public void setDezenas(byte[] dezenas) {
        this.dezenas = dezenas;
    }

    /**
     * Obtém o valor de numero.
     *
     * @return Retorna o numero.
     */
    public short getNumero() {
        return numero;
    }

    /**
     * Substitui o valor de número.
     *
     * @param numero O número a ser inserido.
     */
    public void setNumero(short numero) {
        this.numero = numero;
    }

    /**
     * Obtém o valor de quadra.
     *
     * @return Retorna a quadra.
     */
    public int getQuadra() {
        return quadra;
    }

    /**
     * Substitui o valor de quadra.
     *
     * @param quadra Quadra a ser inserida.
     */
    public void setQuadra(int quadra) {
        this.quadra = quadra;
    }

    /**
     * Obtém o valor de quina.
     *
     * @return Retorna a quina.
     */
    public int getQuina() {
        return quina;
    }

    /**
     * Substitui o valor de quina.
     *
     * @param quina A quina a ser inserida.
     */
    public void setQuina(int quina) {
        this.quina = quina;
    }

    /**
     * Obtém o valor de sena.
     *
     * @return Retorna a sena.
     */
    public int getSena() {
        return sena;
    }

    /**
     * Substitui o valor de sena.
     *
     * @param sena O novo valor de sena.
     */
    public void setSena(int sena) {
        this.sena = sena;
    }

    /**
     * Obtém o valor de vQuadra.
     *
     * @return Retorna a vQuadra.
     */
    public String getVQuadra() {
        return vQuadra;
    }

    /**
     * Substitui o valor de vQuadra.
     *
     * @param quadra O novo valor de quadra.
     */
    public void setVQuadra(String quadra) {
        vQuadra = quadra;
    }

    /**
     * Obtém o valor de vQuina.
     *
     * @return Retorna a vQuina.
     */
    public String getVQuina() {
        return vQuina;
    }

    /**
     * Substitui o valor de vQuina.
     *
     * @param quina O novo valor de vQuina.
     */
    public void setVQuina(String quina) {
        vQuina = quina;
    }

    /**
     * Obtém o valor de vSena.
     *
     * @return Retorna a vSena.
     */
    public String getVSena() {
        return vSena;
    }

    /**
     * Substitui o valor de vSena.
     *
     * @param sena O novo valor de vSena.
     */
    public void setVSena(String sena) {
        vSena = sena;
    }

    /**
     * Obtém o Acumulado.
     *
     * @return Retorna o acumulado.
     */
    public String getAcumulado() {
        return acumulado;
    }

    /**
     * Substitui o valor de Acumulado.
     *
     * @param acumulado O novo valor de acumulado.
     */
    public void setAcumulado(String acumulado) {
        this.acumulado = acumulado;
    }

    /**
     * Obtém o Valor Acumulado.
     *
     * @return Retorna o valor Acumulado.
     */
    public String getValorAcumulado() {
        return valorAcumulado;
    }

    /**
     * Substitui o Valor Acumulado.
     *
     * @param valorAcumulado O novo valor Acumulado.
     */
    public void setValorAcumulado(String valorAcumulado) {
        this.valorAcumulado = valorAcumulado;
    }
}