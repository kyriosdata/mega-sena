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

    public String toString() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
                new Locale("pt", "BR"));
        String data = df.format(this.data);
        Arrays.sort(dezenas);

        return String.format("%3d %s %02d %02d %02d %02d %02d %02d", concurso,
                data, dezenas[0], dezenas[1], dezenas[2], dezenas[3],
                dezenas[4], dezenas[5]);
    }

    void setConcurso(String concurso) {
        this.concurso = Short.parseShort(concurso);
    }

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

    void setDezena(String d, int i) {
        dezenas[i - 1] = Integer.parseInt(d);
    }

    void setGanhadoresSena(String ganhadores) {
        this.ganhadoresSena = Integer.parseInt(ganhadores);
    }

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

    void setRateioSena(String rateioSena) {
        this.rateioSena = getFloatFromString(rateioSena);
    }

    void setGanhadoresQuina(String ganhadores) {
        this.ganhadoresQuina = Integer.parseInt(ganhadores);
    }

    void setRateioQuina(String rateioQuina) {
        this.rateioQuina = getFloatFromString(rateioQuina);
    }

    void setGanhadoresQuadra(String ganhadores) {
        this.ganhadoresQuadra = Integer.parseInt(ganhadores);
    }

    void setRateioQuadra(String rateioQuadra) {
        this.rateioQuadra = getFloatFromString(rateioQuadra);
    }

    void setAcumulado(String acumulado) {
        this.acumulado = acumulado.equals("SIM") ? true : false;
    }

    void setValorAcumulado(String valorAcumulado) {
        this.valorAcumulado = getFloatFromString(valorAcumulado);
    }

    public boolean isAcumulado() {
        return acumulado;
    }

    public void setAcumulado(boolean acumulado) {
        this.acumulado = acumulado;
    }

    public short getConcurso() {
        return concurso;
    }

    public void setConcurso(short concurso) {
        this.concurso = concurso;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int[] getDezenas() {
        return dezenas;
    }

    public void setDezenas(int[] dezenas) {
        this.dezenas = dezenas;
    }

    public int getGanhadoresQuadra() {
        return ganhadoresQuadra;
    }

    public void setGanhadoresQuadra(int ganhadoresQuadra) {
        this.ganhadoresQuadra = ganhadoresQuadra;
    }

    public int getGanhadoresQuina() {
        return ganhadoresQuina;
    }

    public void setGanhadoresQuina(int ganhadoresQuina) {
        this.ganhadoresQuina = ganhadoresQuina;
    }

    public int getGanhadoresSena() {
        return ganhadoresSena;
    }

    public void setGanhadoresSena(int ganhadoresSena) {
        this.ganhadoresSena = ganhadoresSena;
    }

    public float getRateioQuadra() {
        return rateioQuadra;
    }

    public void setRateioQuadra(float rateioQuadra) {
        this.rateioQuadra = rateioQuadra;
    }

    public float getRateioQuina() {
        return rateioQuina;
    }

    public void setRateioQuina(float rateioQuina) {
        this.rateioQuina = rateioQuina;
    }

    public float getRateioSena() {
        return rateioSena;
    }

    public void setRateioSena(float rateioSena) {
        this.rateioSena = rateioSena;
    }

    public float getValorAcumulado() {
        return valorAcumulado;
    }

    public void setValorAcumulado(float valorAcumulado) {
        this.valorAcumulado = valorAcumulado;
    }   
}
