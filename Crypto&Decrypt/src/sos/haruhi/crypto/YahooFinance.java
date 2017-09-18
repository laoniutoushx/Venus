package sos.haruhi.crypto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by SuzumiyaHaruhi on 2017/9/17.
 */
public class YahooFinance {


    public static double getPrice(final String ticker) throws IOException {
        final URL url =
                new URL("http://ichart.finalce.yahoo.com/table.csv?s=" + ticker);

        final BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openStream()));


        final String discardHeader = reader.readLine();
        final String data = reader.readLine();
        final String[] dataItems = data.split(",");
        final double priceIsTheLastValue = Double.valueOf(dataItems[dataItems.length - 1]);

        return priceIsTheLastValue;
    }
}
