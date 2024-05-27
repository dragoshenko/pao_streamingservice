package service.impl;

import model.Album;
import service.ServiciuStreamingService;

public class ServiciuStreamingServiceImpl implements ServiciuStreamingService {
    @Override
    public double calculeazaProfit(Album album, String platforma) {
        double tarifPerStream;
        switch (platforma.toLowerCase()) {
            case "spotify":
                tarifPerStream = 0.003;
                break;
            case "apple music":
                tarifPerStream = 0.005;
                break;
            case "tidal":
                tarifPerStream = 0.013;
                break;
            default:
                System.out.println("Platforma de streaming necunoscuta.");
                return 0;
        }

        double profit = tarifPerStream * album.getNumarTotalStreamuri();

        return profit;


    }
}
