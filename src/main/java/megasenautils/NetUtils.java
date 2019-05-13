package megasenautils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.zip.ZipInputStream;

/**
 *
 * @author kyrios
 */
public class NetUtils {

    public static int percorreUrl(String endereco) {
        ZipInputStream zip = null;
        BufferedReader br = null;
        try {
            URL url = new URL(endereco);
            zip = new ZipInputStream(url.openStream());
            zip.getNextEntry();
            br = new BufferedReader(new InputStreamReader(zip));
            String linha = null;
            while ((linha = br.readLine()) != null) {
                FormatoArquivoMegaSenaCaixa.processaLinha(linha);
            }
        } catch (MalformedURLException mfue) {
            return 1;
        } catch (UnknownHostException unhe) {
            return 2;
        } catch (IOException ioe) {
            return 3;
        } finally {
            if (zip != null) {
                try {
                    zip.close();
                } catch (IOException ioe) {
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ioe) {
                }
            }
        }
        return 0;
    }
}
