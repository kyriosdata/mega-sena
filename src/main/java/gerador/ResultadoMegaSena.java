/*
 * Copyright (c) 2018.
 *
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 *
 */

package gerador;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/**
 * Esta classe é base responsável pelo armazenamento das informações
 * do resultado da mega sena.
 *
 * @author Administrator e
 * <a href="https://github.com/gustavohenriquerssilva">gustavohenriquerssilva</a>
 * @version 1.1
 */
class ResultadoMegaSena implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    short concurso;

    Date data;

    int[] dezenas = new int[6];

    int ganhadoresSena;

    float rateioSena;

    int ganhadoresQuina;

    float rateioQuina;

    int ganhadoresQuadra;

    float rateioQuadra;

    boolean acumulado;

    float valorAcumulado;

    /**
     * Defini a string de saída quando for imprimir o
     * objeto ou converte-lo para String
     *
     * @return texto relacionado ao objeto
     */
    public String toString() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
                new Locale("pt", "BR"));
        String data = df.format(this.data);
        Arrays.sort(dezenas);

        return String.format("%3d %s %02d %02d %02d %02d %02d %02d", concurso,
                data, dezenas[0], dezenas[1], dezenas[2], dezenas[3],
                dezenas[4], dezenas[5]);
    }

    /**
     * Modifica o nome do concurso realizado
     *
     * @param concurso nome do concurso realizado
     */
    void setConcurso(String concurso) {
        this.concurso = Short.parseShort(concurso);
    }


    /**
     * Modifica a data do resultado do concurso realizado
     *
     * @return data do resultado do concurso realizado
     */
    void setData(String data) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
                new Locale("pt", "BR"));
        try {
            this.data = df.parse(data);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            this.data = new Date();
        }
    }

    /**
     * Modifica o valor da dezena
     *
     * @param d O valor da dezena que quer inserir
     * @param i A posição da dezena o qual quer modificar
     */
    void setDezena(String d, int i) {
        dezenas[i - 1] = Integer.parseInt(d);
    }

    /**
     * Modifica o ganhadores da sena
     *
     * @param ganhadores Os ganhadores da sena a serem inseridos
     */
    void setGanhadoresSena(String ganhadores) {
        this.ganhadoresSena = Integer.parseInt(ganhadores);
    }

    /**
     * Converte o valor do tipo String para o tipo int
     *
     * @param rateioSena O rateio da sena
     *
     * @throws ParseException Se o valor não for possível
     * ser convertido para tipo inteiro
     */
    private float getFloatFromString(String rateioSena) {
        NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));
        float retorno = 0.0f;
        try {
            retorno = nf.parse(rateioSena).floatValue();
        } catch (ParseException e) {
            return 0.0f;
        }

        return retorno;
    }

    /**
     * Modifica o rateio da sena
     *
     *  @param rateioSena O rateio da sena a ser inserido
     */
    void setRateioSena(String rateioSena) {
        this.rateioSena = getFloatFromString(rateioSena);
    }

    /**
     * Modifica os ganhadores da quina
     *
     * @param ganhadores Os ganhadores da quina a serem inseridos
     */
    void setGanhadoresQuina(String ganhadores) {
        this.ganhadoresQuina = Integer.parseInt(ganhadores);
    }

    /**
     * Modifica o rateio da quina
     *
     * @param rateioQuina O valor do rateio da quina a ser inserido
     */
    void setRateioQuina(String rateioQuina) {
        this.rateioQuina = getFloatFromString(rateioQuina);
    }

    /**
     * Modifica o valor dos ganhadores da quadra
     *
     * @param ganhadores Os ganhadores da quadra a serem inseridos
     */
    void setGanhadoresQuadra(String ganhadores) {
        this.ganhadoresQuadra = Integer.parseInt(ganhadores);
    }

    /**
     * Modifica o rateio da quadra
     *
     * @param rateioQuadra O rateio da quadra a ser inserido
     */
    void setRateioQuadra(String rateioQuadra) {
        this.rateioQuadra = getFloatFromString(rateioQuadra);
    }

    /**
     * Modifica o status da acumulação, tendo que essa acumulação
     * é do tipo booleano
     *
     * @param acumulado O status do acumulado a ser inserido
     */
    void setAcumulado(String acumulado) {
        this.acumulado = acumulado.equals("SIM") ? true : false;
    }

    /**
     * Modifica o valor acumulado
     *
     * @param valorAcumulado O valor acumulado a ser inserido
     */
    void setValorAcumulado(String valorAcumulado) {
        this.valorAcumulado = getFloatFromString(valorAcumulado);
    }

    /**
     * Obtém a informação se o sorteio está acumulado
     *
     * @return Retorna true se o valor estiver acumulado
     */
    public boolean isAcumulado() {
        return acumulado;
    }

    /**
     * Modifica o status da acumulação, tendo que essa acumulação é do tipo String
     *
     * @param acumulado O status do acumulado a ser inserido
     */
    public void setAcumulado(boolean acumulado) {
        this.acumulado = acumulado;
    }

    /**
     * Obtém concurso realizado
     *
     * @return O concurso realizado
     */
    public short getConcurso() {
        return concurso;
    }

    /**
     * Modifica o concurso que está sendo realizado
     *
     *  @param concurso O concurso realizado
     */
    public void setConcurso(short concurso) {
        this.concurso = concurso;
    }

    /**
     * Obtém a data do resultado do concurso realizado
     *
     * @return O data do resultado do concurso realizado
     */
    public Date getData() {
        return data;
    }

    /**
     * Modifica a data do resultado do concurso realizado
     *
     * @return data do resultado do concurso realizado
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Obtém dezenas do concurso realizado
     *
     * @return As dezenas do concurso realizado
     */
    public int[] getDezenas() {
        return dezenas;
    }

    /**
     * Modifica o valor da dezena
     */
    public void setDezenas(int[] dezenas) {
        this.dezenas = dezenas;
    }

    /**
     * Obtém ganhadores da quadra
     *
     * @return Os ganhadores da quadra
     */
    public int getGanhadoresQuadra() {
        return ganhadoresQuadra;
    }

    /**
     * Modifica o valor dos ganhadores da quadra
     *
     * @param ganhadoresQuadra Os ganhadores da quadra a serem inseridos
     */
    public void setGanhadoresQuadra(int ganhadoresQuadra) {
        this.ganhadoresQuadra = ganhadoresQuadra;
    }

    /**
     * Obtém ganhadores da quina
     *
     * @return Os ganhadores da quina
     */
    public int getGanhadoresQuina() {
        return ganhadoresQuina;
    }

    /**
     * Modifica os ganhadores da quina
     *
     * @param ganhadoresQuina Os ganhadores da quina a serem inseridos
     */
    public void setGanhadoresQuina(int ganhadoresQuina) {
        this.ganhadoresQuina = ganhadoresQuina;
    }

    /**
     * Obtém ganhadores da sena
     *
     * @return Os ganhadores da sena
     */
    public int getGanhadoresSena() {
        return ganhadoresSena;
    }

    /**
     * Modifica o ganhadores da sena
     *
     * @param ganhadoresSena Os ganhadores da sena a serem inseridos
     */
    public void setGanhadoresSena(int ganhadoresSena) {
        this.ganhadoresSena = ganhadoresSena;
    }

    /**
     * Obtém valor do rateio da quadra
     *
     * @return Valor do rateio da quadra
     */
    public float getRateioQuadra() {
        return rateioQuadra;
    }

    /**
     * Modifica o rateio da quadra
     *
     * @param rateioQuadra O rateio da quadra a ser inserido
     */
    public void setRateioQuadra(float rateioQuadra) {
        this.rateioQuadra = rateioQuadra;
    }

    /**
     * Obtém valor do rateio da quina
     *
     * @return Valor do rateio da quina
     */
    public float getRateioQuina() {
        return rateioQuina;
    }

    /**
     * Modifica o rateio da quina
     *
     * @param rateioQuina O valor do rateio da quina a ser inserido
     */
    public void setRateioQuina(float rateioQuina) {
        this.rateioQuina = rateioQuina;
    }

    /**
     * Obtém valor do rateio da sena
     *
     * @return Valor do rateio da sena
     */
    public float getRateioSena() {
        return rateioSena;
    }

    /**
     * Modifica o rateio da sena
     *
     *  @param rateioSena O rateio da sena a ser inserido
     */
    public void setRateioSena(float rateioSena) {
        this.rateioSena = rateioSena;
    }

    /**
     * Obtém valor acumulado do sorteio
     *
     * @return Valor acumulado do sorteio
     */
    public float getValorAcumulado() {
        return valorAcumulado;
    }

    /**
     * Modifica o valor acumulado
     *
     * @param valorAcumulado O valor acumulado a ser inserido
     */
    public void setValorAcumulado(float valorAcumulado) {
        this.valorAcumulado = valorAcumulado;
    }   
}
