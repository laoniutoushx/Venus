package sos.haruhi.crypto;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by SuzumiyaHaruhi on 2017/9/17.
 */
public class SequentialNAV extends AbstractNAV {
    public double computeNetAssetValue(Map<String, Integer> stocks) throws ExecutionException, InterruptedException, IOException {
        double netAssetValue = 0.0;
        for(String ticker : stocks.keySet()){
            netAssetValue += stocks.get(ticker) * YahooFinance.getPrice(ticker);
        }

        return netAssetValue;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        System.out.println("haruhi");
        new SequentialNAV().timeAndComputeValue();
    }
}
