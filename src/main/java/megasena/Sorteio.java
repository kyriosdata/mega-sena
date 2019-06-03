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
     * @param lista Os elementos desta lista são fornecidos na mesma ordem
     *        em que estão presentes no arquivo HTML disponibilizado pela CEF.
     *        Caso a ordem seja alterada, o código deste método também terá
     *        que ser alterado.
     * @return null caso a lista não possua elementos suficientes para a construção
     *         de uma instância de Sorteio, ou a instância desejada.
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
     * @return Returns the data.
     */
    public String getData() {
        return data;
    }

    /**
     * @param data
     *            The data to set.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return Returns the dezenas.
     */
    public byte[] getDezenas() {
        return dezenas;
    }

    /**
     * @param dezenas
     *            The dezenas to set.
     */
    public void setDezenas(byte[] dezenas) {
        this.dezenas = dezenas;
    }

    /**
     * @return Returns the numero.
     */
    public short getNumero() {
        return numero;
    }

    /**
     * @param numero
     *            The numero to set.
     */
    public void setNumero(short numero) {
        this.numero = numero;
    }

    /**
     * @return Returns the quadra.
     */
    public int getQuadra() {
        return quadra;
    }

    /**
     * @param quadra
     *            The quadra to set.
     */
    public void setQuadra(int quadra) {
        this.quadra = quadra;
    }

    /**
     * @return Returns the quina.
     */
    public int getQuina() {
        return quina;
    }

    /**
     * @param quina
     *            The quina to set.
     */
    public void setQuina(int quina) {
        this.quina = quina;
    }

    /**
     * @return Returns the sena.
     */
    public int getSena() {
        return sena;
    }

    /**
     * @param sena
     *            The sena to set.
     */
    public void setSena(int sena) {
        this.sena = sena;
    }

    /**
     * @return Returns the vQuadra.
     */
    public String getVQuadra() {
        return vQuadra;
    }

    /**
     * @param quadra
     *            The vQuadra to set.
     */
    public void setVQuadra(String quadra) {
        vQuadra = quadra;
    }

    /**
     * @return Returns the vQuina.
     */
    public String getVQuina() {
        return vQuina;
    }

    /**
     * @param quina
     *            The vQuina to set.
     */
    public void setVQuina(String quina) {
        vQuina = quina;
    }

    /**
     * @return Returns the vSena.
     */
    public String getVSena() {
        return vSena;
    }

    /**
     * @param sena
     *            The vSena to set.
     */
    public void setVSena(String sena) {
        vSena = sena;
    }
    /**
     * @return Returns the acumulado.
     */
    public String getAcumulado() {
        return acumulado;
    }
    /**
     * @param acumulado The acumulado to set.
     */
    public void setAcumulado(String acumulado) {
        this.acumulado = acumulado;
    }
    /**
     * @return Returns the valorAcumulado.
     */
    public String getValorAcumulado() {
        return valorAcumulado;
    }
    /**
     * @param valorAcumulado The valorAcumulado to set.
     */
    public void setValorAcumulado(String valorAcumulado) {
        this.valorAcumulado = valorAcumulado;
    }
}