/*
 * Copyright (c) 2018.
 *
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 *
 */

package megasena;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessaMegaSenaHTML {

    private static final String REGEX = "<td>.*</td>";

    private BufferedReader br = null;

    private Pattern pattern = null;

    private Matcher matcher = null;

    private List elementos = null;

    private IProcessaSorteio igr = null;

    public ProcessaMegaSenaHTML() {
        elementos = new ArrayList();
        pattern = Pattern.compile(REGEX);
    }

    public boolean processaHTML(String file, IProcessaSorteio i) {
        String line = null;
        igr = i;

        try {
            br = new BufferedReader(new FileReader(file));
            line = br.readLine();
            while (line != null) {
                processLine(line);
                line = br.readLine();
            }
        } catch (Exception fnfe) {
            return false;
        }

        try {
            br.close();
        } catch (Exception ioe) {
            return false;
        }

        return true;
    }

    private void processLine(String l) {
        int start = 0;
        int end = 0;
        String subString = null;
        matcher = pattern.matcher(l);

        while (matcher.find()) {
            start = matcher.start();
            end = matcher.end();
            subString = l.substring(start + 4, end - 5);
            adicionaString(subString);
        }
    }

    public void adicionaString(String elemento) {
        elementos.add(elemento);
        if (elementos.size() == megasena.Sorteio.NUMERO_ELEMENTOS) {
            megasena.Sorteio s = megasena.Sorteio.montaSorteio(elementos);
            elementos.clear();
            igr.processaSorteio(s);
        }
    }
}