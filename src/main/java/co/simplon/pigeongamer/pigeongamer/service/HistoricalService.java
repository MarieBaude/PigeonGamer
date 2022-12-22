package co.simplon.pigeongamer.pigeongamer.service;

import java.util.List;

import co.simplon.pigeongamer.pigeongamer.model.Historical;
import co.simplon.pigeongamer.pigeongamer.model.Product;

public interface HistoricalService {
	List < Historical > getAllHistorical();
    void saveHistorical(Historical historical);
    Historical getHistoricalById(long id_historical);
    void deleteHistoricalById(long id_historical);
}
