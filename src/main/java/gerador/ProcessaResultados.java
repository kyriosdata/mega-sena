/*
 * Copyright (c) 2018.
 *
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 *
 */

package gerador;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ProcessaResultados {

    public static List<ResultadoMegaSena> getListFromFile(String fileName) {
        List<ResultadoMegaSena> lista = null;
        try {
            FileInputStream fis = new FileInputStream(new File(fileName));
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (List) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return lista;
    }
    
    public static void main(String[] args) {
        List<ResultadoMegaSena> lista = getListFromFile("/home/fabio/kyrios/tools/resultados.ser");
        float[] premios = new float[lista.size()];
        int i = -1;
        for (ResultadoMegaSena r : lista) {
            premios[++i] = r.getRateioSena();
        }
        
        System.out.println(premios.length);
        System.out.println(Arrays.toString(premios));
        printValores(premios);
    }
    
    static public void printValores(float[] valores) {
        int i = -1;
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        for (float f : valores) {
            System.out.printf("[%d] %s\n", ++i, nf.format(f));
        }
    }

}
